package io.lgsity.qaforum.service;

import io.lgsity.qaforum.dto.PageInationDTO;
import io.lgsity.qaforum.dto.QuestionDTO;
import io.lgsity.qaforum.exception.CustomizeErrorCode;
import io.lgsity.qaforum.exception.CustomizeException;
import io.lgsity.qaforum.exception.ICustomizeErrorCode;
import io.lgsity.qaforum.mapper.QuestionExtMapper;
import io.lgsity.qaforum.mapper.QuestionMapper;
import io.lgsity.qaforum.mapper.UserMapper;
import io.lgsity.qaforum.pojo.Question;
import io.lgsity.qaforum.pojo.QuestionExample;
import io.lgsity.qaforum.pojo.User;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author shulinYuan
 * @Date 2021/4/10 16:33
 * @Version 1.0
 */
@Service
public class QuestionService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private QuestionExtMapper questionExtMapper;

    public PageInationDTO conformQuestionDTO(Integer page, Integer size) {

        PageInationDTO pageInationDTO = new PageInationDTO();
        Integer totalPage;
        Integer totalCount = (int) questionMapper.countByExample(new QuestionExample());
        //计算页数
        if (totalCount % size == 0) {
            totalPage = totalCount / size;
        } else {
            totalPage = totalCount / size + 1;
        }
        if (page < 1) {
            page = 1;
        }
        if (page > totalPage && totalPage != 0) {
            page = totalPage;
        }
        pageInationDTO.setPageInation(totalPage, page);
        //size*(page-1)
        Integer offset = size * (page - 1);
        List<Question> questionList = questionMapper.selectByExampleWithRowbounds(new QuestionExample(), new RowBounds(offset, size));
        List<QuestionDTO> questionDTOList = new ArrayList<>();


        for (Question question : questionList
        ) {
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);
            User user = userMapper.selectByPrimaryKey(question.getCreator());
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        pageInationDTO.setQuestionDTOList(questionDTOList);


        return pageInationDTO;
    }

    public PageInationDTO findQuestionByUserId(Integer id, Integer page, Integer size) {
        PageInationDTO pageInationDTO = new PageInationDTO();
        Integer totalPage;
        QuestionExample example = new QuestionExample();
        example.createCriteria()
                .andIdEqualTo(id);
        Integer totalCount = (int)questionMapper.countByExample(example);
        //计算页数
        if (totalCount % size == 0) {
            totalPage = totalCount / size;
        } else {
            totalPage = totalCount / size + 1;
        }
        if (page < 1) {
            page = 1;
        }
        if (page > totalPage && totalPage != 0) {
            //p=1.t=0----->p=t=0
            page = totalPage;
        }

        pageInationDTO.setPageInation(totalPage, page);
        //size*(page-1)
        Integer offset = size * (page - 1);
        QuestionExample questionExample = new QuestionExample();
        questionExample.createCriteria()
                .andCreatorEqualTo(id);
        List<Question> questionList = questionMapper.selectByExampleWithRowbounds(questionExample, new RowBounds(offset, size));
        List<QuestionDTO> questionDTOList = new ArrayList<>();


        for (Question question : questionList
        ) {
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);
            User user = userMapper.selectByPrimaryKey(question.getCreator());
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        pageInationDTO.setQuestionDTOList(questionDTOList);


        return pageInationDTO;
    }

    public QuestionDTO getQuestionDTOByQuestionId(Integer id) {
        Question question = questionMapper.selectByPrimaryKey(id);
        if(question == null){
            throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
        }
        QuestionDTO questionDTO = new QuestionDTO();
        BeanUtils.copyProperties(question, questionDTO);
        User user = userMapper.selectByPrimaryKey(question.getCreator());
        questionDTO.setUser(user);

        return questionDTO;
    }

    public void createOrUpdate(Question question) {
        if (question.getId() == null) {
            //新发布提问
            question.setGmtCreate(System.currentTimeMillis());
            question.setGmtModified(question.getGmtCreate());
            questionMapper.insert(question);
        } else {
            //修改已有提问
            Question updateQuestion = new Question();
            updateQuestion.setGmtModified(System.currentTimeMillis());
            updateQuestion.setTag(question.getTag());
            updateQuestion.setDescription(question.getDescription());
            updateQuestion.setTitle(question.getTitle());

            QuestionExample example = new QuestionExample();
            example.createCriteria()
                    .andIdEqualTo(question.getId());
            int updateIndex = questionMapper.updateByExampleSelective(updateQuestion, example);
            if(updateIndex != 1){
                throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
            }
        }
    }

    public void incViewCount(Integer id) {
        Question updateQuestion = new Question();
        updateQuestion.setViewCount(1);
        updateQuestion.setId(id);
        questionExtMapper.incViewCount(updateQuestion);
    }
}
