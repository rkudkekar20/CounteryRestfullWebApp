package com.bikkadit.CounteryRestfullWebApp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="COUNTRY_DTLS")
public class Countries {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="COUNTRY_NAME")
	private String countryName;
	@Column(name="CAPITAL_NAME")
	private String capitalName;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getCapitalName() {
		return capitalName;
	}
	public void setCapitalName(String capitalName) {
		this.capitalName = capitalName;
	}
	@Override
	public String toString() {
		return "Countries [id=" + id + ", countryName=" + countryName + ", capitalName=" + capitalName + "]";
	}
	
	
	

}
