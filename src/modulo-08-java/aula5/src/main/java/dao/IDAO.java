package dao;

import java.util.List;

/**
 * @author murillo.peteffi
 */
public interface IDAO<T> {
    
    void insert(T t);
    void update(T t);
    void delete(T t);
    T load(Object id);
    List<T> listAll(T t);
}
