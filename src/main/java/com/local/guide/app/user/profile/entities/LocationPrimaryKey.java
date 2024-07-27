package com.local.guide.app.user.profile.entities;

import java.io.Serializable;
import java.util.Objects;

public class LocationPrimaryKey implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer location_id;
	private Integer state_id;
	private Integer country_id;

	@Override
	public int hashCode() {
		return Objects.hash(country_id, location_id, state_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LocationPrimaryKey other = (LocationPrimaryKey) obj;
		return Objects.equals(country_id, other.country_id) && Objects.equals(location_id, other.location_id)
				&& Objects.equals(state_id, other.state_id);
	}

	public LocationPrimaryKey() {
		super();
		// TODO Auto-generated constructor stub
	}
}
