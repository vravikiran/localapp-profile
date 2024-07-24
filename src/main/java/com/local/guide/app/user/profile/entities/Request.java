package com.local.guide.app.user.profile.entities;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Request extends PatchableObject {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String status;
	private LocalDate start_date;
	private LocalDate end_date;
	private int no_of_persons;
	private boolean is_room_required;
	private boolean is_vehicle_required;
	private boolean is_food_required;
	private String places;
	private String plan_type;
	@Column(updatable = false)
	private int traveller_id;
	@Column(updatable = false)
	private String traveller_name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getStart_date() {
		return start_date;
	}

	public void setStart_date(LocalDate start_date) {
		this.start_date = start_date;
	}

	public int getNo_of_persons() {
		return no_of_persons;
	}

	public void setNo_of_persons(int no_of_persons) {
		this.no_of_persons = no_of_persons;
	}

	public boolean isIs_room_required() {
		return is_room_required;
	}

	public void setIs_room_required(boolean is_room_required) {
		this.is_room_required = is_room_required;
	}

	public boolean isIs_vehicle_required() {
		return is_vehicle_required;
	}

	public void setIs_vehicle_required(boolean is_vehicle_required) {
		this.is_vehicle_required = is_vehicle_required;
	}

	public boolean isIs_food_required() {
		return is_food_required;
	}

	public void setIs_food_required(boolean is_food_required) {
		this.is_food_required = is_food_required;
	}

	public String getPlaces() {
		return places;
	}

	public LocalDate getEnd_date() {
		return end_date;
	}

	public void setEnd_date(LocalDate end_date) {
		this.end_date = end_date;
	}

	public int getTraveller_id() {
		return traveller_id;
	}

	public void setTraveller_id(int traveller_id) {
		this.traveller_id = traveller_id;
	}

	public String getTraveller_name() {
		return traveller_name;
	}

	public void setTraveller_name(String traveller_name) {
		this.traveller_name = traveller_name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPlan_type() {
		return plan_type;
	}

	public void setPlan_type(String plan_type) {
		this.plan_type = plan_type;
	}

	public void setPlaces(String places) {
		this.places = places;
	}

	@Override
	public String toString() {
		return "Request [id=" + id + ", status=" + status + ", start_date=" + start_date + ", end_date=" + end_date
				+ ", no_of_persons=" + no_of_persons + ", is_room_required=" + is_room_required
				+ ", is_vehicle_required=" + is_vehicle_required + ", is_food_required=" + is_food_required
				+ ", places=" + places + ", plan_type=" + plan_type + ", traveller_id=" + traveller_id
				+ ", traveller_name=" + traveller_name + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(end_date, id, is_food_required, is_room_required, is_vehicle_required, no_of_persons,
				places, plan_type, start_date, status, traveller_id, traveller_name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Request other = (Request) obj;
		return Objects.equals(end_date, other.end_date) && id == other.id && is_food_required == other.is_food_required
				&& is_room_required == other.is_room_required && is_vehicle_required == other.is_vehicle_required
				&& no_of_persons == other.no_of_persons && Objects.equals(places, other.places)
				&& plan_type == other.plan_type && Objects.equals(start_date, other.start_date)
				&& status == other.status && traveller_id == other.traveller_id
				&& Objects.equals(traveller_name, other.traveller_name);
	}

	public Request() {
		super();
		// TODO Auto-generated constructor stub
	}
}
