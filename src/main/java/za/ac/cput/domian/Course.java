package za.ac.cput.domian;
//pojo
public class Course {
    //id
    //name
    //credits
    //pojo for course
    //encapsulation for course
    //builder for course

    //factory for course

    //null check for course
    //email valid (changes to the student call to add attribute called email )
    //DOB local date time for student
    private int id;
    private String name;
    private int credits;



    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getCredits() {
        return credits;
    }

    private Course(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.credits = builder.credits;
    }

    @Override
    public String toString() {


        return "Course{" + "id=" + id + ", name='" + name + '\'' + ", credits=" + credits + '}';

    }


    public static class Builder {
        private int id;
        private String name;
        private int credits;

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setCredits(int credits) {
            this.credits = credits;
            return this;
        }

        public Course build() {
            return new Course(this);
        }

    }

}

