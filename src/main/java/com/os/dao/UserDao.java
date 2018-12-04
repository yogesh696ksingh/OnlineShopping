package com.os.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.os.model.Login;
import com.os.model.User;

public class UserDao// implements DaoInter
{
	int genID;
	JdbcTemplate jdbcTemplate;
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public int saveData(User u)	{
		String query="insert into g11_users values(g11_users_seq.nextval,'"+u.getGu_name()+"','"+u.getGu_email()+"','"+u.getGu_mobile()+"','"+u.getGu_password()+"','"+u.getGu_confirm_password()+"','"+u.getGu_usertype()+"')";
		return jdbcTemplate.update(query);
	}

	public boolean validateUser(Login l) {
		List<User> lst = getAllUsers();
		boolean b = false;
		for(User r: lst) {
			if(r.getGu_email().equalsIgnoreCase(l.getGu_email()) ) {
				if(r.getGu_password().equalsIgnoreCase(l.getGu_password())) {
					b = true;
					break;
				}
			}
		}
		return b;
	}
	
	public boolean validateAdmin(Login l) {
		List<User> lst = getAllUsers();
		boolean b = false;
		for(User r: lst) {
			if(r.getGu_email().equalsIgnoreCase(l.getGu_email()) && r.getGu_email().equalsIgnoreCase("admin@root.com") ) {
				if(r.getGu_password().equalsIgnoreCase(l.getGu_password()) && r.getGu_password().equalsIgnoreCase("root")) {
					b = true;
					break;
				}
			}
		}
		return b;
	}

	
	public List<User> getAllUsers(){  
		return jdbcTemplate.query("select * from g11_users",new ResultSetExtractor<List<User>>(){  
			public List<User> extractData(ResultSet rs) throws SQLException, DataAccessException {    
				List<User> list=new ArrayList<User>();  
				while(rs.next()){  
					User u=new User();
					u.setPk_g11_users(rs.getLong(1));
					u.setGu_name(rs.getString(2));
					u.setGu_email(rs.getString(3));
					u.setGu_mobile(rs.getString(4));
					u.setGu_password(rs.getString(5));
					u.setGu_confirm_password(rs.getString(6));
					list.add(u);  
				}  
				return list;  
			}  
		});  
	}  
}