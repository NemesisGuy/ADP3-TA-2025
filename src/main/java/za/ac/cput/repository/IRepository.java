package za.ac.cput.repository;

public interface IRepository<T, ID> {
    // crud methods to perform the required operations
    T create(T entity);

    T read(ID id);

    T update(T entity);

    boolean delete(ID id);

}
