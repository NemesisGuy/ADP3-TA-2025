package za.ac.cput.factory;

import za.ac.cput.domain.Groundskeeper;

public class GroundskeeperFactory {
    public static Groundskeeper createGroundsKeeper(String groundsKeeperId, String groundsKeeperFirstName, String groundsKeeperLastName, int groundsKeeperNumber) {
        return new Groundskeeper.Builder()
                .setId(groundsKeeperId)
                .setFirstName(groundsKeeperFirstName)
                .setLastName(groundsKeeperLastName)
                .setGroundsKeeperNumber(groundsKeeperNumber)
                .build();


    }
}
