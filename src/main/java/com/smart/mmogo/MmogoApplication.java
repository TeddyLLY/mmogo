package com.smart.mmogo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@SpringBootApplication
public class MmogoApplication extends ServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(MmogoApplication.class, args);
	}

}
