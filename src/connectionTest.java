package mySQL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class connectionTest{

public static void main(System [] args)
{
	

Connection conn = null;
try {
    conn =
       DriverManager.getConnection("jdbc:mysql://mydbteam7.cylximvtz5oo.us-east-2.rds.amazonaws.com/mydbteam7?" +
                                   "user=Team7&password=teamseven");

    // Do something with the Connection
    
    Statement stmt = null;
    ResultSet rs = null;

    try {
        stmt = conn.createStatement();
        rs = stmt.executeQuery("SELECT * FROM BotTest");

        // or alternatively, if you don't know ahead of time that
        // the query will be a SELECT...

        if (stmt.execute("SELECT * FROM BotTest")) {
            rs = stmt.getResultSet();
        }
        
        System.out.println("String ID:" + rs.getInt(0));

        // Now do something with the ResultSet ....
    }
    catch (SQLException ex){
        // handle any errors
        System.out.println("SQLException: " + ex.getMessage());
        System.out.println("SQLState: " + ex.getSQLState());
        System.out.println("VendorError: " + ex.getErrorCode());
    }
    finally {
        // it is a good idea to release
        // resources in a finally{} block
        // in reverse-order of their creation
        // if they are no-longer needed

        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException sqlEx) { } // ignore

            rs = null;
        }

        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException sqlEx) { } // ignore

            stmt = null;
        }
    }
    

} catch (SQLException ex) {
    // handle any errors
    System.out.println("SQLException: " + ex.getMessage());
    System.out.println("SQLState: " + ex.getSQLState());
    System.out.println("VendorError: " + ex.getErrorCode());
}

}
}