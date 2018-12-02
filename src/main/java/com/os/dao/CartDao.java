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

import com.os.model.BillingDetails;
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
		String count_q = "select count(*) AS count_prod from g11_cartproducts where gu_id = ? and gp_id = ?";
		int qcount = jdbcTemplate.queryForObject(count_q, new Object[] {uid, pid}, Integer.class);
		if(qcount == 0) 
			return 1;
		else {
			String quant_q = "select gc_quantity from g11_cartproducts where gu_id = ? and gp_id = ?";
			int quant = jdbcTemplate.queryForObject(quant_q, new Object[] {uid, pid}, Integer.class);
			quant++;
			return quant;
		}
	}
	public double getPrice(long pid) {
		String priceq = "select gp_price from g11_products where pk_g11_products = ?";
		double init_price = jdbcTemplate.queryForObject(priceq, new Object[] {pid}, Double.class);
		return init_price;
	}
	public int saveCart(CartProducts cp)	{
		String query="insert into g11_cartproducts values(g11_cartproducts_seq.nextval,'"+cp.getGp_id()+"','"+cp.getGu_id()+"','"+cp.getGc_quantity()+"','"+cp.getGp_price()+"')";
		return jdbcTemplate.update(query);
	}
	public int updateCart(CartProducts cp, int quant) {
		String query = "update g11_cartproducts set gc_quantity = '"+quant+"', gc_price = '"+cp.getGp_price()+"' where gp_id = '"+cp.getGp_id()+"'";
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
					double price = rs.getLong(4) * rs.getDouble(6);
					cp.setGp_price(price);
					list.add(cp);
				}  
				return list;  
			}  
		});
	}

	public double getTotalPrice(long uid) {
		String total_q = "select SUM(gc_price) AS total from g11_cartproducts where gu_id = ?";
		Double total= jdbcTemplate.queryForObject(total_q, new Object[] {uid}, Double.class);
		return total;
	}

	public int saveBillData(List<CartProducts> list, long user_id) {
		for(CartProducts cp : list) {
			String q = "insert into g11_billingdetails values(g11_billing_seq.NEXTVAL, "+cp.getGp_id()+", "+cp.getGu_id()+", "+cp.getGc_quantity()+", '"+cp.getGp_name()+"', '"+cp.getGp_price()+"')";
			jdbcTemplate.update(q);
		}
		String query = "delete from g11_cartproducts where gu_id = "+user_id;
		return jdbcTemplate.update(query);
	}

	public List<BillingDetails> getBillingData(long user_id) {
		String q="select * from g11_billingdetails where gu_id = ?";
		return jdbcTemplate.query(q, new Object[] {user_id}, new ResultSetExtractor<List<BillingDetails>>(){  
			public List<BillingDetails> extractData(ResultSet rs) throws SQLException, DataAccessException {    
				List<BillingDetails> list = new LinkedList<BillingDetails>();  
				while(rs.next()){  
					BillingDetails cp = new BillingDetails();
					cp.setPk_g11_billing(rs.getInt(1));
					cp.setGp_id(rs.getInt(2));
					cp.setGu_id(rs.getInt(3));
					cp.setGb_quantity(rs.getInt(4));; 
					cp.setGp_name(rs.getString(5));
					cp.setGp_price(rs.getString(6));
					list.add(cp);
				}  
				return list;  
			}  
		});	
	}
	public int removeCartData(int pid, long user_id) {
		String q = "delete from g11_cartproducts where gu_id = "+user_id+" and gp_id = "+pid;
		return jdbcTemplate.update(q);
	}
	
	public int addCartData(int pid, long user_id) {
		String q = "update g11_cartproducts set gc_quantity = (gc_quantity+1) where gu_id = "+user_id+" and gp_id = "+pid;
		String priceq = "select gc_price from g11_cartproducts where gu_id = "+user_id+" and gp_id = "+pid;
		double init_price = jdbcTemplate.queryForObject(priceq, Double.class);
		String quantq = "select gc_quantity from g11_cartproducts where gu_id = "+user_id+" and gp_id = "+pid;
		double quant = jdbcTemplate.queryForObject(quantq, Integer.class);
		double finalprice = quant * init_price;
		String finalq = "update g11_cartproducts set gc_price = "+finalprice+" where gu_id = "+user_id+" and gp_id = "+pid;
		return jdbcTemplate.update(q);
	}
	public int deduceCartData(int pid, long user_id) {
		String q = "update g11_cartproducts set gc_quantity = (gc_quantity-1) where gu_id = "+user_id+" and gp_id = "+pid;
		String priceq = "select gc_price from g11_cartproducts where gu_id = "+user_id+" and gp_id = "+pid;
		double init_price = jdbcTemplate.queryForObject(priceq, Double.class);
		String quantq = "select gc_quantity from g11_cartproducts where gu_id = "+user_id+" and gp_id = "+pid;
		double quant = jdbcTemplate.queryForObject(quantq, Integer.class);
		double finalprice = quant * init_price;
		String finalq = "update g11_cartproducts set gc_price = "+finalprice+" where gu_id = "+user_id+" and gp_id = "+pid;
		return jdbcTemplate.update(q);
	}
}
