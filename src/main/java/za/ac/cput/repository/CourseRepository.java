package za.ac.cput.repository;

import za.ac.cput.domain.Course;

import java.util.LinkedList;
import java.util.List;

public class CourseRepository implements ICourseRepository {
    // This is a repository class for the Course entity
    // This class will be responsible for all CRUD operations for the Course entity
    //list of courses
    private final List<Course> courseList = new LinkedList<>();
    //singleton
    private static CourseRepository courseRepository = null;

    private CourseRepository() {

    }

    public static CourseRepository getRepository() {
        if (courseRepository == null) {
            courseRepository = new CourseRepository();
        }
        return courseRepository;
    }

    //CRUD - Create, Read, Update, Delete
    public Course create(Course course) {
        if (course != null) {
            courseList.add(course);
        }
        return course;
    }


    //read
    @Override
    public Course read(Integer id) {
        for (Course course : courseList) {
            if (course.getId() == id) {
                return course;
            }
        }
        return null;
    }

    //update
    public Course update(Course course) {
        if (course != null) {
            for (int i = 0; i < courseList.size(); i++) {
                if (courseList.get(i).getId() == course.getId()) {
                    courseList.set(i, course);
                    return course;
                }
            }
        }
        return null;
    }


    //delete
    @Override
    public boolean delete(Integer id) {
        for (Course course : courseList) {
            if (course.getId() == id) {
                courseList.remove(course);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Course> getAll() {
        return List.of();
    }
}
