package userDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import userModel.User;

public class UserDao {
	private final String url="jdbc:mysql://127.0.0.1:3306/userdb";
	private final String username = "root";
	private final String password = "Shankho@2002";
	Connection con = null;
	
	public UserDao()  {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean registerUser(User user) throws SQLException {
		
		String sql = "INSERT INTO users (name, email, password) VALUES (?, ?, ?);";
		
		PreparedStatement pdst = null;
		
		try {
			
			pdst = con.prepareStatement(sql);
			
			pdst.setString(1, user.getUserName());
            pdst.setString(2, user.getEmail());
            pdst.setString(3, user.getPassword()); 

            // Execute the query
            int result = pdst.executeUpdate();
            
            return result > 0;
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return false;
	} 
	
	public User authenticateUser(String email, String password) {
		
		String sql = "select * from users where email = ? and password = ?";
		
		try {
			
			PreparedStatement pdst = con.prepareStatement(sql);
			
			pdst.setString(1, email);
			pdst.setString(2, password);
			
			ResultSet rs = pdst.executeQuery();
			
			if(rs.next()) {
				return new User(rs.getString("name"), rs.getString("email"), rs.getString("password"));
				
			}
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		return null;
	}
}
