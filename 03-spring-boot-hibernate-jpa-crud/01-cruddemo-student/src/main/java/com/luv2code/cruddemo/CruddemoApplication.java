package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner (StudentDAO studentDAO){

		return runner->{
			//createStudent(studentDAO);

			createMultipleStudents(studentDAO);

			//readStudent(studentDAO);

			//queryForStudents(studentDAO);

			//queryForStudentsByLastName(studentDAO);

			//updateStudent(studentDAO);

			//removeStudent(studentDAO);

			//removeAllStudents(studentDAO);


		};
	}

	private void removeAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students...");
		int numRowsDeleted=studentDAO.deleteAll();
		System.out.println("Deleted row count: " +numRowsDeleted);
	}

	private void removeStudent(StudentDAO studentDAO) {

		int studentId=3;
		System.out.println("Deleting student with id: " + studentId);
		studentDAO.delete(studentId);

	}

	private void updateStudent(StudentDAO studentDAO) {

		//retrieve student base on the id: primary key
		int studentId=1;
		System.out.println("Getting student with id: " + studentId);
		Student myStudent=studentDAO.findById(studentId);

		//change first name to "Scooby"
		System.out.println("Updating student ...");
		myStudent.setFirstName("John");

		//update the student
		studentDAO.update(myStudent);

		//display the updated student
		System.out.println("Updated student: " + myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {

		//get a list of students
		List<Student> theStudents= studentDAO.findByLastName("Doe");

		//display list of students
		for(Student tempStudent:theStudents){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		//get a list of students
		List<Student> theStudents = studentDAO.findAll();

		//display list of students
		for (Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {

		//create a student object
		System.out.println("Creating  new student object ...");
		Student tempStudent= new Student("Daffy","Daffy@luv2code.com","Duck");

		//save teh student
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		//display id of the save student
		int theId=tempStudent.getId();
		System.out.println("Saved student. generated id: "+ theId);

		//retrieve student based on the id: primary key
		System.out.println("Retrieving the student with the given id: "+ theId);
		Student myStudent =studentDAO.findById(theId);

		//display the student
		System.out.println("Found the student: "+myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		//create multiple students
		System.out.println("Creating 3 student object ...");
		Student tempStudent1= new Student("John","john@luv2code.com","doe");
		Student tempStudent2= new Student("Mary","Mary@luv2code.com","public");
		Student tempStudent3= new Student("Bonita","Bonita@luv2code.com","applebum");

		//save the student objects
		System.out.println("Saving the students ...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);


	}

	private void createStudent(StudentDAO studentDAO) {

		//create the student object
		System.out.println("Creating the new student object ...");
		Student tempStudent= new Student("paul","paul@luv2code.com","doe");

		//save the student object
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		//display id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());

	}

}
