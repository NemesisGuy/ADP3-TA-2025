package za.ac.cput.repository;

import java.util.List;

public interface IRepository <T, ID> {
    // crud methods to perform the required operations
    T create(T entity);
    T read(ID id);
    T update(T entity);
    boolean delete(ID id);



}
