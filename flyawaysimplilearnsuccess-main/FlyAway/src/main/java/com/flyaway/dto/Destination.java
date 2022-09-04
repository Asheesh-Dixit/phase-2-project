package com.flyaway.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "destinations")
public class Destination {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "destination")
	private String destination;
	
	@Column(name = "dsnt")
	private String dsnt;
	

	public Destination() {
		// TODO Auto-generated constructor stub
	}


	public Destination(String destination, String dsnt) {
		this.destination = destination;
		this.dsnt = dsnt;
	}


	@Override
	public String toString() {
		return "Destination [id=" + id + ", destination=" + destination + ", Short Name=" + dsnt + "]";
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public String getDestination() {
		return destination;
	}


	public void setDestination(String destination) {
		this.destination = destination;
	}


	public String getDsnt() {
		return dsnt;
	}


	public void setDsnt(String dsnt) {
		this.dsnt = dsnt;
	}
	

}
