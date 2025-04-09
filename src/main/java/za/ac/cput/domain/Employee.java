package za.ac.cput.domain;

public abstract class Employee {
    String id;
    String firstName;
    String lastName;


    protected Employee(Builder<?> builder) {
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
    }


    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public abstract static class Builder<T extends Builder<T>> {
        String id;
        String firstName;
        String lastName;

        public Builder setId(String id) {
            this.id = id;
            return self();
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return self();
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return self();
        }

        protected abstract T self();

        public abstract Employee build();
    }


    // hc 5
    // dip 6
    // adv dip  7 - betch degee
    // PG   -  8
    // Mtch - 9
    // PHD - 10

}
