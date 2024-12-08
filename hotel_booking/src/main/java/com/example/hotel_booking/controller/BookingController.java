package com.example.hotel_booking.controller;


import org.springframework.beans.factory.annotation.Autowired;
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
    
    @Autowired
//    private BookingService bookingService;

    // Save a booking
    @PostMapping
    public BookingModel saveBooking(@RequestBody BookingModel booking) {
        return bookingRepository.save(booking);
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
