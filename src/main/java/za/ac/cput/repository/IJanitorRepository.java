package za.ac.cput.repository;

import za.ac.cput.domain.Janitor;

import java.util.List;

public interface IJanitorRepository extends IRepository<Janitor, String> {
    List<Janitor> getAll();


}
