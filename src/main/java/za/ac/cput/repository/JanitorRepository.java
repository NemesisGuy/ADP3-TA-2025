package za.ac.cput.repository;

import za.ac.cput.domain.Janitor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JanitorRepository implements IJanitorRepository {

    private final Map<String, Janitor> cleanerList;

    private JanitorRepository() {
        this.cleanerList = new HashMap<>();
    }

    private static JanitorRepository repository = null;

    //singleton
    public static JanitorRepository getRepository() {
        if (repository == null) repository = new JanitorRepository();
        return repository;
    }

    //CRUD methods


    @Override
    public Janitor create(Janitor entity) {
        if (cleanerList.containsKey(entity.getId())) {
            System.out.println("Cleaner already exists");
            return null;
        }
        cleanerList.put(entity.getId(), entity);
        return cleanerList.get(entity.getId());
    }

    @Override
    public Janitor read(String id) {
        if (cleanerList.containsKey(id)) {
            return cleanerList.get(id);
        }

        ////cleanerList.get(id);
        return null;
    }

    @Override
    public Janitor update(Janitor entity) {
        if (cleanerList.containsKey(entity.getId())) {
            cleanerList.replace(entity.getId(), entity);
            return cleanerList.get(entity.getId());
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        if (cleanerList.containsKey(id)) {
            cleanerList.remove(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean deactivate(String s) {
        // TODO implement

        return false;
    }

    @Override
    public List<Janitor> getAll() {
        return cleanerList.values().stream().collect(Collectors.toList());
    }
}
