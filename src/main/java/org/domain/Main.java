package org.domain;

import org.domain.hibernate.HibernateActions;
import org.domain.spring.SpringActions;

/**
 * Entry point of the application
 */
public class Main {

	public static void main(String[] args) {
		SpringActions springActions = new SpringActions();
		springActions.run();
		HibernateActions hibernateActions = new HibernateActions();
		hibernateActions.run();
	}
}