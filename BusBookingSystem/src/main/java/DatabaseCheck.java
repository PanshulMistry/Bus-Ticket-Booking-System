import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseCheck {

	public static void main(String[] args) throws SQLException  {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/User", "root", "root");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		PreparedStatement ps = connection.prepareStatement("insert into User (username,password,role) values (?,?,?)");
		ps.setString(1,"Divyesh");
		ps.setString(2, "Divyesh@5981");
		ps.setString(3, "Admin");
		
		int result = ps.executeUpdate();
		
		if(result > 0)
		{
			System.out.println("Inserted Successfully.");
		}
		else
		{
			System.out.println("Not Inserted.");
		}
	}
}