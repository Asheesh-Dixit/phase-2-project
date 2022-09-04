package com.flyaway.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sources")
public class Source {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "source")
	private String source;
	
	@Column(name = "src")
	private String src;

	public Source() {
		// TODO Auto-generated constructor stub
	}


	public Source(String source, String src ) {
		this.source = source;
		this.src = src;
	}


	@Override
	public String toString() {
		return "Source [id=" + id + ", source=" + source + ", short Name=" + src + "]";
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

	public String getSrc() {
		return src;
	}


	public void setSrc(String src) {
		this.src = src;
	}

}
