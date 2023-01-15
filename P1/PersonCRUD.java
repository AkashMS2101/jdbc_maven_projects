package jdbc_maven_eb9_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PersonCRUD {
	public Connection getConnection() throws Exception {
		String className = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/persondb";
		String user = "root";
		String password = "root";

		Class.forName(className);
		Connection connection = DriverManager.getConnection(url, user, password);
		return connection;
	}

	public void savePerson(Person person) throws Exception {
		String query = "insert into person values (?,?,?)";

		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, person.getId());
		preparedStatement.setString(2, person.getName());
		preparedStatement.setLong(3, person.getPhone());
		preparedStatement.execute();
		connection.close();
		System.out.println("Inserted");
	}

	public void updatePerson(Person person) throws Exception {
		String query = "update person set name = ? where id = ?";

		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, person.getName());
		preparedStatement.setInt(2, person.getId());
		preparedStatement.executeUpdate();
		connection.close();
		System.out.println("Updated");
	}

	public void deletePerson(int id) throws Exception {
		String query = "delete from person where id = ?";

		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, id);
		preparedStatement.execute();
		connection.close();
		System.out.println("Deleted");
	}
	
	public void displayPerson(Person person) throws Exception {
		String query = " select * from person";
		
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		ResultSet resultSet = preparedStatement.executeQuery();
		while(resultSet.next()) {
			System.out.println(resultSet.getInt(1));
			System.out.println(resultSet.getString(2));
			System.out.println(resultSet.getLong(3));
			System.out.println("0000000000000000000000000000000000");
		}
	}
}



















