package doctorappointment.dbinfo;
import java.sql.*;
public class DBConnection {
private static Connection con = null;
	
	public static Connection openConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/doctorappointment_db","root","root");
			
			}
		catch(ClassNotFoundException|SQLException cse) {
			cse.printStackTrace();
		}
		return con;
	}
	public static void main(String[] args) {
		Connection con = openConnection();
		System.out.println(con);
	}
}


