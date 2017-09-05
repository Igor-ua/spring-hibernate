package org.domain.spring.beans;

import org.springframework.stereotype.Component;

@Component
public class Printer {
	public void printMessage() {
		System.out.println("printMessage");
	}
}
