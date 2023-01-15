package jdbc_maven_eb9_4;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import com.mysql.cj.jdbc.Driver;

public class UserPasswordsCRUD {
	public Connection getConneection() throws Exception {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);

		FileInputStream fileInputStream = new FileInputStream("jdbc_maven_eb9_4config.properties");
		Properties properties = new Properties();
		properties.load(fileInputStream);

		Connection connection = DriverManager.getConnection(properties.getProperty("url"),
				properties.getProperty("user"), properties.getProperty("password"));
		return connection;
	}

	public void saveUserPasswords(UserPasswords userPasswords) throws Exception {
		String query = "insert into user_passwords values(?,?,?,?,?,?,?,?,?,?)";

		Connection connection = getConneection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, userPasswords.getUser_id());
		preparedStatement.setString(2, userPasswords.getUser_name());
		preparedStatement.setString(3, userPasswords.getUser_email());
		preparedStatement.setString(4, userPasswords.getUser_password());
		preparedStatement.setString(5, userPasswords.getUser_address());
		preparedStatement.setString(6, userPasswords.getFacebook_pw());
		preparedStatement.setString(7, userPasswords.getInsta_pw());
		preparedStatement.setString(8, userPasswords.getSnapchat_pw());
		preparedStatement.setString(9, userPasswords.getWhatsapp_pw());
		preparedStatement.setString(10, userPasswords.getTwitter_pw());
		preparedStatement.execute();

		System.out.println("sign in successfull");
		connection.close();
	}

	public boolean checkTable(String user_name) throws Exception {
		String query = "select * from user_passwords where user_name =?";

		Connection connection = getConneection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, user_name);
		ResultSet resultSet = preparedStatement.executeQuery();
		boolean res = false;
		while (resultSet.next()) {
			if (resultSet.getString(6).equals("null")) {
				res = true;
			}
		}

		return res;
	}

	public boolean loginUserPasswords(UserPasswords userPasswords) throws Exception {
		String query = "select * from user_passwords where user_name = ?";

		Connection connection = getConneection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);

		preparedStatement.setString(1, userPasswords.getUser_name());
		ResultSet resultSet = preparedStatement.executeQuery();
		String password = null;
		while (resultSet.next()) {
			password = resultSet.getString("user_password");
			if (password.equals(userPasswords.getUser_password())) {
				return true;
			}
		}
		return false;
	}

	public void saveAllPasswords(UserPasswords userPasswords) throws Exception {
		String query = "update user_passwords set facebook_pw=?,insta_pw =? ,snapchat_pw =?,whatsapp_pw =?,twitter_pw=? where user_id = ?";

		Connection connection = getConneection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, userPasswords.getFacebook_pw());
		preparedStatement.setString(2, userPasswords.getInsta_pw());
		preparedStatement.setString(3, userPasswords.getSnapchat_pw());
		preparedStatement.setString(4, userPasswords.getWhatsapp_pw());
		preparedStatement.setString(5, userPasswords.getTwitter_pw());
		preparedStatement.setInt(6, userPasswords.getUser_id());
		preparedStatement.execute();
		System.out.println("passwords are saved");
		connection.close();
	}

	public void updateFacebookPasswords(int user_id, String passwords) throws Exception {
		String query = "update user_passwords set facebook_pw = ? where user_id = ?";

		Connection connection = getConneection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, passwords);
		preparedStatement.setInt(2, user_id);
		preparedStatement.execute();
		System.out.println("new password updated");
		connection.close();
	}

	public void updateInstaPasswords(int user_id, String passwords) throws Exception {
		String query = "update user_passwords set insta_pw = ? where user_id = ?";

		Connection connection = getConneection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, passwords);
		preparedStatement.setInt(2, user_id);
		preparedStatement.execute();
		System.out.println("new password updated");
		connection.close();
	}

	public void updateSnapchatPasswords(int user_id, String passwords) throws Exception {
		String query = "update user_passwords set snapchat_pw = ? where user_id = ?";

		Connection connection = getConneection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, passwords);
		preparedStatement.setInt(2, user_id);
		preparedStatement.execute();
		System.out.println("new password updated");
		connection.close();
	}

	public void updateWhatsappPasswords(int user_id, String passwords) throws Exception {
		String query = "update user_passwords set whatsapp_pw = ? where user_id = ?";

		Connection connection = getConneection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, passwords);
		preparedStatement.setInt(2, user_id);
		preparedStatement.execute();
		System.out.println("new password updated");
		connection.close();
	}

	public void updateTwitterPasswords(int user_id, String passwords) throws Exception {
		String query = "update user_passwords set twitter_pw = ? where user_id = ?";

		Connection connection = getConneection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, passwords);
		preparedStatement.setInt(2, user_id);
		preparedStatement.execute();
		System.out.println("new password updated");
		connection.close();
	}

	public void displayPasswords(int user_id) throws Exception {
		String query = "select facebook_pw,insta_pw,snapchat_pw,whatsapp_pw,twitter_pw from user_passwords where user_id =?";

		Connection connection = getConneection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, user_id);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			System.out.println(resultSet.getString("facebook_pw"));
			System.out.println(resultSet.getString("insta_pw"));
			System.out.println(resultSet.getString("snapchat_pw"));
			System.out.println(resultSet.getString("whatsapp_pw"));
			System.out.println(resultSet.getString("twitter_pw"));
		}
		connection.close();
	}

}
