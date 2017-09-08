package org.domain.hibernate;

import org.domain.hibernate.entities.Person;
import org.domain.hibernate.entities.Phone;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import java.util.List;

public class HibernateActions {

	private SessionFactory sf = HibernateUtils.getSessionFactory();
	private Session session;
	private EntityManager em;
	private Person person;

	public HibernateActions() {
		this.person = new Person();
		this.person.setName("Mike");
		this.person.addPhone(new Phone("+38099888777666"));
		this.person.addPhone(new Phone("+38099888555444"));
	}

	public void run() {
		try {
			case_1();
			case_2();
			case_3();
		} finally {
			HibernateUtils.closeSessionFactory();
		}
	}

	private void case_1() {
		session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(person);
		tx.commit();
		session.close();
	}

	private void case_2() {
		session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.createQuery("FROM Person").list();
		tx.commit();
		session.close();
	}

	private void case_3() {
		session = sf.openSession();
		Transaction tx = session.beginTransaction();
		List<Person> persons = session.createQuery("FROM Person WHERE id=1").list();
		System.out.println(persons);
		tx.commit();
		session.close();
	}
}
