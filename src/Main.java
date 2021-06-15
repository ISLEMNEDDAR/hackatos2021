
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Main {

    public void connect() {
        Connection conn = null;
        try {
            String url = "jdbc:postgresql://localhost:5434/fnaeg";
            String user = "postgres";
            String password = "cluedo";
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void main(String[] args) {
        Main app = new Main();
        app.connect();
    }
}
