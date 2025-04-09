package za.ac.cput.domain;

public class Groundskeeper extends Employee {

    private final int groundsKeeperNumber;

    private Groundskeeper(Builder builder) {
        super(builder);
        this.groundsKeeperNumber = builder.groundsKeeperNumber;
    }

    public int getGroundsKeeperNumber() {
        return groundsKeeperNumber;
    }

    @Override
    public String toString() {
        return "Groundskeeper{" +
                "GroundsKeeperNumber=" + groundsKeeperNumber +
                ", id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", groundsKeeperNumber=" + groundsKeeperNumber + '\'' +
                '}';
    }

    public static class Builder extends Employee.Builder<Builder> {
        //implicity here via inheritance from Employee.Builder
        private int groundsKeeperNumber;

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

        public Builder setGroundsKeeperNumber(int GroundsKeeperNumber) {
            this.groundsKeeperNumber = GroundsKeeperNumber;
            return this;
        }

        public Groundskeeper build() {

            return new Groundskeeper(this);
        }

        protected Builder self() {
            return this;
        }


        public Builder copy(Groundskeeper groundskeeper) {
            this.id = groundskeeper.id;
            this.firstName = groundskeeper.firstName;
            this.lastName = groundskeeper.lastName;
            this.groundsKeeperNumber = groundskeeper.groundsKeeperNumber;
            return this;
        }

    }
}
