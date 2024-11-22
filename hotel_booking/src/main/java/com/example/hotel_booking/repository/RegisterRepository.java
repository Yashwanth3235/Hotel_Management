package com.example.hotel_booking.repository;

//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.hotel_booking.model.RegisterModel; // Make sure to import the Register class

public interface RegisterRepository extends JpaRepository<RegisterModel, Long> {
    // Additional query methods can be defined here
	RegisterModel findByEmail(String email);
}
