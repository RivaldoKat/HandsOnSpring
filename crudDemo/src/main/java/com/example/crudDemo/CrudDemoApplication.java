package com.example.crudDemo;

import com.example.crudDemo.dao.StudentDAO;
import com.example.crudDemo.entitty.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

		return runner -> {
//			createStudent(studentDAO);
			createMultipleStudents(studentDAO);
//			readStudent(studentDAO);
//			queryForStudents(studentDAO);
//			queryForStudentByLastName(studentDAO);
//			updateStudent(studentDAO);
//			deleteStudent(studentDAO);
//			deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {

		System.out.println("Deleting all student");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count: " + numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {

		int studentId = 3;
		System.out.println("Deleting student ID: " + studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {

		// retrieve student based on the id: primary key
		int studentId = 1;

		System.out.println("Getting student with id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);

		// change first name
		System.out.println("Updating student ...");
		myStudent.setFirstName("Thabang");

		// update the student
		studentDAO.update(myStudent);

		// display the updated student
		System.out.println("Updated student: " + myStudent);

	}

	private void queryForStudentByLastName(StudentDAO studentDAO) {

		// geta list of students
		List<Student> theStudent = studentDAO.findByLastName("Sekome");

		// display list of students
		for (Student tempStudent: theStudent) {
			System.out.println(tempStudent);
		}

	}

	private void queryForStudents(StudentDAO studentDAO) {

		// get list of students
		List<Student> theStudents = studentDAO.findAll();

		// display list of students
		for (Student tempStudent: theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println("Fetching student ....");
		System.out.println(studentDAO.findById(1));

	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		//create multiple students
		System.out.println("Creating new student object ....");
		Student tempStudent1 = new Student("Katlego", "Depp", "kat25@gmail.com");
		Student tempStudent2 = new Student("Katlego", "Bongs", "Bongs25@gmail.com");
		Student tempStudent3 = new Student("Kat", "Reach", "Guy25@gmail.com");

		// save the students objects
		System.out.println("Saving the student ....");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

	}

	private void createStudent(StudentDAO studentDAO) {

		// create the student object
		System.out.println("Creating new student object ....");
		Student tempStudent = new Student("Rivaldo", "Sekome", "rivaldokat25@gmail.com");

		// save the student object
		System.out.println("Saving the student ....");
		studentDAO.save(tempStudent);

		// display id of the saved student
		System.out.println("Saved student, Generate id: " + tempStudent.getId());
	}

}
