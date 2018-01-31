package com.sales.admin.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import com.sales.agent.model.PropertyModel;
import com.sales.home.model.RegistrationModel;

@Entity
@Table(name="online_AgentRegitration")

public class AgentRegistrationModel implements Serializable {
	
	private static final long serialVersionUID = -723583058586873479L;
	@Id
	/*@GeneratedValue(strategy=GenerationType.AUTO)*/
	@Column(name = "id")
	private String id;
	
	@Column(name="firstname")
	private String firstname;
	
	@Column(name="middlename")
	private String middlename;
	
	@Column(name="lastname")
	private String lastname;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="conformpassword")
	private String conformpassword;
	
	@Column(name="dateofbirth")
	private String dateofbirth;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="emailid")
	private String email;
	
@Column(name="language")
	private String language;


	public String getLanguage() {
	return language;
}

public void setLanguage(String language) {
	this.language = language;
}

	@Column(name="mobilenumber")
	private String mobileno;
	
	@Column(name="address")
	private String address;
	
	@Column(name="pincode")
	private String pincode;
	
	@Column(name="country")
	private String country;
	
	@Column(name="state")
	private String state;
	
	@Column(name="city")
	private String city;
	
	@Column(name="Type")
	private String type;
	
	@Column(name="Status")
	private String status;
	
	
/*	private String registerdate;*/
	private String dateofjoining;

	

	public String getDateofjoining() {
		return dateofjoining;
	}

	public void setDateofjoining(String dateofjoining) {
		this.dateofjoining = dateofjoining;
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

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConformpassword() {
		return conformpassword;
	}

	public void setConformpassword(String conformpassword) {
		this.conformpassword = conformpassword;
	}

	public String getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}



	/*@SuppressWarnings("rawtypes")
	@OneToMany(targetEntity=PropertyModel.class,cascade={CascadeType.ALL},fetch=FetchType.EAGER,mappedBy="id")
	private Set Employee = new HashSet(0);
	@SuppressWarnings("rawtypes")
	public Set getEmployee() {
		return Employee;
	}
	@SuppressWarnings("rawtypes")
	public void setEmployee(Set emp) {
		Employee = emp;
	}*/
	
	@OneToMany(fetch=FetchType.LAZY, targetEntity=PropertyModel.class, cascade=CascadeType.ALL)
	@JoinColumn(name = "", referencedColumnName="id")
	
	private Set children;

/*
	public Set getChildren() {
		return children;
	}

	public void setChildren(Set children) {
		this.children = children;
	}*/


	
}
