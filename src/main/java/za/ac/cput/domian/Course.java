package za.ac.cput.domian;

import java.util.ArrayList;

//pojo
public class Course {
    //id                               // done
    //name                             // done
    //credits                          // done
    //pojo for course                  // done
    //encapsulation for course         // done
    //builder for course               // done
    //factory for course               // done

    //null check for course
    //email valid (changes to the student call to add attribute called email )
    //DOB local date time for student
    private int id;
    private String name;
    private int credits;
    private int maxStudents ;
    private ArrayList<Student> students ;


    private Course(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.credits = builder.credits;
        this.maxStudents = builder.maxStudents;
        this.students = new ArrayList<>(maxStudents);
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getCredits() {
        return credits;
    }
    public int getMaxStudents() {
        return maxStudents;
    }
    public ArrayList<Student> getStudents() {
        return students;
    }

    //way to add individual students to the list of students

    public void addStudent(Student student) {
        if (isThereSpace())
            students.add(student);
        else {
            System.out.println("Course is full");
        }

    }
    //Lets check if there is space for more students
    public boolean isThereSpace() {
        return students.size() < maxStudents;

    }
    public int getStudentCount() {
        return students.size();
    }
    public int getAvailableSpace() {
        return maxStudents - students.size();
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", credits=" + credits +
                ", maxStudents=" + maxStudents +
                ", students=" + students +
                '}';
    }

    public static class Builder {
        private int id;
        private String name;
        private int credits;
        private int maxStudents;
        private ArrayList<Student> students;

        public Builder setId(int id) {
            if (id < 0) {
                System.out.println("Invalid ID");
            } else {
                this.id = id;
            }

            return this;
        }

        public Builder setName(String name) {
            if (name == null || name.trim().isEmpty()) {
                System.out.println("Invalid name");
            } else {
                this.name = name;
            }

            return this;
        }

        public Builder setCredits(int credits) {
            this.credits = credits;
            return this;
        }
        public Builder setMaxStudents(int maxStudents) {
            this.maxStudents = maxStudents;
            return this;
        }
        public Builder setStudents(ArrayList<Student> students) {
            this.students = students;
            return this;
        }

        public Course build() {
            return new Course(this);
        }

    }

}

