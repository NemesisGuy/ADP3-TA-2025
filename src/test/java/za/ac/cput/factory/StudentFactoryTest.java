package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.StudentDTO;
import org.junit.jupiter.api.BeforeEach;
import za.ac.cput.domain.Course;
import za.ac.cput.domain.Student;


import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StudentFactoryTest {

    private Course course;

    @BeforeEach
    void setUp() {
       // course = new Course("ICT123", "App Dev", 3); // Dummy course
        course = CourseFactory.create(301, "App Development 3", 100, 3, new ArrayList<>(), new ArrayList<>());

    }

    @Test
    void testCreateWithDTO() {
        StudentDTO dto = new StudentDTO("001", "Peter", "Buckingham",
                LocalDate.of(1998, 6, 15), course, true);

        Student student = StudentFactory.create(dto);

        assertNotNull(student);
        assertEquals("Peter", student.getFirstName());
        assertEquals("Buckingham", student.getLastName());
        assertTrue(student.isActive());
    }

    @Test
    void testCreateFullDetails() {
        Student student = StudentFactory.create("002", "Jane", "Doe",
                LocalDate.of(1999, 2, 20), course, true);

        assertNotNull(student);
        assertEquals("Jane", student.getFirstName());
        assertEquals("Doe", student.getLastName());
        assertEquals("002", student.getId());
        assertEquals(course, student.getCourse());
    }

    @Test
    void testCreateJustNames() {
        Student student = StudentFactory.createJustNames("003", "John", "Smith");

        assertNotNull(student);
        assertEquals("John", student.getFirstName());
        assertEquals("Smith", student.getLastName());
        assertEquals("003", student.getId());
        assertNull(student.getDateOfBirth());
        assertNull(student.getCourse());
    }

    @Test
    void testCreateNoName() {
        Student student = StudentFactory.createNoName("004",
                LocalDate.of(2000, 10, 10), course);

        assertNotNull(student);
        assertEquals("004", student.getId());
        assertEquals(course, student.getCourse());
        assertNull(student.getFirstName());
        assertNull(student.getLastName());
    }
}
