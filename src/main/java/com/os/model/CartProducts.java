package com.os.model;

import java.sql.Date;

public class CartProducts {
	private long pk_g11_cartproducts;
	private long gp_id;
	private long gu_id;
	private long gc_quantity;
	private String gp_name;
	private double gp_price;
	
	public long getPk_g11_cartproducts() {
		return pk_g11_cartproducts;
	}

	public void setPk_g11_cartproducts(long pk_g11_cartproducts) {
		this.pk_g11_cartproducts = pk_g11_cartproducts;
	}

	public long getGp_id() {
		return gp_id;
	}
	public void setGp_id(long gp_id) {
		this.gp_id = gp_id;
	}
	public long getGu_id() {
		return gu_id;
	}
	public void setGu_id(long gu_id) {
		this.gu_id = gu_id;
	}
	public long getGc_quantity() {
		return gc_quantity;
	}
	public void setGc_quantity(long gc_quantity) {
		this.gc_quantity = gc_quantity;
	}

	public String getGp_name() {
		return gp_name;
	}

	public void setGp_name(String gp_name) {
		this.gp_name = gp_name;
	}

	public double getGp_price() {
		return gp_price;
	}

	public void setGp_price(double gp_price) {
		this.gp_price = gp_price;
	}

	

}
