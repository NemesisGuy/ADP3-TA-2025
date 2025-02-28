package za.ac.cput.domian;
//
// pojo
public class Cleaner {
    private String Id;
    private String Name;
    private String Surname;

    private Cleaner(Builder builder) {
        this.Id = builder.Id;
        this.Name = builder.Name;
        this.Surname = builder.Surname;
    }

    public String getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public String getSurname() {
        return Surname;
    }


    @Override
    public String toString() {
        return "Cleaner{" +
                "Id='" + Id + '\'' +
                ", Name='" + Name + '\'' +
                ", Surname='" + Surname + '\'' +
                '}';
    }
    public static class Builder {
        private String Id;
        private String Name;
        private String Surname;

        public Builder setId(String Id) {
            this.Id = Id;
            return this;
        }
        public Builder setName(String Name) {
            this.Name = Name;
            return this;
        }
        public Builder setSurname(String Surname) {
            this.Surname = Surname;
            return this;
        }
        public Builder copy(Cleaner cleaner){
            this.Id = cleaner.Id;
            this.Name = cleaner.Name;
            this.Surname = cleaner.Surname;
            return this;
        }


        public Cleaner build() {
            return new Cleaner(this);
        }

    }

}
