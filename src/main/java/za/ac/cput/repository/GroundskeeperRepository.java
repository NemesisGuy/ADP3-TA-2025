package za.ac.cput.repository;

import za.ac.cput.domian.Groundskeeper;

import java.util.ArrayList;
import java.util.List;

public class GroundskeeperRepository implements IGroundskeeperRepository {

    private static GroundskeeperRepository repository = null;
    private final List<Groundskeeper> groundskeepers;

    private GroundskeeperRepository() {
        this.groundskeepers = new ArrayList<Groundskeeper>();
    }

    public static GroundskeeperRepository getRepository() {
        if (repository == null) repository = new GroundskeeperRepository();
        return repository;
    }

    @Override
    public Groundskeeper create(Groundskeeper groundsKeeper) {
        // Create method
        if (groundskeepers.contains(groundsKeeper)) {
            System.out.println("Groundskeeper already exists");
            return null;
        } else {
            groundskeepers.add(groundsKeeper);
        }

        return groundsKeeper;
    }


    @Override
    public Groundskeeper read(String id) {
        // Read method
        for (Groundskeeper groundskeeper : groundskeepers) {
            if (groundskeeper.getId().equals(id)) {
                return groundskeeper;
            }
        }

        return null;
    }

    @Override
    public Groundskeeper update(Groundskeeper groundsKeeper) {
        // Update method
        for (int i = 0; i < groundskeepers.size(); i++) {
            if (groundskeepers.get(i).getId().equals(groundsKeeper.getId())) {
                groundskeepers.set(i, groundsKeeper);
                return groundsKeeper;
            }
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        // Delete method
        for (int i = 0; i < groundskeepers.size(); i++) {
            if (groundskeepers.get(i).getId().equals(id)) {
                groundskeepers.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Groundskeeper> getAll() {
        return List.of();
    }
}
