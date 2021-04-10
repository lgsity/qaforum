package io.lgsity.qaforum.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import io.lgsity.qaforum.dto.QuestionDTO;
import io.lgsity.qaforum.mapper.QuestionMapper;
import io.lgsity.qaforum.mapper.UserMapper;
import io.lgsity.qaforum.pojo.Question;
import io.lgsity.qaforum.pojo.User;
import io.lgsity.qaforum.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author shulinYuan
 * @Date 2021/4/7 16:11
 * @Version 1.0
 */
@Controller
public class IndexController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(HttpServletRequest request, Model model) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length != 0){
            for (Cookie cookie : cookies
            ) {
                if ("token".equals(cookie.getName())) {
                    String token = cookie.getValue();
                    User user = userMapper.findUserByToken(token);
                    if (user != null) {
                        request.getSession().setAttribute("user", user);
                    }
                    break;
                }
            }
        }
        List<Question> questionList = questionMapper.findAll();
        List<QuestionDTO> questionDTOList = questionService.conformQuestionDTO(questionList);
        model.addAttribute("questionDTOList",questionDTOList);
        return "index";
    }
}
