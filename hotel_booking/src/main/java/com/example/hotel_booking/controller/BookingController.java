package com.example.hotel_booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.hotel_booking.model.BookingModel;
import com.example.hotel_booking.repository.BookingRepository;
//import com.example.hotel_booking.service.BookingService;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins = "http://localhost:3000") // Allow frontend to communicate
public class BookingController {
    
    @Autowired
    private BookingRepository bookingRepository;

    // Save a booking
    @PostMapping
    public ResponseEntity<BookingModel> saveBooking(@RequestBody BookingModel booking) {
        try {
            // Validate that a hotel ID is provided
            if (booking.getHotelId() == null) {
                return ResponseEntity.badRequest().body(null);
            }

            // Default the status to "PENDING"
            booking.setStatus("PENDING");

            // Save booking to the database
            BookingModel savedBooking = bookingRepository.save(booking);

            // Simulate sending the request to the manager
            System.out.println("Booking request sent to manager for approval:");
            System.out.println(savedBooking);

            // Return the saved booking
            return ResponseEntity.status(HttpStatus.CREATED).body(savedBooking);
        } catch (Exception e) {
            System.err.println("Error saving booking: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Get all bookings
    @GetMapping
    public List<BookingModel> getAllBookings() {
        return bookingRepository.findAll();
    }

    // Approve or reject booking
    @PutMapping("/{id}/status")
    public BookingModel updateBookingStatus(@PathVariable Long id, @RequestParam String status) {
        BookingModel booking = bookingRepository.findById(id).orElseThrow();
        booking.setStatus(status);
        return bookingRepository.save(booking);
    }
    
    
}
