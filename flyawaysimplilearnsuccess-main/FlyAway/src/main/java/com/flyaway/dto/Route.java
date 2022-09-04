package com.flyaway.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "routes")
public class Route {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "source")
	private String source;
	
	@Column(name = "src")
	private String src;
	
	@Column(name = "destination")
	private String destination;
	
	@Column(name = "dsnt")
	private String dsnt;
	

	public Route() {
		// TODO Auto-generated constructor stub
	}


	public Route(String source, String destination, String src, String dsnt) {
		this.source = source;
		this.destination = destination;
		this.src = src;
		this.dsnt = dsnt;
	}


	@Override
	public String toString() {
		return "Route [id=" + id + ", source=" + source + ", destination=" + destination + "]";
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getSource() {
		return source;
	}


	public void setSource(String source) {
		this.source = source;
	}


	public String getDestination() {
		return destination;
	}


	public void setDestination(String destination) {
		this.destination = destination;
	}


	public String getSrc() {
		return src;
	}


	public void setSrc(String src) {
		this.src = src;
	}


	public String getDsnt() {
		return dsnt;
	}


	public void setDsnt(String dsnt) {
		this.dsnt = dsnt;
	}
	

}
