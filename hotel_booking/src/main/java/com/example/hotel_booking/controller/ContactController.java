package com.example.hotel_booking.controller;

import com.example.hotel_booking.model.ContactusModel;
import com.example.hotel_booking.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = "http://localhost:3000") // Adjust the origin as per your frontend
public class ContactController {

    @Autowired
    private ContactService service;

    @PostMapping
    public ContactusModel saveMessage(@RequestBody ContactusModel message) {
        return service.saveMessage(message);
    }

    @GetMapping
    public List<ContactusModel> getAllMessages() {
        return service.getAllMessages();
    }
    
    
}
