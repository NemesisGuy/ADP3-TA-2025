package za.ac.cput.domian;

public class Student {
    private String name;
    private int age;

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }

    private Student(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static class Builder{
        private String name;
        private int age;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }
        public  Builder setAge(int age) {
//            if (age > 16 && age < 150 )
//            {
                this.age = age;
//            }
            return this;
        }

        public Student build() {

            return new Student(this);
        }


    }

}


