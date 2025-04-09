package za.ac.cput.repository;

import za.ac.cput.domain.Student;

import java.util.List;

public interface IStudentRepository extends IRepository<Student, String> {

    List<Student> getAll();

}
