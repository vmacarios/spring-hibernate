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
			Student student1 = new Student("Victor", "Macarios", "vmacarios@gmail.com");
			Student student2 = new Student("Sergio", "Persil", "sergio@gmail.com");
			Student student3 = new Student("Bruno", "Vital", "bruno@gmail.com");

			// start a transaction
			session.beginTransaction();

			// save the Student object
			session.save(student1);
			session.save(student2);
			session.save(student3);

			// commit transaction
			session.getTransaction().commit();

			// retrieve objects
			// find out the student id
			System.out.println("Student ID: " + student3.getId());

			// get a new session and start a transaction
			session = factory.getCurrentSession();
			session.beginTransaction();

			// retrieve student based on id
			Student myStudent = session.get(Student.class, student3.getId());
			System.out.println(myStudent.toString());

			// commit the transaction
			session.getTransaction().commit();


		} finally {
			factory.close();
		}
	}
}
