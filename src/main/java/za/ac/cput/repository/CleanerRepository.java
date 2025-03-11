package za.ac.cput.repository;

import za.ac.cput.domian.Cleaner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CleanerRepository implements ICleanerRepository {

    private static CleanerRepository repository = null;
    private Map<String,Cleaner> cleanerList ;

    private CleanerRepository() {
        this.cleanerList = new HashMap<>();
    }


    //singleton
    public static CleanerRepository getRepository(){
        if(repository == null) repository = new CleanerRepository();
        return repository;
    }

    @Override
    public List<Cleaner> getAll() {
        return cleanerList.values().stream().collect(Collectors.toList());
    }

    @Override
    public Cleaner create(Cleaner entity) {
        if(cleanerList.containsKey(entity.getId())){
            System.out.println("Cleaner already exists");
            return null;
        }
            cleanerList.put(entity.getId(),entity);
        return cleanerList.get(entity.getId());
    }

    @Override
    public Cleaner read(String id) {
        if(cleanerList.containsKey(id)){
            return cleanerList.get(id);
        }

        ////cleanerList.get(id);
        return null;
    }

    @Override
    public Cleaner update(Cleaner entity) {
        if(cleanerList.containsKey(entity.getId())){
            cleanerList.replace(entity.getId(),entity);
            return cleanerList.get(entity.getId());
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        if(cleanerList.containsKey(id)){
            cleanerList.remove(id);
            return true;
        }
        return false;
    }
}
