package za.ac.cput.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import za.ac.cput.domain.Course;
import za.ac.cput.domain.Student;
import za.ac.cput.factory.CourseFactory;
import za.ac.cput.repository.StudentRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentServiceTest {

    private StudentService service;
    private Student student;
    private Course course;

    @BeforeEach
    void setUp() {
        service = new StudentService();
        course = CourseFactory.create(301, "App Development 3", 100, 3, new ArrayList<>(), new ArrayList<>());

        student = service.create(
                "001",
                "Peter",
                "Buckingham",
                LocalDate.of(1998, 4, 11),
                course,
                true // active
        );
    }

    /// test run here between @BeforeEach and  @AfterEach
    @AfterEach
    void tearDown() {
        // hard clear (for demo) since repo is singleton
        StudentRepository.getRepository().getAll().clear();
    }

    @Test
    @Order(1)
    void testCreate() {
        Student created = service.create(
                "002",
                "Amandla",
                "Makanadie",
                LocalDate.of(1999, 6, 12),
                course,
                true // active
        );
        assertNotNull(created);
        assertEquals("Amandla", created.getFirstName());
        assertTrue(created.isActive());
    }

    @Test
    @Order(2)
    void testRead() {
        Student found = service.read(student.getId());
        assertNotNull(found);
        assertEquals("Buckingham", found.getLastName());
    }

    @Test
    @Order(3)
    void testUpdate() {
        Student updated = new Student.Builder()
                .copy(student)
                .setFirstName("Amandla")
                .build();

        Student result = service.update(updated);
        assertNotNull(result);
        assertEquals("Amandla", result.getFirstName());
    }

    @Test
    @Order(4)
    void testDeleteSoft() {
        boolean deleted = service.deactivate(student.getId());
        assertTrue(deleted);

        Student result = service.read(student.getId());
        assertFalse(result.isActive());
    }

    @Test
    @Order(5)
    void testGetAllActive() {
        List<Student> activeList = service.getAllActive();
        assertFalse(activeList.isEmpty());


    }

    @Test
    @Order(6)
    void testGetAllInactive() {
        service.delete(student.getId());
        List<Student> inactiveList = service.getAllInactive();
        assertTrue(inactiveList.isEmpty());
    }

    @Test
    @Order(7)
    void testRestore() {
        assertTrue(service.deactivate(student.getId()));
        // Check if the student is inactive
        Student inactiveStudent = service.read(student.getId());
        assertFalse(inactiveStudent.isActive());
        // Restore the student
        boolean restored = service.restore(student.getId());
        // Check if the student is active again
        assertTrue(restored);
        // Read the student again
        Student result = service.read(student.getId());
        // Assert that the student is active
        assertTrue(result.isActive());
    }
}
