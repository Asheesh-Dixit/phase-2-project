package com.flyaway.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "flights")
public class Flight {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "flight_name")
	private String flight_name;
	
	@Column(name = "airline")
	private String airline;
	
    @Column(name = "source_id")
	private String source;
	
	@Column(name = "destination")
	private String destination;
	
	@Column(name = "time")
	private String time;
	
	@Column(name = "price")
	private String price;
	
	public Flight() {}

	public Flight(String flight_name, String airline, String source, String destination, String time,
			String price) {
		this.flight_name = flight_name;
		this.airline = airline;
		this.source = source;
		this.destination = destination;
		this.time = time;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Flight [id=" + id + ", flight_name=" + flight_name + ", source=" + source + ", destination="
				+ destination + ", time=" + time + ", price=" + price + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFlight_name() {
		return flight_name;
	}

	public void setFlight_name(String flight_name) {
		this.flight_name = flight_name;
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

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}



}
