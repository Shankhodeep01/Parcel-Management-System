package userModel;

public class User {
	private String userName;
	private String email;
	private String password;
	
	public User(String username, String email, String password) {
		this.userName = username;
		this.email = email;
		this.password = password;
	}
	
	public String getUserName() {
		return this.userName;
	}
	public String getEmail() {
		return this.email;
	}
	public String getPassword() {
		return this.password;
	}
}
