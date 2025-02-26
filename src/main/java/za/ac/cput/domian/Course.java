package za.ac.cput.domian;
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

        public Course build() {
            return new Course(this);
        }

    }

}

