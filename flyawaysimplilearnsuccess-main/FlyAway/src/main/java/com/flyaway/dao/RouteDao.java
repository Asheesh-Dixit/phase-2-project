package com.flyaway.dao;

import java.util.Set;

import com.flyaway.dto.Route;

public interface RouteDao {
	public Integer addRoute(Route route);
	public void updateRoute(int id, String source, String destination, String src, String dsnt);
	public void deleteRoute(int id);
	public Set<Route> getAllRoutes();
}
