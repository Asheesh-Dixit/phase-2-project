package com.flyaway.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "airlines")
public class Airline {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "iata")
	private String iata;
	

	public Airline() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Airline(String name, String iata) {
		this.name = name;
		this.iata = iata;
	}


	@Override
	public String toString() {
		return "AirLine [id=" + id + ", name=" + name + ", iata=" + iata + "]";
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getIata() {
		return iata;
	}


	public void setIata(String iata) {
		this.iata = iata;
	}
	
	

}
