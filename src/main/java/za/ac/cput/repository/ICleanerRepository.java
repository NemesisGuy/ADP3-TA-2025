package za.ac.cput.repository;

import za.ac.cput.domian.Cleaner;

import java.util.List;

public interface ICleanerRepository extends  IRepository<Cleaner, String> {
    List<Cleaner> getAll();


}
