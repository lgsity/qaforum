package io.lgsity.qaforum.advice;

import io.lgsity.qaforum.exception.CustomizeException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author shulinYuan
 * @Date 2021/4/14 17:19
 * @Version 1.0
 */
@ControllerAdvice
public class CustomizeExceptionHandler {

    @ExceptionHandler(Exception.class)
    ModelAndView handleControllerException(Throwable e, Model model) {
        if (e instanceof CustomizeException){
            model.addAttribute("message",e.getMessage());
        }else {
            model.addAttribute("message","服务器冒烟了，请稍后再来试试吧！");
        }
        return new ModelAndView("error");
    }


}


