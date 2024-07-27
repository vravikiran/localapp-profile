package com.local.guide.app.user.profile.entities;

import java.io.Serializable;
import java.util.Objects;

public class StatePrimaryKey implements Serializable {
	private static final long serialVersionUID = 1L;
	private int state_id;
	private int country_id;

	public int getState_id() {
		return state_id;
	}

	public void setState_id(int state_id) {
		this.state_id = state_id;
	}

	public int getCountry_id() {
		return country_id;
	}

	public void setCountry_id(int country_id) {
		this.country_id = country_id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(country_id, state_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StatePrimaryKey other = (StatePrimaryKey) obj;
		return country_id == other.country_id && state_id == other.state_id;
	}

	public StatePrimaryKey() {
		super();
		// TODO Auto-generated constructor stub
	}
}
