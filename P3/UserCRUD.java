package jdbc_maven_eb9_3;

import java.util.List;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;

import com.mysql.cj.jdbc.Driver;

public class UserCRUD {
	public Connection getConnection() throws Exception {

		Driver driver = new Driver();
		DriverManager.registerDriver(driver);

		FileInputStream fileInputStream = new FileInputStream("jdbc_maven-eb9_3config.properties");
		Properties properties = new Properties();
		properties.load(fileInputStream);

		Connection connection = DriverManager.getConnection(properties.getProperty("url"),
				properties.getProperty("user"), properties.getProperty("password"));

		return connection;
	}

	public void saveUser(User user) throws Exception {
		String query = "insert into user values (?,?,?,?,?)";

		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, user.user_id);
		preparedStatement.setString(2, user.getUser_name());
		preparedStatement.setString(3, user.getPassword());
		preparedStatement.setLong(4, user.getPhone());
		preparedStatement.setString(5, user.getE_mailid());
		preparedStatement.execute();
		System.out.println("inserted");
		connection.close();
	}

	public void updateUser(User user) throws Exception {
		String query = "update user set user_name = ? where user_id = ?";

		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, user.getUser_name());
		preparedStatement.setInt(2, user.user_id);
		preparedStatement.executeUpdate();
		System.out.println("Updated");
		connection.close();
	}
	
	public boolean loginUser(User user) throws Exception {
		String query = " select * from user where user_name = ?";
		
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, user.getUser_name());
		ResultSet resultSet =  preparedStatement.executeQuery();
		String password=null;
		while(resultSet.next()) {
			password = resultSet.getString("password");
			if(password.equals(user.getPassword())) {
				return true;
			}
		}
		connection.close();
		return false;
	}

	public void deleteUser(User user) throws Exception {
		String query = "delete from user where user_id = ?";

		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, user.getUser_id());
		preparedStatement.execute();
		System.out.println("Deleted");
		connection.close();
	}
	
	public void saveInBatchUser() throws Exception {
		String query = "insert into user values (?,?,?,?,?)";
		
		User u1 = new User();
		u1.setUser_name("Sanju");
		u1.setUser_id(4);
		u1.setE_mailid("vneru@ksv");
		u1.setPassword("123");
		u1.setPhone(954268);
		
		User u2 = new User();
		u2.setUser_name("Sagar");
		u2.setUser_id(5);
		u2.setE_mailid("vsgu@ksv");
		u2.setPassword("113");
		u2.setPhone(954263558);
		
		User u3 = new User();
		u3.setUser_name("Gayan");
		u3.setUser_id(6);
		u3.setE_mailid("grsru@ksv");
		u3.setPassword("122");
		u3.setPhone(95426586);
		
		List <User>list = new ArrayList<User>();
		list.add(u1);
		list.add(u2);
		list.add(u3);
		
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		for (User u : list) {
			preparedStatement.setInt(1, u.getUser_id());
			preparedStatement.setString(2, u.getUser_name());
			preparedStatement.setString(3, u.getPassword());
			preparedStatement.setLong(4, u.getPhone());
			preparedStatement.setString(5, u.getE_mailid());
			preparedStatement.addBatch();
		}
		preparedStatement.executeBatch();
		System.out.println("whole data inserted");
		connection.close();
		
	}

	public void displayUser() throws Exception {
		String query = "select * from user";

		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		ResultSet resultset = preparedStatement.executeQuery();
		while (resultset.next()) {
			System.out.println(resultset.getInt(1));
			System.out.println(resultset.getString(2));
			System.out.println(resultset.getString(3));
			System.out.println(resultset.getLong(4));
			System.out.println(resultset.getString(5));
			System.out.println("//////////////////////////////");
		}

	}
}
