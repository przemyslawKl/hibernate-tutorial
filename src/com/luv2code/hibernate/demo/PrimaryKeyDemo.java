package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {

		
		// create session factory
				SessionFactory factory = new Configuration()
											.configure("hibernate.cfg.xml")
											.addAnnotatedClass(Student.class)
											.buildSessionFactory();
				// create session
				Session session = factory.getCurrentSession();
				
				try {
					// create a 4 students object
					System.out.println("Creating 3 new student object ....");
					Student tempStudent1 = new Student ("Grzegorz", "Blaszczykowski", "gb@luv2code.com");
					Student tempStudent2 = new Student ("Andrzej", "Lewandowski", "al@luv2code.com");
					Student tempStudent3 = new Student ("Liwa", "Dawidowicz", "ld@luv2code.com");
					Student tempStudent4 = new Student ("Gosc", "Szczecinski", "gs@luv2code.com");

					
					// start a transaction
					session.beginTransaction();
					
					// save the students object
					System.out.println("Saving the student...");
					session.save(tempStudent1);
					session.save(tempStudent2);
					session.save(tempStudent3);
					session.save(tempStudent4);

					
					// commit transaction
					session.getTransaction().commit();
					System.out.println("Done !");
				}
				finally{
					factory.close();
				}

	}

}
