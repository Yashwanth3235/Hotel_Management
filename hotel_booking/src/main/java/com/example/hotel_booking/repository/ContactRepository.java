package com.example.hotel_booking.repository;

import com.example.hotel_booking.model.ContactusModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<ContactusModel, Long> {
}
