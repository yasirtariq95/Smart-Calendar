import java.sql.Connection;
import java.sql.DriverManager;

public class dbconnection {
    public static Connection getConnection(){
     
        Connection con = null;
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://mydbteam7.cylximvtz5oo.us-east-2.rds.amazonaws.com:3306/mydbteam7", "Team7", "teamseven");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        return con;
    }
}