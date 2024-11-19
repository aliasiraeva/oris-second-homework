import java.util.List;
import java.util.Optional;

public interface CrudRepository<T> {
    List<T> findAll();
    Optional<T> findById(Integer id);
    void save(T object);
    void remove(T object);
    void update(T object);
}
