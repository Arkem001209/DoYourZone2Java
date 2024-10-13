import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "/usr/local/mysql";
    private static final String USER = "******";
    //to do - create user that isnt root
    private static final String PASSWORD = "******";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

}
