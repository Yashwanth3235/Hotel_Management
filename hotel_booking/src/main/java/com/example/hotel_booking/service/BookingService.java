package com.example.hotel_booking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hotel_booking.model.BookingModel;
import com.example.hotel_booking.repository.BookingRepository;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public List<BookingModel> getAllBookings() {
        return bookingRepository.findAll();
    }
    
    // Method to save booking
    public BookingModel saveBooking(BookingModel booking) {
        return bookingRepository.save(booking);
    }

    public void updateBookingStatus(Long id, String status) {
        Optional<BookingModel> optionalBooking = bookingRepository.findById(id);
        if (optionalBooking.isPresent()) {
            BookingModel booking = optionalBooking.get();
            booking.setStatus(status);
            bookingRepository.save(booking); // Save the updated booking in the database
        } else {
            throw new RuntimeException("Booking not found with id: " + id);
        }
    }

//	public BookingModel createBooking(BookingModel booking) {
//        // Ensure all fields are valid and saved in the database
//        return bookingRepository.save(booking);
//    }
	  public BookingModel createBooking(BookingModel booking) {
	        // Save booking to the database
	        BookingModel savedBooking = bookingRepository.save(booking);

	        // Simulate sending notification to the manager
	        System.out.println("New booking request sent to the manager for approval: " + savedBooking);

	        return savedBooking;
	    }
}
