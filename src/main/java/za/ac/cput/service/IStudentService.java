package za.ac.cput.service;

import za.ac.cput.domain.Student;

import java.util.List;
import java.util.Optional;

public interface IStudentService extends IService<Student, String> {



    List<Student> getAll();
    // This is the delete method, it is used to soft-delete the student for data integrity
    boolean deactivate(String id);
    // This is the activate method, it is used to reactivate the student for data integrity
    boolean restore(String id);


}
