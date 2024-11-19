import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class JdbcRepository<T> implements CrudRepository<T> {

    private final Connection connection;

    private final String findAllSql;
    private final String findByIdSql;
    private final String saveSql;

    public JdbcRepository(Connection connection, String findAllSql, String findByIdSql, String saveSql) {
        this.connection = connection;
        this.findAllSql = findAllSql;
        this.findByIdSql = findByIdSql;
        this.saveSql = saveSql;
    }

    @Override
    public List<T> findAll() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(findAllSql);
            return rowMapper(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<T> findById(Integer id) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(findByIdSql);
            List<T> results = rowMapper(resultSet);
            if (!results.isEmpty()) {
                return Optional.of(results.getFirst());
            } else {
                return Optional.empty();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(T object) {
        try {
            PreparedStatement statement = connection.prepareStatement(saveSql);
            fillPreparedStatement(statement, object);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void remove(T type) {

    }

    @Override
    public void update(T type) {

    }

    protected List<T> rowMapper(ResultSet resultSet) {
        return List.of();
    }

    protected final void fillPreparedStatement(PreparedStatement preparedStatement, T object) {
    }

    ;
}
