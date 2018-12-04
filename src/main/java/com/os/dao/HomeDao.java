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
import com.os.model.LaptopInfo;
import com.os.model.MobileInfo;
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
		return jdbcTemplate.query("select * from g11_products where rownum < 5 order by gp_price ",new ResultSetExtractor<List<Product>>(){  
			public List<Product> extractData(ResultSet rs) throws SQLException, DataAccessException {    
				List<Product> list=new ArrayList<Product>();  
				while(rs.next()){  
					Product p=new Product();
					p.setPk_g11_products(rs.getLong(1));
					p.setGp_cid(rs.getLong(2));					
					p.setGp_name(rs.getString(3));
					p.setGp_image(rs.getString(4));
					p.setGp_stock(rs.getLong(5));
					p.setGp_price(rs.getDouble(6));
					p.setGp_description(rs.getString(7));
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
						p.setGp_name(rs.getString(3));
						p.setGp_image(rs.getString(4));
						p.setGp_stock(rs.getLong(5));
						p.setGp_price(rs.getDouble(6));
						p.setGp_description(rs.getString(7));
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
						p.setGp_name(rs.getString(3));
						p.setGp_image(rs.getString(4));
						p.setGp_stock(rs.getLong(5));
						p.setGp_price(rs.getDouble(6));
						p.setGp_description(rs.getString(7));
						list.add(p);    
					}  
					return list;  
				}  
			}); 
		}

	}
	public List<Product> getProductData(int id){  
		String q = "select * from g11_products where pk_g11_products = ?";
		return jdbcTemplate.query(q, new Object[] {id}, new ResultSetExtractor<List<Product>>(){  
			public List<Product> extractData(ResultSet rs) throws SQLException, DataAccessException {    
				List<Product> list=new ArrayList<Product>();  
				while(rs.next()){  
					Product p=new Product();
					p.setPk_g11_products(rs.getLong(1));
					p.setGp_cid(rs.getLong(2));					
					p.setGp_name(rs.getString(3));
					p.setGp_image(rs.getString(4));
					p.setGp_stock(rs.getLong(5));
					p.setGp_price(rs.getDouble(6));
					p.setGp_description(rs.getString(7));
					list.add(p);    
				}  
				return list;  
			}  
		});  
	}

	public List<LaptopInfo> getLaptopInfo(int pid) {
		String q ="select p.pk_g11_products,p.gp_name,p.gp_image,p.gp_price,p.gp_description,sl.gs_os,sl.gs_processor, sl.gs_speed,sl.gs_graphic_card,sl.gs_ram,sl.gs_hdd,sl.gs_battery from g11_specs_laptops sl, g11_products p where sl.gs_pid = p.pk_g11_products and sl.gs_pid = ?";
		return jdbcTemplate.query(q, new Object[] {pid} ,new ResultSetExtractor<List<LaptopInfo>>(){  
			public List<LaptopInfo> extractData(ResultSet rs) throws SQLException, DataAccessException {    
				List<LaptopInfo> list=new ArrayList<LaptopInfo>();  
				while(rs.next()){  
					LaptopInfo li = new LaptopInfo();
					li.setPid(rs.getInt(1));
					li.setGp_name(rs.getString(2));
					li.setGp_image(rs.getString(3));
					li.setGp_price(rs.getString(4));
					li.setGp_description(rs.getString(5));
					li.setGs_os(rs.getString(6));
					li.setGs_processor(rs.getString(6));
					li.setGs_speed(rs.getString(7));
					li.setGs_graphic_card(rs.getString(8));
					li.setGs_ram(rs.getString(9));
					li.setGs_hdd(rs.getString(10));
					li.setGs_battery(rs.getString(11));
					list.add(li);  
				}  
				return list;  
			}  
		});  
	}

	public List<MobileInfo> getMobileInfo(int pid) {
		String q ="select p.pk_g11_products,p.gp_name,p.gp_image,p.gp_price,p.gp_description,sm.gs_internal_memory,sm.gs_ram,sm.gs_pcam,sm.gs_scam,sm.gs_screen,sm.gs_core,sm.gs_battery from g11_specs_mobiles sm,g11_products p where sm.gs_pid = p.pk_g11_products and sm.gs_pid = ?";
		return jdbcTemplate.query(q, new Object[] {pid} ,new ResultSetExtractor<List<MobileInfo>>(){  
			public List<MobileInfo> extractData(ResultSet rs) throws SQLException, DataAccessException {    
				List<MobileInfo> list=new ArrayList<MobileInfo>();  
				while(rs.next()){  
					MobileInfo mi = new MobileInfo();
					mi.setPid(rs.getInt(1));
					mi.setGp_name(rs.getString(2));
					mi.setGp_image(rs.getString(3));
					mi.setGp_price(rs.getString(4));
					mi.setGp_description(rs.getString(5));
					mi.setGs_internal_memory(rs.getString(6));
					mi.setGs_ram(rs.getString(7));
					mi.setGs_pcam(rs.getString(8));
					mi.setGs_scam(rs.getString(9));
					mi.setGs_screen(rs.getString(10));
					mi.setGs_core(rs.getString(11));
					mi.setGs_battery(rs.getString(12));;
					list.add(mi);  
				}  
				return list;  
			}  
		});  
	}
}
