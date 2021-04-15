package io.lgsity.qaforum.controller;

import io.lgsity.qaforum.dto.CommentDTO;
import io.lgsity.qaforum.dto.QuestionDTO;
import io.lgsity.qaforum.service.CommentService;
import io.lgsity.qaforum.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @Author shulinYuan
 * @Date 2021/4/13 19:06
 * @Version 1.0
 */
@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private CommentService commentService;

    @GetMapping("/question/{id}")
    public String question(@PathVariable("id") Long id,
                           Model model){
        QuestionDTO questionDTO = questionService.getQuestionDTOByQuestionId(id);
        List<CommentDTO> comments = commentService.selListByQId(id);
        //累加阅读数
        questionService.incViewCount(id);
        model.addAttribute("question",questionDTO);
        model.addAttribute("comments",comments);
        return "question";
    }
}
