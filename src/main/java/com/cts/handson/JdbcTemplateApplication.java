package com.cts.handson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class JdbcTemplateApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(JdbcTemplateApplication.class, args);
		Menu menu = context.getBean(Menu.class);
		menu.displayMenu();

	}

}
