package za.ac.cput.repository;

import za.ac.cput.domain.Student;
import za.ac.cput.factory.StudentFactory;

import java.util.ArrayList;
import java.util.List;

// this is used for storage of data - we start with data structure like arraylist for third year students, Database
// this is the repository for student
public class StudentRepository implements IStudentRepository {
//arraylist of student
//singleton
//CRUD

    private final List<Student> studentList;//id 1 then id 2

    //The one and only instance of the repository object
    private static StudentRepository studentRepository = null;

    private StudentRepository() {

        this.studentList = new ArrayList<>();

    }

    public static StudentRepository getRepository() {
        if (studentRepository == null) {                        //if thee is none
//            System.out.println(" this run when null");
            studentRepository = new StudentRepository();        //then create and assign one
        } else {
            //   System.out.println(" this runs when not null ");
            return studentRepository;
        }

        return studentRepository;
        // return that one instance
    }

    // CRUD - Create , Read , Update , Delete


    public Student create(Student student) {
        if (student != null) {
            studentList.add(student);
        }
        return student;
    }


    // 0 1 2 3 4 5 6 7 8 9 ... X - find mean search for the student
    @Override
    public Student read(String id) {
        //for loop to iterate through the list
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId().equalsIgnoreCase(id)) {
                return studentList.get(i);
            }
            ///turn a ID into a Student object
        }
        return null;
    }

    public Student update(Student student) {
        if (student == null || student.getId() == null)// if the student is not acceptable, return null
        {
            return null;
        }

        for (int i = 0; i < studentList.size(); i++)
            if (studentList.get(i).getId().equalsIgnoreCase(student.getId())) {
                studentList.set(i, student);//replace the student
                return student;

            }

        return null;
    }

    //This was removed because we are not permanently deleting the student
    public boolean delete(String id) {
        return deactivate(id);
    }
    // This is the delete method, it is used to soft-delete the student for data integrity

  //  @Override
    public boolean deactivate(String id) {
        Student student = read(id);
        if (student != null) {
            Student updated = new Student.Builder()
                    .setId(student.getId())
                    .setFirstName(student.getFirstName())
                    .setLastName(student.getLastName())
                    .setDateOfBirth(student.getDateOfBirth())
                    .setCourse(student.getCourse())
                    .setActive(false) // Soft-delete!
                    .build();

            update(updated);
            return true;
        }
        return false;
    }

    //Used to restore if the student is not active
    public boolean restore(String id) {
        Student student = read(id);
        if (student != null && !student.isActive()) {
            Student restored = new Student.Builder()
                    .copy(student)
                    .setActive(true)
                    .build();
            update(restored);
            return true;
        }
        return false;
    }


    public List<Student> getAll() {
        return studentList;
    }


    //Get active students
    //If student is active display ect
    public List<Student> getActiveStudents() {
        List<Student> activeStudents = new ArrayList<>();
        for (Student student : studentList) {
            if (student.isActive()) {
                activeStudents.add(student);
            }
        }
        return activeStudents;
    }
    //Get inactive students
    //If student is not active display ect
    public List<Student> getInactiveStudents() {
        List<Student> inactiveStudents = new ArrayList<>();
        for (Student student : studentList) {
            if (!student.isActive()) {
                inactiveStudents.add(student);
            }
        }
        return inactiveStudents;
    }


}
//