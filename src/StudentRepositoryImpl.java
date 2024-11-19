import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class StudentRepositoryImpl extends JdbcRepository<Student> implements StudentRepository{
    public Connection connection;
    private Function<ResultSet, List<Student>> rowMapper = (resultSet) -> {
        List<Student> students = new ArrayList<>();
        try {
            while (resultSet.next()) {
                Student student = new Student(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getDate(3),
                        resultSet.getString(4),
                        resultSet.getBoolean(5));
                students.add(student);
            }
            return students;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    };

    public StudentRepositoryImpl(Connection connection) {
        super(connection,
                "select * from student",
                "select * from student where id = ?",
                "insert into student (id, full_name, birth_date, \"group\", is_active) values (?, ?, ?, ?, ?)",
                rowMapper);
        this.connection = connection;
    }

    @Override
    public List<Student> findAllByGroup(Integer age) throws SQLException {
        return List.of();
    }

    protected List<Student> rowMapper(ResultSet resultSet) {
        List<Student> students = new ArrayList<>();
        try {
            while (resultSet.next()) {
                Student student = new Student(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getDate(3),
                        resultSet.getString(4),
                        resultSet.getBoolean(5));
                students.add(student);
            }
            return students;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    };

}
