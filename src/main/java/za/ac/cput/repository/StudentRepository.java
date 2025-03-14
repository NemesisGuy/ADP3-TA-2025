package za.ac.cput.repository;

import za.ac.cput.domian.Student;

import java.util.ArrayList;
import java.util.List;

// this is used for storage of data - we start with data structure like arraylist
// this is the repository for student
public class StudentRepository implements IStudentRepository {
//arraylist of student
// singleton


    private List<Student> studentList ; //id 1 then id 2

    private StudentRepository() {

        this.studentList = new ArrayList<>();

    }

    //the one and only instance of the repository object
    private static StudentRepository studentRepository = null;

    public static StudentRepository getRepository() {
        if (studentRepository == null) {  //if thee is none
            studentRepository = new StudentRepository(); //then create and assign one
        }
        return studentRepository; /// return that one instance
    }

    // CRUD - Create , Read , Update , Delete


    public Student create(Student student){
        if (student !=null)
        {
            studentList.add(student);
        }
        return student;
    }


    // 0 1 2 3 4 5 6 7 8 9 find mean search for the student
    @Override
    public Student read(String id) {
        //for loop to iterate through the list
        for (int i = 0; i < studentList.size(); i++)
        {
            if (studentList.get(i).getId().equalsIgnoreCase(id))
            {
                return studentList.get(i);
            }
        }
        return null;
    }

    public Student update(Student student){
        if ( student == null || student.getId()==null )// if the student is not acceptable, return null
        {
           return null;
        }

        for (int i = 0; i < studentList.size(); i++)
            if(studentList.get(i).getId().equalsIgnoreCase(student.getId() ))
            {
                studentList.set(i, student);
                return student;

            }

        return null;
    }

    public boolean delete(String id){
        for (int i = 0; i < studentList.size(); i++)
        {
            if (studentList.get(i).getId().equalsIgnoreCase(id))
            {
                studentList.remove(i);
                return true;
            }
        }
        return false;
    }

    public  List<Student> getAll() {
        return studentList;
    }


}
//