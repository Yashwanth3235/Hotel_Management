package com.example.hotel_booking.controller;

//import org.springframework.beans.factory.annotation.Autowired;

//import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.RequestMapping;

//import com.example.hotel_booking.service.HotelService;

//import com.example.hotel_booking.model.HotelModel;
//import com.example.hotel_booking.service.HotelService;

@Controller
//@RequestMapping("/hotel") // Add a mapping prefix for your view routes
public class HotelViewController {

	@GetMapping("/addHotel")
	public String showAddHotelForm() {
		return "AddHotel"; // Ensure you have an `addHotel.html` file in your templates directory
	}

	@GetMapping("/hotelslist")
	public String showAllHotels() {
		return "HotelsList";
	}
//
	@GetMapping("/aboutus")
	public String showAboutus() {
		return "Aboutus";
	}
	@GetMapping("/contactus")
	public String showContactus() {
		return "Contactus";
	}
	
    @GetMapping("/bookingslist")
	public String showAllBookingsList() {
		return "BookingsList";
	}
    
   
  
	
//	@GetMapping("/bookingform")
//	public String showbookingform() {
//		return "Bookingform";
//	}
//        @Autowired
//        private HotelService hotelService;
//
//        @GetMapping
//        public List<HotelModel> getAllHotels() {
//            return hotelService.getAllHotels();
//        }
	}

