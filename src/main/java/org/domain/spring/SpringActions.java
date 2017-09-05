package org.domain.spring;

import org.domain.Main;
import org.domain.spring.beans.Printer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class SpringActions {
	public void run() {
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringActions.class);
		Printer utils = context.getBean(Printer.class);
		utils.printMessage();
	}
}