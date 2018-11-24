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
	JdbcTemplate jdbcTemplate;
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public int saveData(User u)	{
		System.out.println("in save data..");
		String query="insert into g11_users values('"+u.getUname()+"','"+u.getUemail()+"','"+u.getUmobile()+"','"+u.getUpassword()+"','"+u.getUconfirm_password()+"')";
		return jdbcTemplate.update(query);
	}

	public boolean validateUser(Login l) {
		List<User> lst = getAllUsers();
		boolean b = false;
		for(User r: lst) {
			if(r.getUemail().equalsIgnoreCase(l.getUemail())) {
				if(r.getUpassword().equalsIgnoreCase(l.getUpassword())) {
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
		        u.setUname(rs.getString(1));
		        u.setUemail(rs.getString(2));
		        u.setUmobile(rs.getString(3));
		        u.setUpassword(rs.getString(4));
		        u.setUconfirm_password(rs.getString(5));
		        list.add(u);  
		        }  
		        return list;  
		        }  
		 });  
	 }  
}