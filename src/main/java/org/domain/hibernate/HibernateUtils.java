package org.domain.hibernate;

import org.domain.hibernate.entities.Person;
import org.domain.hibernate.entities.Phone;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

	private static String hibernateConnectionURL;
	private static SessionFactory sessionFactory;

	private static final String URL_PREFIX = "jdbc:log4jdbc:h2:tcp://";
//	private static final String URL_PREFIX = "jdbc:h2:tcp://";
	private static final String DOMAIN = "localhost";
	private static final String COLON = ":";
	private static final String PORT = "64000";
	private static final String SLASH = "/";
	private static final String DB_NAME = "H2_Hibernate";

	private static final String HIBERNATE_CONNECTION_DRIVER_CLASS = "net.sf.log4jdbc.sql.jdbcapi.DriverSpy";
//	private static final String HIBERNATE_CONNECTION_DRIVER_CLASS = "org.h2.Driver";
	private static final String HIBERNATE_CONNECTION_USERNAME = "sa";
	private static final String HIBERNATE_CONNECTION_PASSWORD = "";
	private static final String HIBERNATE_DIALECT = "org.hibernate.dialect.H2Dialect";
	private static final String HIBERNATE_AUTOCOMMIT = "false";
	// Values: validate, create, update, create-drop
	private static final String HIBERNATE_HBM_2_DDL_AUTO = "create";
	private static final String HIBERNATE_CURRENT_SESSION_CONTEXT_CLASS = "thread";
	private static final String HIBERNATE_SHOW_SQL = "true";

	static {
		/**
		 * Example: jdbc:log4jdbc:h2:tcp://domain:port/db_name
		 */
		StringBuilder builder = new StringBuilder();
		builder.append(URL_PREFIX)
				.append(DOMAIN)
				.append(COLON)
				.append(PORT)
				.append(SLASH)
				.append(DB_NAME);
		hibernateConnectionURL = builder.toString();

		Configuration configuration = new Configuration();
		configuration.setProperty("hibernate.connection.url", hibernateConnectionURL);
		configuration.setProperty("hibernate.connection.autocommit", HIBERNATE_AUTOCOMMIT);
		configuration.setProperty("hibernate.connection.driver_class", HIBERNATE_CONNECTION_DRIVER_CLASS);
		configuration.setProperty("hibernate.connection.username", HIBERNATE_CONNECTION_USERNAME);
		configuration.setProperty("hibernate.connection.password", HIBERNATE_CONNECTION_PASSWORD);
		configuration.setProperty("hibernate.dialect", HIBERNATE_DIALECT);
		configuration.setProperty("show_sql", HIBERNATE_SHOW_SQL);
		configuration.setProperty("hibernate.hbm2ddl.auto", HIBERNATE_HBM_2_DDL_AUTO);
		configuration.setProperty("hibernate.current_session_context_class", HIBERNATE_CURRENT_SESSION_CONTEXT_CLASS);

		configuration.addAnnotatedClass(Person.class);
		configuration.addAnnotatedClass(Phone.class);

		StandardServiceRegistryBuilder regBuilder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		sessionFactory = configuration.buildSessionFactory(regBuilder.build());
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void closeSessionFactory() {
		sessionFactory.close();
	}
}
