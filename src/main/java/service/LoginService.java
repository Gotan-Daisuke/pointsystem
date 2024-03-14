package service;

import java.util.List;

import dao.LoginDao;
import entity.LoginEntity;

public class LoginService {
	LoginDao dao = new LoginDao();
	
	public List<LoginEntity> findbylogin(String userid, String password){
		return dao.findbylogin(userid, password);
	}

}
