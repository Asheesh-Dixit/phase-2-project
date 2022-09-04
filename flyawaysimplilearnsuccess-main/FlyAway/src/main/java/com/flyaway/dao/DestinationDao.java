package com.flyaway.dao;

import java.util.Set;

import com.flyaway.dto.Destination;

public interface DestinationDao {
	public Integer addDestination(Destination destination);
	public void updateDestination(int id, String destination, String dsnt);
	public void deleteDestination(int id);
	public Set<Destination> getAllDestinations();
	public Destination getDestinationById(int id);
}
