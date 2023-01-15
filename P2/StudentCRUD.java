package jdbc_maven_eb9_2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentCRUD {
	public Connection getConnection() throws Exception {
		String className = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://Localhost:3306/studentdb";
		String user = "root";
		String password = "root";

		Class.forName(className);
		Connection connection = DriverManager.getConnection(url, user, password);
		return connection;
	}

	public void saveStudent(Student student) throws Exception {
		String query = "Insert into student values(?,?,?,?,?)";

		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, student.getSid());
		preparedStatement.setString(2, student.getStdname());
		preparedStatement.setInt(3, student.getStdmarks());
		preparedStatement.setString(4, student.getStd_address());
		preparedStatement.setString(5, student.getStd_father_name());
		preparedStatement.execute();
		connection.close();
		System.out.println("Inserted");
	}

	public void updateStudent(Student student) throws Exception {
		String query = "update student set stdname = ? where sid = ?";

		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, student.getStdname());
		preparedStatement.setInt(2, student.getSid());
		int count = preparedStatement.executeUpdate();
		connection.close();
		if (count == 1) {
			System.out.println("Updated");
		} else
			System.out.println("No such data found");
	}

	public void deleteStudent(int id) throws Exception {
		String query = "delete from student where sid = ?";

		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, id);
		preparedStatement.executeUpdate();
		connection.close();
		System.out.println("Deleted");
	}

	public void displayAllStudent() throws Exception {
		String query = "Select * from student";

		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			System.out.println(resultSet.getInt(1));
			System.out.println(resultSet.getString(2));
			System.out.println(resultSet.getInt(3));
			System.out.println(resultSet.getString(4));
			System.out.println(resultSet.getString(5));
			System.out.println("///////////////////////////");
		}

	}
}
