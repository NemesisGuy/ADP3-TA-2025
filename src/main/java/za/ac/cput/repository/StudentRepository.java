package za.ac.cput.repository;

import za.ac.cput.domian.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// this is used for storage of data - we start with data strucuter like arraylist
// this is the repository for student
public class StudentRepository {
//arraylist of student

   private List<Student> studentsList = new ArrayList<>(); //id 1 then id 2

    // CRUD - Create , Read , Update , Delete


    public Student create(Student student){
        if (student !=null)
        {
            studentsList.add(student);
        }
        return student;
    }

    // 0 1 2 3 4 5 6 7 8 9 find mean search for the student

    public Student readById(String id) {
        //for loop to iterate through the list
        for (int i = 0 ; i < studentsList.size(); i++)
        {
            if (studentsList.get(i).getId().equalsIgnoreCase(id))
            {
                return studentsList.get(i);
            }
        }
        return null;
    }

    public Student update(Student student){
        if ( student == null || student.getId()==null )// if the student is not accetable, return null
        {
           return null;
        }

        for (int i = 0 ; i < studentsList.size(); i++)
            if(studentsList.get(i).getId().equalsIgnoreCase(student.getId() ))
            {
                studentsList.set(i, student);
                return student;

            }

        return null;
    }

    public boolean delete(String id){
        for (int i = 0 ; i < studentsList.size(); i++)
        {
            if (studentsList.get(i).getId().equalsIgnoreCase(id))
            {
                studentsList.remove(i);
                return true;
            }
        }
        return false;
    }

    public  List<Student> getAll() {
        return studentsList;
    }


}
