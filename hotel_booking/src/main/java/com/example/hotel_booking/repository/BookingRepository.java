package com.example.hotel_booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hotel_booking.model.BookingModel;

public interface BookingRepository extends JpaRepository<BookingModel, Long> {
}
