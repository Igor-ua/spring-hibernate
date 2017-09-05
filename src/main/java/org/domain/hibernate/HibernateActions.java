package org.domain.hibernate;

import org.domain.hibernate.entities.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class HibernateActions {

	private SessionFactory sf = HibernateUtils.getSessionFactory();

	public void run() {
		try {
			case_1();
		} finally {
			HibernateUtils.closeSessionFactory();
		}
	}

	private void case_1() {
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		Person person = new Person();
		person.setName("Mike");
		session.save(person);
		transaction.commit();

		session = sf.openSession();
		session.createQuery("FROM Person").list();
		session.close();
	}
}
