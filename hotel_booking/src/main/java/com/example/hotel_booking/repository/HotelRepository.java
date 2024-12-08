package com.example.hotel_booking.repository;

import com.example.hotel_booking.model.HotelModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<HotelModel, Long> {
	@Query("SELECT DISTINCT h.location FROM HotelModel h")
    List<String> findDistinctLocations();

    // Custom query method to find hotels by location
    List<HotelModel> findByLocation(String location);
    List<HotelModel> findByLocationContainingIgnoreCase(String location);

}
