package com.os.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import com.os.model.CartProducts;
import com.os.model.Category;
import com.os.model.Product;

public class CartDao {
/*	private long pk_g11_products;
	private long gp_id;
	private long gu_id;
	private long gc_quantity;*/
	int quantity = 0;
	JdbcTemplate jdbcTemplate;
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public int getProductQuantity(long pid, long uid) {
		
		String q = "select count(*) AS count_prod from g11_cartproducts where gu_id = ? and gp_id = ?";
		int count = jdbcTemplate.queryForObject(q, new Object[] {uid, pid}, Integer.class);
		count+=1;
		return count;
	}
	public int saveCart(CartProducts cp)	{
		String query="insert into g11_cartproducts values(g11_cartproducts_seq.nextval,'"+cp.getGp_id()+"','"+cp.getGu_id()+"','"+cp.getGc_quantity()+"')";
		return jdbcTemplate.update(query);
	}
	public List<CartProducts> getCartData(long user_id) {
		String q="select cp.pk_g11_cartproducts, cp.gp_id, cp.gu_id, cp.gc_quantity, p.gp_name, p.gp_price  from g11_cartproducts cp, g11_products p where cp.gp_id = p.pk_g11_products AND cp.gu_id = ?";
		return jdbcTemplate.query(q, new Object[] {user_id}, new ResultSetExtractor<List<CartProducts>>(){  
			public List<CartProducts> extractData(ResultSet rs) throws SQLException, DataAccessException {    
				List<CartProducts> list = new LinkedList<CartProducts>();  
				while(rs.next()){  
					CartProducts cp = new CartProducts();
					cp.setPk_g11_cartproducts(rs.getLong(1));
					cp.setGp_id(rs.getLong(2));
					cp.setGu_id(rs.getLong(3));
					cp.setGc_quantity(rs.getLong(4)); 
					cp.setGp_name(rs.getString(5));
					cp.setGp_price(rs.getDouble(6));
					list.add(cp);
				}  
				return list;  
			}  
		});
	}
}
