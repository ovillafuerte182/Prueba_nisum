package com.example.model;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Phones {

	@ManyToOne
	@JoinColumn(name = "id")
	User id;
	
	@Column(name = "number")
	private String number;
	
	@Column(name = "cityCode")
	private String cityCode;
	
	@Column(name = "countryCode")
	private String countryCode;
	
	public User getId() {
		return id;
	}

	public void setId(User id) {
		this.id = id;
	}
	
	public String getNumber() {
		return number;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
	
	public String getCityCode() {
		return cityCode;
	}
	
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	
	public String getCountryCode() {
		return countryCode;
	}
	
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

}
