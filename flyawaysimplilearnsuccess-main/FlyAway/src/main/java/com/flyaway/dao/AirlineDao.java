package com.flyaway.dao;

import java.util.Set;

import com.flyaway.dto.Airline;

public interface AirlineDao {
	public Integer addAirline(Airline airline);
	public void updateAirline(int id, String name, String iata);
	public void deleteAirline(int id);
	public Set<Airline> getAllAirlines();
	public Airline getAirlineById(int id);
}
