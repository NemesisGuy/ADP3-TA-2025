package za.ac.cput.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import za.ac.cput.domain.Course;
import za.ac.cput.domain.Student;
import za.ac.cput.factory.CourseFactory;
import za.ac.cput.repository.StudentRepository;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentServiceTest {

    private StudentService service;
    private Student student;
    private Course course;

    @BeforeEach
    void setUp() {
        service = new StudentService();
        course = CourseFactory.create(301, "App Development 3", 100, 3, new ArrayList<>(),new ArrayList<>());

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
        assertNotNull(student);
        assertEquals("Peter", student.getFirstName());
        assertTrue(student.isActive());
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
                .setFirstName("Pete")
                .build();

        Student result = service.update(updated);
        assertNotNull(result);
        assertEquals("Pete", result.getFirstName());
    }

    @Test
    @Order(4)
    void testDeleteSoft() {
        boolean deleted = service.delete(student.getId());
        assertTrue(deleted);

        Student result = service.read(student.getId());
        assertFalse(result.isActive());
    }

    @Test
    @Order(5)
    void testGetAllActive() {
        var activeList = service.getAllActive();
        assertTrue(((Iterable<?>) activeList).iterator().hasNext());
    }

    @Test
    @Order(6)
    void testGetAllInactive() {
        service.delete(student.getId());
        var inactiveList = service.getAllInactive();
        assertTrue(((Iterable<?>) inactiveList).iterator().hasNext());
    }
}
