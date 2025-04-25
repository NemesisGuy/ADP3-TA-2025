package za.ac.cput.domain;



import za.ac.cput.domain.Course;

import java.time.LocalDate;

public class StudentDTO {
    private String id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private Course course;
    private boolean active;

    // Constructors
    public StudentDTO() {}

    public StudentDTO(String id, String firstName, String lastName, LocalDate dateOfBirth, Course course, boolean active) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.course = course;
        this.active = active;
    }

    // Getters & Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
