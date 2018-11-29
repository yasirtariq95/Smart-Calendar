import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class dbconnection {
	static Connection con = null;
	static PreparedStatement ps = null;
	static ResultSet rs = null;

	public static Connection getConnection(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://mydbteam7.cylximvtz5oo.us-east-2.rds.amazonaws.com:3306/mydbteam7", "Team7", "teamseven");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}finally {
			try { 
				//con.close(); 
				} catch (Exception e) { /* ignored */ }

		}
		return con;
	}

	public static int getEventMonth() {	
		String query = ("SELECT * FROM Events");;
		int eventMonth = 0;

		try {
			con = DriverManager.getConnection("jdbc:mysql://mydbteam7.cylximvtz5oo.us-east-2.rds.amazonaws.com:3306/mydbteam7", "Team7", "teamseven");
			ps = dbconnection.getConnection().prepareStatement(query);
			rs = ps.executeQuery(query);
			while(rs.next()) { 
				eventMonth = rs.getInt("Month");
				if (eventMonth!= 0) {
					return eventMonth;
				}
			} 
		}catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}finally {
			try { rs.close(); } catch (Exception e) { /* ignored */  }
			try { ps.close(); } catch (Exception e) { /* ignored */ }
			try { con.close(); } catch (Exception e) { /* ignored */ }
		}

		return eventMonth;

	}

	public static int getEventDay() {	
		String query = ("SELECT * FROM Events");;
		int eventDay = 0;

		try {
			con = DriverManager.getConnection("jdbc:mysql://mydbteam7.cylximvtz5oo.us-east-2.rds.amazonaws.com:3306/mydbteam7", "Team7", "teamseven");
			ps = dbconnection.getConnection().prepareStatement(query);
			rs = ps.executeQuery(query);
			while(rs.next()) { 
				eventDay = rs.getInt("Day");
				if (eventDay!= 0) {
					return eventDay;
				}
			} 
		}catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}finally {
			try { rs.close(); } catch (Exception e) { /* ignored */  }
			try { ps.close(); } catch (Exception e) { /* ignored */ }
			try { con.close(); } catch (Exception e) { /* ignored */ }
		}

		return eventDay;

	}

	public static String getEventName() {	
		String query = ("SELECT * FROM Events");;
		String eventName = "";

		try {
			con = DriverManager.getConnection("jdbc:mysql://mydbteam7.cylximvtz5oo.us-east-2.rds.amazonaws.com:3306/mydbteam7", "Team7", "teamseven");
			ps = dbconnection.getConnection().prepareStatement(query);
			rs = ps.executeQuery(query);
			while(rs.next()) { 
				eventName = rs.getString("EventName");
				}
		}catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}finally {
			try { rs.close(); } catch (Exception e) { /* ignored */  }
			try { ps.close(); } catch (Exception e) { /* ignored */ }
			try { con.close(); } catch (Exception e) { /* ignored */ }
		}
		return eventName;

	}

	public static String getEventLoc() {	
		String query = ("SELECT * FROM Events");;
		String eventLoc = "";

		try {
			con = DriverManager.getConnection("jdbc:mysql://mydbteam7.cylximvtz5oo.us-east-2.rds.amazonaws.com:3306/mydbteam7", "Team7", "teamseven");
			ps = dbconnection.getConnection().prepareStatement(query);
			rs = ps.executeQuery(query);
			while(rs.next()) { 
				eventLoc = rs.getString("Location");
				}
		}catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}finally {
			try { rs.close(); } catch (Exception e) { /* ignored */  }
			try { ps.close(); } catch (Exception e) { /* ignored */ }
			try { con.close(); } catch (Exception e) { /* ignored */ }
		}
		return eventLoc;

	}

}
