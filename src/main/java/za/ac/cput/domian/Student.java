package za.ac.cput.domian;

import za.ac.cput.util.Helper;

public class Student {
    private String id;
    private String name;
    private int age;

    public String getName() {

        return name;
    }

    public int getAge() {

        return age;
    }

    public String getId() {
        return id;
    }

    private Student(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.age = builder.age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static class Builder{
        private String id;
        private String name;
        private int age;

        public Builder setId(String id) {
            if (Helper.Validate.isString(id))
            {
                this.id = id;
            }
            return this;
        }
        public Builder setName(String name) {
            if(Helper.Validate.isString(name))
            {
                this.name = name;
            }
            return this;
        }
        public  Builder setAge(int age) {
            if (Helper.Validate.age(age))
            {
                this.age = age;
            }
            return this;
        }

        public Student build() {

            return new Student(this);
        }


    }

}


