package com.smart.mmogo.controller.mongo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class IndexController {
    @RequestMapping("/")
    public ModelAndView index() throws Exception{
        ModelAndView mav = new ModelAndView("redirect:/api/employees/get");
        return mav;
    }

    @RequestMapping("/hello")
    public String hello() {
        return "hello world!";
    }
}
