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
import za.ac.cput.domain.Student;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentRepositoryTest {

    private StudentRepository repository;
    private Student student1, student2;

    @BeforeEach
    void setUp() {
        repository = StudentRepository.getRepository();

        student1 = new Student.Builder()
                .setId("1")
                .setFirstName("John")
                .setLastName("Doe")
                .build();

        student2 = new Student.Builder()
                .setId("2")
                .setFirstName("Jane")
                .setLastName("Smith")
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
        boolean deleted = repository.delete("2");
        assertTrue(deleted);
        assertEquals(1, repository.getAll().size());

        boolean notDeleted = repository.delete("1");
        assertFalse(notDeleted);
    }

    @Test
    void getAll() {
        List<Student> students = repository.getAll();
        assertEquals(2, students.size());

    }
}