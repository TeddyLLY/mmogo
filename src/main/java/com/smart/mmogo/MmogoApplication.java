package com.smart.mmogo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@SpringBootApplication
public class MmogoApplication extends ServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(MmogoApplication.class, args);
	}

	@RequestMapping("/")
	@ResponseBody
	public ModelAndView initPage() {
		ModelAndView mav = new ModelAndView("redirect:/hello");
		return mav;
	}

}
