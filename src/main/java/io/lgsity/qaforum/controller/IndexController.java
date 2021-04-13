package io.lgsity.qaforum.controller;

import io.lgsity.qaforum.dto.PageInationDTO;
import io.lgsity.qaforum.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author shulinYuan
 * @Date 2021/4/7 16:11
 * @Version 1.0
 */
@Controller
public class IndexController {



    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(Model model,
                        @RequestParam(name = "page",defaultValue = "1") Integer page,
                        @RequestParam(name = "size",defaultValue = "5") Integer size) {


        PageInationDTO pageInationDTO = questionService.conformQuestionDTO(page,size);
        model.addAttribute("pageInationDTO",pageInationDTO);
        return "index";
    }
}
