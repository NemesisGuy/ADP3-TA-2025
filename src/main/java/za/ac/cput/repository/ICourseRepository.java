package za.ac.cput.repository;

import za.ac.cput.domian.Course;

import java.util.List;

public interface ICourseRepository extends IRepository<Course, Integer> {
    List<Course> getAll();
}
