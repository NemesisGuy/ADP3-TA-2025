package za.ac.cput.domian;
//
// pojo
public class Cleaner {
    private String id;
    private String name;
    private String surname;

    private Cleaner(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.surname = builder.surname;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }


    @Override
    public String toString() {
        return "Cleaner{" +
                "Id='" + id + '\'' +
                ", Name='" + name + '\'' +
                ", Surname='" + surname + '\'' +
                '}';
    }
    public static class Builder {
        private String id;
        private String name;
        private String surname;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }
        public Builder setName(String name) {
            this.name = name;
            return this;
        }
        public Builder setSurname(String surname) {
            this.surname = surname;
            return this;
        }
        public Builder copy(Cleaner cleaner){
            this.id = cleaner.id;
            this.name = cleaner.name;
            this.surname = cleaner.surname;
            return this;
        }


        public Cleaner build() {
            return new Cleaner(this);
        }

    }

}
