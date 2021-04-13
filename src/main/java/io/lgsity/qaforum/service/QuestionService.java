package io.lgsity.qaforum.service;

import io.lgsity.qaforum.dto.PageInationDTO;
import io.lgsity.qaforum.dto.QuestionDTO;
import io.lgsity.qaforum.mapper.QuestionMapper;
import io.lgsity.qaforum.mapper.UserMapper;
import io.lgsity.qaforum.pojo.Question;
import io.lgsity.qaforum.pojo.User;
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

    public PageInationDTO conformQuestionDTO(Integer page, Integer size) {

        PageInationDTO pageInationDTO = new PageInationDTO();
        Integer totalCount = questionMapper.count();
        pageInationDTO.setPageInation(totalCount, page, size);
        if (page < 1) {
            page = 1;
        }
        if (page > pageInationDTO.getTotalPage()) {
            page = pageInationDTO.getTotalPage();
        }

        //size*(page-1)
        Integer offset = size * (page - 1);

        List<Question> questionList = questionMapper.findAll(offset, size);
        List<QuestionDTO> questionDTOList = new ArrayList<>();


        for (Question question : questionList
        ) {
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);
            User user = userMapper.findUserById(question.getCreator());
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        pageInationDTO.setQuestionDTOList(questionDTOList);


        return pageInationDTO;
    }

}
