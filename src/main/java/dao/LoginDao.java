package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.LoginEntity;

public class LoginDao {
	
    // PostgreSQLに接続するためのURL
    private static final String  url = "jdbc:postgresql://localhost:5432/postgres";
    private static final String user = "postgres";
    private static final String pass = "password";
    
	private static Connection getConnection(){
	   try {
		    Class.forName("org.postgresql.Driver");
	       Connection con = DriverManager.getConnection(url, user, pass);
	       return con;
	   }catch(Exception e){
	       throw new IllegalStateException(e);
	   }
	}
	
	public List<LoginEntity> findbylogin(String userid, String password){
		
		
		String sql = "SELECT * FROM login WHERE userid=? AND userpassword=?";
		try (Connection con = getConnection();) {
			
			 PreparedStatement pstmt = con.prepareStatement(sql);
			 
            pstmt.setString(1, userid);
            pstmt.setString(2, password);
			
            ResultSet rs = pstmt.executeQuery();
            
			List<LoginEntity> list = new ArrayList<>();
			while (rs.next()) {
				int id = rs.getInt("id");
				String useid = rs.getString("userid");
				String userpassword = rs.getString("userpassword");
				String username = rs.getString("username");
				list.add(new LoginEntity(id, useid, userpassword, username));
			}
			return list;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
