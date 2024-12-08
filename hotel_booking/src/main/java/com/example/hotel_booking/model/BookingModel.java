package com.example.hotel_booking.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity

public class BookingModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate checkinDate;
    private LocalDate checkoutDate;
    private int members;
    private int adults;
    private int children;

    private String status = "PENDING"; // PENDING, APPROVED, REJECTED

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getCheckinDate() {
		return checkinDate;
	}

	public void setCheckinDate(LocalDate checkinDate) {
		this.checkinDate = checkinDate;
	}

	public LocalDate getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(LocalDate checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	public int getMembers() {
		return members;
	}

	public void setMembers(int members) {
		this.members = members;
	}

	public int getAdults() {
		return adults;
	}

	public void setAdults(int adults) {
		this.adults = adults;
	}

	public int getChildren() {
		return children;
	}

	public void setChildren(int children) {
		this.children = children;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "BookingModel [id=" + id + ", checkinDate=" + checkinDate + ", checkoutDate=" + checkoutDate
				+ ", members=" + members + ", adults=" + adults + ", children=" + children + ", status=" + status + "]";
	}

    // Getters and Setters
}
