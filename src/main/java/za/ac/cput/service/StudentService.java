package za.ac.cput.service;

import za.ac.cput.domain.Course;
import za.ac.cput.domain.Student;
import za.ac.cput.factory.StudentFactory;
import za.ac.cput.repository.StudentRepository;

import java.time.LocalDate;
import java.util.List;

public class StudentService implements IStudentService {
    /// wrapper a provides a service layer for the student repository. So that's you can use the factory and the repository in place for business logic
    //Create Read Update delD

    //repository
    private final StudentRepository repository; ///NEED THIS TO STORE THE DATA


    ///  constructor to initialize the repository
    public StudentService() {

        this.repository = StudentRepository.getRepository(); //get the repository
    }

    //create
    //main calling studentService.create (id , firstName, lastName, dateOfBirth, course, status)
    public Student create(String id, String firstName, String lastName, LocalDate dateOfBirth, Course course, boolean status) {
        Student student = StudentFactory.create(id, firstName, lastName, dateOfBirth, course, status);//object creation
        if (student == null) {
            return null;
        }
        return create(student); //repository layer

    }

    @Override
    public Student create(Student entity) {
        return this.repository.create(entity); //repository layer then save to the repository
    }

    @Override
    public Student read(String studentId) {
        return this.repository.read(studentId);
    }

    @Override
    public Student update(Student entity) {
        return this.repository.update(entity);
    }

    @Override
    public boolean delete(String s) {
        Student student = this.repository.read(s);
        if (student != null) {
            this.repository.delete(s);
            return true;
        }
        return false;
    }

    @Override
    public boolean deactivate(String id) {
        Student student = read(id);
        if (student != null) {
            Student softDeleted = new Student.Builder()
                    .copy(student)
                    .setActive(false)
                    .build();
            update(softDeleted);
            return true;
        }
        return false;
    }

    @Override
    public boolean restore(String id) {
        return this.repository.restore(id);
    }

    @Override
    public List<Student> getAll() {
        return this.repository.getAll();
    }

    public List<Student> getAllActive() {
        return this.repository.getActiveStudents();
    }

    public List<Student> getAllInactive() {
        return this.repository.getInactiveStudents();
    }


}
