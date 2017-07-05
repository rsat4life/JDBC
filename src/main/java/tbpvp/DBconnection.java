package tbpvp;

/**
 * Created by Gideon on 7/4/2017.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.bukkit.plugin.java.JavaPlugin;

public class DBconnection extends JavaPlugin{

    private final String dbURL = "jdbc:postgresql://localhost/Minecraft";
    private final String dbUser = "postgres";
    private final String dbPassword = "password";

    public Connection connect() throws SQLException {
        Connection conn = null;
        System.out.println("Establishing connection to " + dbURL + " as " + dbUser + "...");
        System.out.println(".....");
        System.out.println(".....");

        try {
            conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);
            System.out.println("Connection established");
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }

    public void onEnable() {
        DBconnection DBconnect = new DBconnection();
        try {
            DBconnect.connect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void onDisable(){

    }
}
