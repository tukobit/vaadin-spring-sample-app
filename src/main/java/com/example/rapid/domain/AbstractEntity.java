package com.example.rapid.domain;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class AbstractEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2391552602963217134L;
	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
