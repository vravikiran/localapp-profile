package com.local.guide.app.user.profile.entities;

import java.util.Objects;

import org.hibernate.validator.constraints.Range;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class Address extends PatchableObject {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long address_id;
	@NotBlank
	private String address_line1;
	private String address_line2;
	private int city_id;
	private int country_id;
	private int state_id;
	@NotBlank
	private String city;
	@NotBlank
	private String state;
	@NotBlank
	private String country;
	@Range(min = 100000, max = 999999)
	private int pincode;

	public long getAddress_id() {
		return address_id;
	}

	public void setAddress_id(long address_id) {
		this.address_id = address_id;
	}

	public String getAddress_line1() {
		return address_line1;
	}

	public void setAddress_line1(String address_line1) {
		this.address_line1 = address_line1;
	}

	public String getAddress_line2() {
		return address_line2;
	}

	public void setAddress_line2(String address_line2) {
		this.address_line2 = address_line2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public int getCity_id() {
		return city_id;
	}

	public void setCity_id(int city_id) {
		this.city_id = city_id;
	}

	public int getCountry_id() {
		return country_id;
	}

	public void setCountry_id(int country_id) {
		this.country_id = country_id;
	}

	public int getState_id() {
		return state_id;
	}

	public void setState_id(int state_id) {
		this.state_id = state_id;
	}

	public Address() {

	}

	@Override
	public int hashCode() {
		return Objects.hash(address_id, address_line1, address_line2, city, city_id, country, country_id, pincode,
				state, state_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return address_id == other.address_id && Objects.equals(address_line1, other.address_line1)
				&& Objects.equals(address_line2, other.address_line2) && Objects.equals(city, other.city)
				&& city_id == other.city_id && Objects.equals(country, other.country) && country_id == other.country_id
				&& pincode == other.pincode && Objects.equals(state, other.state) && state_id == other.state_id;
	}

	@Override
	public String toString() {
		return "Address [address_id=" + address_id + ", address_line1=" + address_line1 + ", address_line2="
				+ address_line2 + ", city_id=" + city_id + ", country_id=" + country_id + ", state_id=" + state_id
				+ ", city=" + city + ", state=" + state + ", country=" + country + ", pincode=" + pincode + "]";
	}

}
