package com.sales.agent.model;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sales.admin.model.AgentRegistrationModel;



@Entity
@Table(name="online_propertyregistration")

public class PropertyModel implements Serializable {
	
	private static final long serialVersionUID = -723583058586873479L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private String id;
	
	private String propertytype;
	private String city;

	private String address;
	
	private String plotarea;
	private String gender;
	private String propertyprice;
	private String mobileno;
	private String pincode;
	private String country;
	private String state;
	
	private String propertyregisterdate;
	private String username;
	private String producturl;
	private String cpath;
	private String imagename;
	
	private String imagepath;
	private String imagesize;
	private String filepath;
	private String type;
	private String status;
	
	private String agentid;
	
	public String getAgentid() {
		return agentid;
	}
	public void setAgentid(String agentid) {
		this.agentid = agentid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
	
		this.status = status;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		
		this.filepath = filepath;
	}
	public String getProducturl() {
		return producturl;
	}
	public void setProducturl(String producturl) {
		this.producturl = producturl;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPropertyregisterdate() {
		return propertyregisterdate;
	}
	public void setPropertyregisterdate(String propertyregisterdate) {
		this.propertyregisterdate = propertyregisterdate;
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
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPlotarea() {
		return plotarea;
	}
	public void setPlotarea(String plotarea) {
		this.plotarea = plotarea;
	}
	public String getCpath() {
		return cpath;
	}
	public void setCpath(String cpath) {
		this.cpath = cpath;
	}
	
	public String getImagename() {
		return imagename;
	}
	public void setImagename(String imagename) {
		this.imagename = imagename;
	}
	public String getImagepath() {
		return imagepath;
	}
	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
	public String getImagesize() {
		return imagesize;
	}
	public void setImagesize(String imagesize) {
		this.imagesize = imagesize;
	}
	public void setDept(AgentRegistrationModel dept) {
		// TODO Auto-generated method stub
		
	}
	
}
