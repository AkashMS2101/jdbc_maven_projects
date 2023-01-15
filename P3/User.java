package jdbc_maven_eb9_3;

public class User {
	int user_id;
	String user_name;
	String password;
	long phone;
	String e_mailid;

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getE_mailid() {
		return e_mailid;
	}

	public void setE_mailid(String e_mailid) {
		this.e_mailid = e_mailid;
	}

}
