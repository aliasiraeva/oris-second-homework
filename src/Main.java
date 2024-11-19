import java.sql.*;
import java.util.List;
import java.util.Optional;

public class Main {
    private static final String USERNAME = "oris";
    private static final String PASSWORD = "oris";
    private static final String URL = "jdbc:postgresql://localhost:5432/oris_practice_db";

    public static void main(String[] args) throws Exception {
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        StudentRepository studentRepository = new StudentRepositoryImpl(connection);
        List<Student> students = studentRepository.findAll();
        System.out.println(students.size());
    }
}


