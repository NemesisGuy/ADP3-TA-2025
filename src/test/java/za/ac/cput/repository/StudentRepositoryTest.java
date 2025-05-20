package za.ac.cput.repository;
/*
    StudentRepositoryTest.java
    Description : This is intended to test the StudentRepository class
    Author: Peter Buckingham (220165289)
    Date: 14 March 2025
*/

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Course;
import za.ac.cput.domain.Student;
import za.ac.cput.factory.CourseFactory;
import za.ac.cput.util.Helper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentRepositoryTest {

    private StudentRepository repository;
    private StudentRepository repository2;

    private Student student1, student2;
    private final Course course = CourseFactory.create(301, "App Development 3", 100, 3, new ArrayList<>(), new ArrayList<>());

    @BeforeEach
    void setUp() {
        repository = StudentRepository.getRepository();

        student1 = new Student.Builder()
                .setId("1")
                .setFirstName("John")
                .setLastName("Doe")
                .setDateOfBirth(LocalDate.of(1990, 1, 1))
                .setCourse(course)
                .setActive(true)
                .build();

        student2 = new Student.Builder()
                .setId("2")
                .setFirstName("Jane")
                .setLastName("Smith")
                .setDateOfBirth(LocalDate.of(1992, 2, 2))
                .setCourse(course)

                .setActive(true)
                .build();

        repository.create(student1);
        repository.create(student2);
    }

    @AfterEach
    void tearDown() {
        // Reset repository after each test
        repository.getAll().clear();
    }

    @Test
    void getRepository() {
    }

    @Test
    void create() {

        int sizeBefore = repository.getAll().size();                     //look at this
        Student newStudent = new Student.Builder()
                .setId("3")
                .setFirstName("Alice")
                .setLastName("Johnson")
                .setCourse(course)
                .setActive(true)
                .build();

        Student createdStudent = repository.create(newStudent);
        assertNotNull(createdStudent);
        assertEquals("3", createdStudent.getId());
        int sizeAfter = repository.getAll().size();                      //look at this
        assertEquals(sizeBefore + 1, sizeAfter);               //look at this
        assertTrue(sizeAfter > sizeBefore);                        //look at this
    }

    @Test
    void createFail() {
        Student newStudent = new Student.Builder()
                .setId("3")
                .setFirstName("Alice")
                .setLastName("Johnson")
                .setDateOfBirth(Helper.Dates.generateDateOfBirthForAdult())
                .setCourse(course)
                .setActive(true)
                .build();

        Student createdStudent = repository.create(newStudent);
        assertNotNull(createdStudent);
        assertEquals("3", createdStudent.getId());
        assertEquals(3, repository.getAll().size());
        repository.delete("3");
        //    assertEquals(20000000, repository.getAll().size());/// this is the issue, this is an example for the students to see
        assertNotEquals(4, repository.getAll().size()); // this is will pass
    }


    @Test
    void read() {
        Student foundStudent = repository.read("1");
        assertNotNull(foundStudent);
        assertEquals("John", foundStudent.getFirstName());

        Student notFoundStudent = repository.read("99");
        assertNull(notFoundStudent);
    }

    @Test
    void update() {
        Student updatedStudent = new Student.Builder()
                .setId("1")
                .setFirstName("Johnny")
                .setLastName("Doe")

                .build();

        Student result = repository.update(updatedStudent);
        assertNotNull(result);
        assertEquals("Johnny", result.getFirstName());
        assertEquals("Doe", result.getLastName());
    }

    @Test
    void delete() {


        boolean deleted = repository.deactivate("2");
        assertTrue(deleted);
        assertEquals(1, repository.getActiveStudents().size());
        assertFalse(repository.read("2").isActive());
        //println(repository.getActiveStudents());
        for (Student student : repository.getActiveStudents()) {
            System.out.println(student);
        }
        //System.out.println();
    }

    @Test
    void getAll() {
        assertTrue(repository.getAll().size() > 0 && repository.getAll() != null);
        List<Student> students = repository.getAll();
        assertEquals(2, students.size());

    }
    //test values across 2 instances of the repository
    @Test
    void getAll2() {
        repository2 = StudentRepository.getRepository();
        assertTrue(repository2.getAll().size() > 0 && repository2.getAll() != null);
        List<Student> studentsRepository2 = repository2.getAll();
        //println(students);
        System.out.println("Students from repository2:");
        for (Student student : studentsRepository2) {
            System.out.println(student);
        }
        studentsRepository2.remove(0);
        System.out.println("end of students from repository2");
        List<Student> studentsRepository = repository.getAll();
        System.out.println("Students from repository:");
        for (Student student : studentsRepository) {
            System.out.println(student);
        }
        System.out.println("end of students from repository");
        assertEquals(2, studentsRepository2.size());
        System.out.println(studentsRepository2);
    }
}