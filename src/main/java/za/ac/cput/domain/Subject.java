package za.ac.cput.domain;

import java.util.List;

public class Subject {
    //Subject id, name, credits, List<Lecturer> lecturers - builder pattern

    private String id;
    private String name;
    private int credits;

    private List<Lecturer> lecturers;

    private Subject() {
    }

    //getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

    public List<Lecturer> getLecturers() {
        return lecturers;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", credits=" + credits +
                ", lecturers=" + lecturers +
                '}';
    }

    //builder pattern
    private Subject(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.credits = builder.credits;
        this.lecturers = builder.lecturers;
    }

    public void addLecturer(Lecturer lecturer) {
        lecturers.add(lecturer);
    }

    public static class Builder {
        private String id;
        private String name;
        private int credits;
        private List<Lecturer> lecturers;

        public Builder setId(String id) {
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

        public Builder setLecturers(List<Lecturer> lecturers) {
            this.lecturers = lecturers;
            return this;
        }

        //copy
        public Builder copy(Subject subject) {
            this.id = subject.id;
            this.name = subject.name;
            this.credits = subject.credits;
            this.lecturers = subject.lecturers;
            return this;
        }

        public Subject build() {
            return new Subject(this);
        }
    }

}
