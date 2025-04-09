package za.ac.cput.domain;

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
    private final int id;
    private final String name;
    private final int credits;
    private final int maxStudents;
    private final ArrayList<Student> students;
    private final ArrayList<Subject> subjects;


    private Course(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.credits = builder.credits;
        this.maxStudents = builder.maxStudents;
        this.subjects = new ArrayList<>();
        this.students = new ArrayList<>();
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

    public ArrayList<Subject> getSubjects() {
        return subjects;
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

    //add subjects to the course
    public void addSubject(Subject subject) {
        subjects.add(subject);
    }


    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", credits=" + credits +
                ", maxStudents=" + maxStudents +
                ", students=" + students +
                ", subjects=" + subjects +
                '}';
    }

    public static class Builder {
        private int id;
        private String name;
        private int credits;
        private int maxStudents;
        private ArrayList<Student> students;
        private ArrayList<Subject> subjects;

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

        public Builder setSubjects(ArrayList<Subject> subjects) {
            this.subjects = subjects;
            return this;
        }

        //copy
        public Builder copy(Course course) {
            this.id = course.id;
            this.name = course.name;
            this.credits = course.credits;
            this.maxStudents = course.maxStudents;
            this.students = course.students;
            this.subjects = course.subjects;
            return this;
        }

        public Course build() {
            return new Course(this);
        }

    }

}

