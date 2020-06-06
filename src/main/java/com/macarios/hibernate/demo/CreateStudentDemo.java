package com.macarios.hibernate.demo;

import com.macarios.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {
	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
				.configure()
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create a session
		Session session = factory.getCurrentSession();

		try {
			// create a Student object
			Student tempStudent = new Student("Victor", "Macarios", "vmacarios@gmail.com");

			// start a transaction
			session.beginTransaction();

			// save the Student object
			session.save(tempStudent);

			// commit transaction
			session.getTransaction().commit();

		} finally {
			factory.close();
		}
	}
}
