package com.local.guide.app.user.profile.entities;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;

@Entity
@IdClass(StatePrimaryKey.class)
public class State {
	@Id
	private int state_id;
	@Id
	private int country_id;
	private String state;

	public State() {
		super();
	}

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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public int hashCode() {
		return Objects.hash(country_id, state, state_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		State other = (State) obj;
		return country_id == other.country_id && Objects.equals(state, other.state) && state_id == other.state_id;
	}

	@Override
	public String toString() {
		return "State [state_id=" + state_id + ", country_id=" + country_id + ", state=" + state + "]";
	}
}
