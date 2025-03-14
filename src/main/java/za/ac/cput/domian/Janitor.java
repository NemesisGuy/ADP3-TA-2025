package za.ac.cput.domian;
//
// pojo
public class Janitor {
    private String id;
    private String firstName;
    private String lastName;

    private Janitor(Builder builder) {
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
        return "Cleaner{" +
                "Id='" + id + '\'' +
                ", Name='" + firstName + '\'' +
                ", Surname='" + lastName + '\'' +
                '}';
    }
    public static class Builder {
        private String id;
        private String firstName;
        private String lastName;

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
        public Builder copy(Janitor janitor){
            this.id = janitor.id;
            this.firstName = janitor.firstName;
            this.lastName = janitor.lastName;
            return this;
        }


        public Janitor build() {
            return new Janitor(this);
        }

    }

}
