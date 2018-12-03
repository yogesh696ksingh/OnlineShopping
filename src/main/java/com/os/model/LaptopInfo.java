package com.os.model;
//select p.pk_g11_products,p.gp_name,p.gp_image,p.gp_price,p.gp_description,
//sl.gs_os,sl.gs_processor,sl.gs_speed,sl.gs_graphic_card,sl.gs_ram,sl.gs_hdd,sl.gs_battery
//from g11_specs_laptops sl, g11_products p where sl.gs_pid = p.pk_g11_products and sl.gs_pid = 65
public class LaptopInfo {
	private int pid;
	private String gp_name;
	private String gp_image;
	private String gp_price;
	private String gp_description;
	private String gs_os;
	private String gs_processor;
	private String gs_speed;
	private String gs_graphic_card;
	private String gs_ram;
	private String gs_hdd;
	private String gs_battery;
	private int cid;
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
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
	public String getGp_price() {
		return gp_price;
	}
	public void setGp_price(String gp_price) {
		this.gp_price = gp_price;
	}
	public String getGp_description() {
		return gp_description;
	}
	public void setGp_description(String gp_description) {
		this.gp_description = gp_description;
	}
	public String getGs_os() {
		return gs_os;
	}
	public void setGs_os(String gs_os) {
		this.gs_os = gs_os;
	}
	public String getGs_processor() {
		return gs_processor;
	}
	public void setGs_processor(String gs_processor) {
		this.gs_processor = gs_processor;
	}
	public String getGs_speed() {
		return gs_speed;
	}
	public void setGs_speed(String gs_speed) {
		this.gs_speed = gs_speed;
	}
	public String getGs_graphic_card() {
		return gs_graphic_card;
	}
	public void setGs_graphic_card(String gs_graphic_card) {
		this.gs_graphic_card = gs_graphic_card;
	}
	public String getGs_ram() {
		return gs_ram;
	}
	public void setGs_ram(String gs_ram) {
		this.gs_ram = gs_ram;
	}
	public String getGs_hdd() {
		return gs_hdd;
	}
	public void setGs_hdd(String gs_hdd) {
		this.gs_hdd = gs_hdd;
	}
	public String getGs_battery() {
		return gs_battery;
	}
	public void setGs_battery(String gs_battery) {
		this.gs_battery = gs_battery;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
}
