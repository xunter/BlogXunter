package blogxunter.tests;

import java.sql.*;

import junit.framework.TestCase;

public class DBTest extends TestCase {
	
	public void testMySQLWork() throws Exception {
		String url = "jdbc:mysql://localhost/test?user=root&password=pashok";
		
		try {
			// The newInstance() call is a work around for some
			// broken Java implementations
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		/*try {
			Connection connection = DriverManager.getConnection(url);
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
		
	}
}
