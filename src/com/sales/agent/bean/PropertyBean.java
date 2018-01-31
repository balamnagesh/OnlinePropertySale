package com.sales.agent.bean;

import java.util.List;

import org.apache.commons.lang.WordUtils;
import org.springframework.web.multipart.MultipartFile;


public class PropertyBean {

	private String propertytype;
	private String city;
	private String locality;
	private String address;
	private String owner;
	private String plotarea;
	private String gender;
	private String propertyprice;
	private String mobileno;
	private String pincode;
	private String country;
	private String state;
	private String longtude;
	private String latitude;
	private String propertyregisterdate;
	private String producturl;
	private String cpath;
	private String imagename;
	private String imagepath;
	private String imagesize;
	private String status;
	private String filepath;
	private String id;
	

	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<MultipartFile> getFile() {
		return file;
	}
	public void setFile(List<MultipartFile> file) {
		
		this.file = file;
		System.out.println("cmming to imagebean "+file);
	}
	
	private String color;
	private long productImageSize;
	
	
	private List< MultipartFile>  file;
	
	
	public long getProductImageSize() {
		return productImageSize;
	}
	public void setProductImageSize(long productImageSize) {
		this.productImageSize = productImageSize;
	}


	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getImagename() {
		return imagename;
	}
	public void setImagename(String imagename) {
		this.imagename = imagename;
	}
	public String getImagesize() {
		return imagesize;
	}
	public void setImagesize(String imagesize) {
		this.imagesize = imagesize;
	}
	
	public String getCpath() {
		return cpath;
	}
	public void setCpath(String cpath) {
		this.cpath = cpath;
	}
	public String getProducturl() {
		return producturl;
	}
	public void setProducturl(String producturl) {
		this.producturl = producturl;
	}
	public String getImagepath() {
		return imagepath;
	}
	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
	
	
	public String getPropertyregisterdate() {
		return propertyregisterdate;
	}
	public void setPropertyregisterdate(String propertyregisterdate) {
		this.propertyregisterdate = propertyregisterdate;
	}
	public String getLongtude() {
		return longtude;
	}
	public void setLongtude(String longtude) {
		this.longtude = longtude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getPropertyprice() {
		return propertyprice;
	}
	public void setPropertyprice(String propertyprice) {
		this.propertyprice = propertyprice;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPropertytype() {
		return propertytype;
	}
	public void setPropertytype(String propertytype) {
		this.propertytype = propertytype;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getLocality() {
		return locality;
	}
	public void setLocality(String locality) {
		this.locality = locality;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getPlotarea() {
		return plotarea;
	}
	public void setPlotarea(String plotarea) {
		this.plotarea = plotarea;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	
	
}
