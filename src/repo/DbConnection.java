package repo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public abstract class DbConnection {
    public static Connection connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/gym";
        String username = "postgres";
        String password = "xedice2003";
        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
    }
}
