package za.ac.cput.service;

import za.ac.cput.domain.Course;
import za.ac.cput.domain.Student;
import za.ac.cput.factory.StudentFactory;
import za.ac.cput.repository.StudentRepository;

import java.time.LocalDate;

public class StudentService implements IStudentService {
    /// wrapper tha provides a service layer for the student repository. So that's you can use the factory and the repository in place for business logic
    //Create Read Update delD

    //repository
    private StudentRepository repository; ///NEED TO STORE THE DATA


    ///  constructor to initialize the repository
    public StudentService (){
      this.repository = StudentRepository.getRepository(); //get the repository
    }
    //create

    public Student create(String id, String firstName, String lastName, LocalDate dateOfBirth, Course course) {
        Student student = StudentFactory.create(id , firstName, lastName, dateOfBirth, course);
        return this.repository.create(student);
    }
}
