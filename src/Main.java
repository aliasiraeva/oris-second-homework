import java.sql.*;

public class Main {
    private static final String USERNAME = "oris";
    private static final String PASSWORD = "oris";
    private static final String URL = "jdbc:postgresql://localhost:5432/oris_practice_db";
    private static final String ADD_STUDENTS = """
            insert into student(full_name, birth_date, student_group, is_active)
                        values('Ivan Ivanov', '2004-04-05', '11', true),
                            ('Semyon Sidorov', '2002-09-05', '22', false),
                            ('Alina Ivanova', '2006-10-29', '33', true),
                            ('Petr Petrov', '2001-06-07', '11', false),
                            ('Maria Sidorova', '1998-01-01', '11', true),
                            ('Vasiliy Vasiliev', '2005-04-15', '22', false);
            """;
    private static final String SELECT_STUDENTS = """
            select id, full_name from student
            where student_group = ? and is_active = ?
            """;

    public static void main(String[] args) throws Exception {
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        Statement statement = connection.createStatement();
        statement.executeQuery(ADD_STUDENTS);
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENTS);
        preparedStatement.setString(1, "11");
        preparedStatement.setBoolean(2, true);
        ResultSet result = preparedStatement.executeQuery();
        while (result.next()) {
            System.out.println(result.getInt("id") + " " + result.getString("full_name"));
        }
    }
}
