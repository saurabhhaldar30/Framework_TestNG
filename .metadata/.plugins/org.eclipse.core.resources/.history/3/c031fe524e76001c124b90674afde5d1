package Academy.E2EProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBConnector {
	
	private String host = "localhost";
	private String port = "3306";
	private String connectionURL = "jdbc:mysql://" + host + ":" + port + "/automation_demo_db";
	private String user = "root";
	private String pwd = "q112able";

	public ArrayList<String> dbConnectionTest() throws SQLException {
		
		ArrayList<String> names = new ArrayList<String>();

		// Connect to MySql Db - automation_demo_db
		Connection con = DriverManager.getConnection(connectionURL, user, pwd);

		// Execute Query
		ResultSet rs = con.createStatement().executeQuery("select * from EmployeeInfo where EmpLocation = 'UK'");
		while (rs.next()) {
			names.add(rs.getString("EmpName"));
		}

		return names;
	}

}
