package za.ac.cput.domian;

//
// pojo
public class Janitor extends Employee {
    private final String shift;


    private Janitor(Builder builder) {
        super(builder);
        this.shift = builder.shift;
    }

    public String getShift() {
        return shift;
    }


    @Override
    public String toString() {
        return "Janitor{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", shift='" + shift + '\'' +
                '}';
    }

    public static class Builder extends Employee.Builder<Builder> {

        private String shift;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        @Override
        protected Builder self() {
            return this;
        }

        public Builder setShift(String shift) {
            this.shift = shift;
            return this;
        }

        public Builder copy(Janitor janitor) {
            this.id = janitor.id;
            this.firstName = janitor.firstName;
            this.lastName = janitor.lastName;
            this.shift = janitor.shift;
            return this;
        }


        public Janitor build() {
            return new Janitor(this);
        }

    }

}
