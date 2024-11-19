import java.sql.SQLException;
import java.util.List;

public interface StudentRepository extends CrudRepository<Student> {
    List<Student> findAllByGroup(Integer age) throws SQLException;
}
