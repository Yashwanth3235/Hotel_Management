package com.example.hotel_booking.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.hotel_booking.model.HotelModel;
import com.example.hotel_booking.repository.HotelRepository;
import com.example.hotel_booking.service.HotelService;

@RestController
@RequestMapping("/api/hotels")
@CrossOrigin(origins = "http://localhost:3000")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @Autowired
    private HotelRepository hotelRepository;

    // Add a new hotel with image uploads
    @PostMapping
    public ResponseEntity<HotelModel> addHotel(
        @RequestParam("hotelName") String hotelName,
        @RequestParam("location") String location,
        @RequestParam("email") String email,
        @RequestParam("price") double price,
        @RequestParam("totalRooms") int totalRooms,
        @RequestParam("description") String description,
        @RequestParam("street") String street,
        @RequestParam("pinCode") String pinCode,
        @RequestParam(value = "image1", required = false) MultipartFile image1,
        @RequestParam(value = "image2", required = false) MultipartFile image2
    ) {
        try {
            // Log received data for debugging
//            System.out.println("Received Hotel Name: " + hotelName);
//            System.out.println("Received Location: " + location);
//            System.out.println("Received Email: " + email);
//            System.out.println("Received Price: " + price);
//            System.out.println("Received Total Rooms: " + totalRooms);
//            System.out.println("Received Description: " + description);
//            System.out.println("Received Street: " + street);
//            System.out.println("Received PinCode: " + pinCode);

            // Save images if they are present
            String imageUrl1 = null;
            String imageUrl2 = null;

            if (image1 != null && !image1.isEmpty()) {
                imageUrl1 = saveImage(image1);
                System.out.println("Received ImageUrl1: " + imageUrl1);
            }

            if (image2 != null && !image2.isEmpty()) {
                imageUrl2 = saveImage(image2);
                System.out.println("Received ImageUrl2: " + imageUrl2);
            }

            // Create the HotelModel object and set its fields
            HotelModel hotel = new HotelModel();
            hotel.setHotelName(hotelName);
            hotel.setLocation(location);
            hotel.setEmail(email);
            hotel.setPrice(price);
            hotel.setTotalRooms(totalRooms);
            hotel.setDescription(description);
            hotel.setStreet(street);
            hotel.setPinCode(pinCode);
            hotel.setImageUrl1(imageUrl1);
            hotel.setImageUrl2(imageUrl2);

            // Save the hotel and return the response
            HotelModel savedHotel = hotelService.saveHotel(hotel);
            return ResponseEntity.ok(savedHotel);
        } catch (Exception e) {
            // Handle error if image saving fails
            System.err.println("Error: " + e.getMessage());
            return ResponseEntity.status(500).body(null);
        }
    }

    // Helper method to save images to the server
    private String saveImage(MultipartFile image) throws IOException {
        String imageName = UUID.randomUUID().toString() + "-" + image.getOriginalFilename();
        Path path = Paths.get("src/main/resources/static/images/" + imageName);
        Files.copy(image.getInputStream(), path);
        return "/images/" + imageName; // return path that can be accessed in the browser
    }

    // Get all hotels
    @GetMapping
    public ResponseEntity<List<HotelModel>> getAllHotels() {
        try {
            List<HotelModel> hotels = hotelService.getAllHotels();
            return ResponseEntity.ok(hotels);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    // Get hotel by ID
    @GetMapping("/{id}")
    public ResponseEntity<HotelModel> getHotelById(@PathVariable Long id) {
        Optional<HotelModel> hotel = hotelService.getHotelById(id);
        return hotel.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Update a hotel
    @PutMapping("/{id}")
    public ResponseEntity<HotelModel> updateHotel(@PathVariable Long id, @RequestBody HotelModel updatedHotel) {
        Optional<HotelModel> existingHotel = hotelRepository.findById(id);
        if (existingHotel.isPresent()) {
            HotelModel hotel = existingHotel.get();
            hotel.setHotelName(updatedHotel.getHotelName());
            hotel.setLocation(updatedHotel.getLocation());
            hotel.setEmail(updatedHotel.getEmail());
            hotel.setPrice(updatedHotel.getPrice());
            hotel.setTotalRooms(updatedHotel.getTotalRooms());
            hotel.setDescription(updatedHotel.getDescription());
            hotel.setStreet(updatedHotel.getStreet());
            hotel.setPinCode(updatedHotel.getPinCode());
            hotel.setImageUrl1(updatedHotel.getImageUrl1()); // Update image URLs
            hotel.setImageUrl2(updatedHotel.getImageUrl2()); // Update image URLs

            // Debug logs to verify updates
            System.out.println("Updated ImageUrl1: " + updatedHotel.getImageUrl1());
            System.out.println("Updated ImageUrl2: " + updatedHotel.getImageUrl2());

            hotelRepository.save(hotel);
            return ResponseEntity.ok(hotel);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a hotel
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteHotel(@PathVariable Long id) {
        boolean isDeleted = hotelService.deleteHotelById(id);
        if (isDeleted) {
            return ResponseEntity.ok("Hotel deleted successfully");
        } else {
            return ResponseEntity.status(404).body("Hotel not found");
        }
    }

    // Get hotels by location
    @GetMapping("/by-location")
    public ResponseEntity<List<HotelModel>> getHotelsByLocation(@RequestParam String location) {
        return ResponseEntity.ok(hotelService.getHotelsByLocation(location));
    }

    // Get distinct locations
    @GetMapping("/locations")
    public ResponseEntity<List<String>> getDistinctLocations() {
        return ResponseEntity.ok(hotelService.getDistinctLocations());
    }
    
    
}
