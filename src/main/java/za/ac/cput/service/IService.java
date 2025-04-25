package za.ac.cput.service;

public interface IService<T, ID> {
    //point that you provide the implementation pattern , rules around the implementation
    // 1. Create
    // 2. Read
    // 3. Update
    // 4. Delete // soft delete we're just making entities inactive here.
    // 5. Get all

    T create(T entity);

    T read(ID id);

    T update(T entity);



    boolean delete(ID id);
}
