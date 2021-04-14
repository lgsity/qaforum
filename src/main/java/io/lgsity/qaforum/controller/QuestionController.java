package io.lgsity.qaforum.controller;

import io.lgsity.qaforum.dto.QuestionDTO;
import io.lgsity.qaforum.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author shulinYuan
 * @Date 2021/4/13 19:06
 * @Version 1.0
 */
@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/question/{id}")
    public String question(@PathVariable("id") Integer id,
                           Model model){
        QuestionDTO questionDTO = questionService.getQuestionDTOByQuestionId(id);
        questionService.incViewCount(id);
        model.addAttribute("question",questionDTO);
        return "question";
    }
}
