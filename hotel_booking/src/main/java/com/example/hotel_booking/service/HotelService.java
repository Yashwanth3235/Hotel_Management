package com.example.hotel_booking.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hotel_booking.model.HotelModel;
import com.example.hotel_booking.repository.HotelRepository;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    public HotelModel saveHotel(HotelModel hotel) {
        return hotelRepository.save(hotel);
    }

    public List<HotelModel> getAllHotels() {
        return hotelRepository.findAll();
    }

    public Optional<HotelModel> getHotelById(Long id) {
        return hotelRepository.findById(id);
    }
    
    public List<String> getDistinctLocations() {
        return hotelRepository.findDistinctLocations();
    }
    
    public List<HotelModel> getHotelsByLocation(String location) {
        return hotelRepository.findByLocationContainingIgnoreCase(location);
    }

    public boolean deleteHotelById(Long id) {
        if (hotelRepository.existsById(id)) {
            hotelRepository.deleteById(id);
            return true;
        }
        return false;
    }

   
}
