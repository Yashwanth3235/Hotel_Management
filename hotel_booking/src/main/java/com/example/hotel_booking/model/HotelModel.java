package com.example.hotel_booking.model;

//import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "hotels")
public class HotelModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "hotel_name", nullable = false)
	private String hotelName;

	@Column(nullable = false)
	private String location;

	@Column(length = 1000)
	private String description;

	@Column(nullable = false)
	private String email;

	@Column(nullable = false)
	private double price;

	@Column(name = "total_rooms", nullable = false)
	private int totalRooms;

	@Column(nullable = false)
	private String street;

	@Column(name = "pin_code", nullable = false)
	private String pinCode;

	@Column(name = "image_url_1", length = 1000)
	private String ImageUrl1;

	@Column(name = "image_url_2", length = 1000)
	private String ImageUrl2;
	
	

	// Constructors
//    public HotelModel() {
//    }
//
//    public HotelModel(String hotelName, String location, String description, String email, double price, int totalRooms, String street, String pinCode, String imageUrl1, String imageUrl2) {
//        this.hotelName = hotelName;
//        this.location = location;
//        this.description = description;
//        this.email = email;
//        this.price = price;
//        this.totalRooms = totalRooms;
//        this.street = street;
//        this.pinCode = pinCode;
//        this.imageUrl1 = imageUrl1;
//        this.imageUrl2 = imageUrl2;
//    }

	


	// Getters and Setters
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getTotalRooms() {
		return totalRooms;
	}

	public void setTotalRooms(int totalRooms) {
		this.totalRooms = totalRooms;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getImageUrl1() {
		return ImageUrl1;
	}

	public void setImageUrl1(String imageUrl1) {
		this.ImageUrl1 = imageUrl1;
	}

	public String getImageUrl2() {
		return ImageUrl2;
	}

	public void setImageUrl2(String imageUrl2) {
		this.ImageUrl2 = imageUrl2;
	}

//	public static List<HotelModel> findByLocationContainingIgnoreCase(String location2) {
//		// TODO Auto-generated method stub
//		return null;
//	}


	@Override
	public String toString() {
		return "HotelModel [id=" + id + ", hotelName=" + hotelName + ", location=" + location + ", description="
				+ description + ", email=" + email + ", price=" + price + ", totalRooms=" + totalRooms + ", street="
				+ street + ", pinCode=" + pinCode + ", imageUrl1=" + ImageUrl1 + ", imageUrl2=" + ImageUrl2 + " ]";
	}
	

}
