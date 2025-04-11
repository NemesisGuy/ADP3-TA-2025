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


    private final List<Student> studentList ; //id 1 then id 2

    private StudentRepository() {

        this.studentList = new ArrayList<>();

    }

    //the one and only instance of the repository object
    private static StudentRepository studentRepository = null;

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


    // 0 1 2 3 4 5 6 7 8 9 find mean search for the student
    @Override
    public Student read(String id) {
        //for loop to iterate through the list
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId().equalsIgnoreCase(id)) {
                return studentList.get(i);
            }
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
                studentList.set(i, student);
                return student;

            }

        return null;
    }

  /*  public boolean delete(String id) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId().equalsIgnoreCase(id)) {
               // studentList.remove(i);
             //  Student StudentToBeDisabled =  studentList.get(i);
                studentList.get(i).setActive(false);
                return true;
            }
        }
        return false;
    }*/
  @Override
  public boolean delete(String id) {
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
  //used to restore if the student is not active
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


    //get active students //if student is active display ect

    public List<Student> getActiveStudents() {
        List<Student> activeStudents = new ArrayList<>();
        for (Student student : studentList) {
            if (student.isActive()) {
                activeStudents.add(student);
            }
        }
        return activeStudents;
    }
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