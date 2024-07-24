package com.local.guide.app.user.profile.entities;

import java.util.Objects;

import org.hibernate.validator.constraints.Range;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class User extends PatchableObject {
	@Id
	@Range(min = 1000000000L, max = 9999999999L)
	private Long mobile_no;
	@NotNull
	private String first_name;
	@NotNull
	private String last_name;
	@Email
	private String email;
	@NotNull
	private Long aadhar_number;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id", referencedColumnName = "address_id")
	private Address address;
	private boolean is_email_verified;
	private boolean is_aadhar_verified;

	public boolean isIs_email_verified() {
		return is_email_verified;
	}

	public void setIs_email_verified(boolean is_email_verified) {
		this.is_email_verified = is_email_verified;
	}

	public boolean isIs_aadhar_verified() {
		return is_aadhar_verified;
	}

	public void setIs_aadhar_verified(boolean is_aadhar_verified) {
		this.is_aadhar_verified = is_aadhar_verified;
	}

	public Long getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(Long mobile_no) {
		this.mobile_no = mobile_no;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getAadhar_number() {
		return aadhar_number;
	}

	public void setAadhar_number(Long aadhar_number) {
		this.aadhar_number = aadhar_number;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address addresses) {
		this.address = addresses;
	}

	public User() {

	}

	@Override
	public int hashCode() {
		return Objects.hash(aadhar_number, address, email, first_name, is_aadhar_verified, is_email_verified, last_name,
				mobile_no);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(aadhar_number, other.aadhar_number) && Objects.equals(address, other.address)
				&& Objects.equals(email, other.email) && Objects.equals(first_name, other.first_name)
				&& is_aadhar_verified == other.is_aadhar_verified && is_email_verified == other.is_email_verified
				&& Objects.equals(last_name, other.last_name) && Objects.equals(mobile_no, other.mobile_no);
	}

	@Override
	public String toString() {
		return "User [mobile_no=" + mobile_no + ", first_name=" + first_name + ", last_name=" + last_name + ", email="
				+ email + ", aadhar_number=" + aadhar_number + ", address=" + address + ", is_email_verified="
				+ is_email_verified + ", is_aadhar_verified=" + is_aadhar_verified + "]";
	}
}
