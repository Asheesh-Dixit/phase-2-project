package com.flyaway.dao;

import java.util.Set;

import com.flyaway.dto.Source;

public interface SourceDao {
	public Integer addSource(Source source);
	public void updateSource(int id, String source, String src);
	public void deleteSource(int id);
	public Set<Source> getAllSources();
	public Source getSourceById(int id);
}
