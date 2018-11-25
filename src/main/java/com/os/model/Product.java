package com.os.model;

import java.sql.Date;

public class Product {
	private long pk_g11_products;
	private long gp_cid;
	private long gp_scid;
	private String gp_name;
	private String gp_image;
	private long gp_stock;
	private double price;
	private String gp_description;
	private Date gp_date;
	public long getPk_g11_products() {
		return pk_g11_products;
	}
	public void setPk_g11_products(long pk_g11_products) {
		this.pk_g11_products = pk_g11_products;
	}
	public long getGp_cid() {
		return gp_cid;
	}
	public void setGp_cid(long gp_cid) {
		this.gp_cid = gp_cid;
	}
	public long getGp_scid() {
		return gp_scid;
	}
	public void setGp_scid(long gp_scid) {
		this.gp_scid = gp_scid;
	}
	public String getGp_name() {
		return gp_name;
	}
	public void setGp_name(String gp_name) {
		this.gp_name = gp_name;
	}
	public String getGp_image() {
		return gp_image;
	}
	public void setGp_image(String gp_image) {
		this.gp_image = gp_image;
	}
	public long getGp_stock() {
		return gp_stock;
	}
	public void setGp_stock(long gp_stock) {
		this.gp_stock = gp_stock;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getGp_description() {
		return gp_description;
	}
	public void setGp_description(String gp_description) {
		this.gp_description = gp_description;
	}
	public Date getGp_date() {
		return gp_date;
	}
	public void setGp_date(Date gp_date) {
		this.gp_date = gp_date;
	}
}
