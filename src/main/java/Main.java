
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

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

    public HashMap<String, ArrayList<Double>> initListLucosSuspect(){
        HashMap<String, ArrayList<Double>> listLucosSuscpect = new HashMap<>();
        listLucosSuscpect.put("TPOX",new ArrayList<Double>(Arrays.asList(16.0,15.0)));
        return listLucosSuscpect;
    }
;
    public static void main(String[] args) {
        Main app = new Main();
        app.connect();


    }
}
