package com.local.guide.app.user.profile.entities;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Country {
	private String country;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer country_id;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Integer getCountry_id() {
		return country_id;
	}

	public void setCountry_id(Integer country_id) {
		this.country_id = country_id;
	}

	public Country() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(country, country_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Country other = (Country) obj;
		return Objects.equals(country, other.country) && Objects.equals(country_id, other.country_id);
	}

	@Override
	public String toString() {
		return "Country [country=" + country + ", country_id=" + country_id + "]";
	}
}
