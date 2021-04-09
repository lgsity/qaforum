package io.lgsity.qaforum.controller;

import io.lgsity.qaforum.mapper.QuestionMapper;
import io.lgsity.qaforum.mapper.UserMapper;
import io.lgsity.qaforum.pojo.Question;
import io.lgsity.qaforum.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author shulinYuan
 * @Date 2021/4/9 19:34
 * @Version 1.0
 */
@Controller
public class PublishController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionMapper questionMapper;

    @GetMapping("/publish")
    public String pulish(){
        return "publish";
    }
    @PostMapping("/publish")
    public String doPulish(@RequestParam("title") String title,
                           @RequestParam("description") String description,
                           @RequestParam("description") String tag,
                           HttpServletRequest request,
                           Model model){
        User user = null;
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie:cookies
        ) {
            if ("token".equals(cookie.getName())) {
                String token = cookie.getValue();
                user = userMapper.findUserByToken(token);
                if (user != null) {
                    request.getSession().setAttribute("user", user);
                }
                break;
            }
        }
         if(user == null){
             model.addAttribute("error","用户未登录");
             return "/publish";
         }
        Question question = new Question();
        question.setTitle(title);
        question.setDescription(description);
        question.setGmtCreate(System.currentTimeMillis());
        question.setGmtModified(question.getGmtCreate());
        question.setCreator(user.getId());
        question.setTag(tag);
        questionMapper.insert(question);
        return "redirect:/";
    }
}
