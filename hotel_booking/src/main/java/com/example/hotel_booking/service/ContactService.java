package com.example.hotel_booking.service;

import com.example.hotel_booking.model.ContactusModel;
import com.example.hotel_booking.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    @Autowired
    private ContactRepository repository;

    public ContactusModel saveMessage(ContactusModel message) {
        return repository.save(message);
    }

    public List<ContactusModel> getAllMessages() {
        return repository.findAll();
    }
}
