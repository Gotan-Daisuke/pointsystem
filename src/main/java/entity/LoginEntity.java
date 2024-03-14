package entity;

public class LoginEntity {
	
	private Integer id;
	private String userid;
	private String userpassword;
	private String username;
	
	public LoginEntity() {
	}
	
	public LoginEntity(Integer id, String userid, String userpassword, String username) {
		this.id = id;
		this.userid = userid;
		this.userpassword = userpassword;
		this.username = username;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getUserid() {
		return userid;
	}
	
	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserpassword() {
		return userpassword;
	}
	
	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
}
