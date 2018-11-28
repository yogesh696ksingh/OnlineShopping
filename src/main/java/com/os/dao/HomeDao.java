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

import com.os.model.Category;
import com.os.model.Product;


public class HomeDao {
	JdbcTemplate jdbcTemplate;
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	/*list to get categories*/
	public List<Category> getAllCategory(){  
		return jdbcTemplate.query("select * from g11_categories",new ResultSetExtractor<List<Category>>(){  
			public List<Category> extractData(ResultSet rs) throws SQLException, DataAccessException {    
				List<Category> list=new ArrayList<Category>();  
				while(rs.next()){  
					Category c=new Category();
					c.setPk_g11_categories(rs.getLong(1));
					c.setGc_name(rs.getString(2));
					list.add(c);  
				}  
				return list;  
			}  
		});  
	}
	public List<Product> getLatestProducts(){  
		return jdbcTemplate.query("select * from (select * from g11_products order by gp_date) where rownum < 5",new ResultSetExtractor<List<Product>>(){  
			public List<Product> extractData(ResultSet rs) throws SQLException, DataAccessException {    
				List<Product> list=new ArrayList<Product>();  
				while(rs.next()){  
					Product p=new Product();
					p.setPk_g11_products(rs.getLong(1));
					p.setGp_cid(rs.getLong(2));
					p.setGp_scid(rs.getLong(3));
					p.setGp_name(rs.getString(4));
					p.setGp_image(rs.getString(5));
					p.setGp_stock(rs.getLong(6));
					p.setGp_price(rs.getDouble(7));
					p.setGp_description(rs.getString(8));
					p.setGp_date(rs.getDate(9));
					list.add(p);  
				}  
				return list;  
			}  
		});  
	}
	public List<Product> getCategoryProducts(int id){  
		String q;
		if(id==9) {
			q= "select * from g11_products";
			return jdbcTemplate.query(q, new ResultSetExtractor<List<Product>>(){  
				public List<Product> extractData(ResultSet rs) throws SQLException, DataAccessException {    
					List<Product> list=new ArrayList<Product>();  
					while(rs.next()){  
						Product p=new Product();
						p.setPk_g11_products(rs.getLong(1));
						p.setGp_cid(rs.getLong(2));
						p.setGp_scid(rs.getLong(3));
						p.setGp_name(rs.getString(4));
						p.setGp_image(rs.getString(5));
						p.setGp_stock(rs.getLong(6));
						p.setGp_price(rs.getDouble(7));
						p.setGp_description(rs.getString(8));
						p.setGp_date(rs.getDate(9));
						list.add(p);  
					}  
					return list;  
				}  
			});
		}
		else {
			q = "select * from g11_products where gp_cid = ?";
			return jdbcTemplate.query(q, new Object[] {id}, new ResultSetExtractor<List<Product>>(){  
				public List<Product> extractData(ResultSet rs) throws SQLException, DataAccessException {    
					List<Product> list=new ArrayList<Product>();  
					while(rs.next()){  
						Product p=new Product();
						p.setPk_g11_products(rs.getLong(1));
						p.setGp_cid(rs.getLong(2));
						p.setGp_scid(rs.getLong(3));
						p.setGp_name(rs.getString(4));
						p.setGp_image(rs.getString(5));
						p.setGp_stock(rs.getLong(6));
						p.setGp_price(rs.getDouble(7));
						p.setGp_description(rs.getString(8));
						p.setGp_date(rs.getDate(9));
						list.add(p);  
					}  
					return list;  
				}  
			}); 
		}
		 
	}
}
