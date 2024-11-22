package com.example.hotel_booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.hotel_booking.model.RegisterModel;
import com.example.hotel_booking.repository.RegisterRepository;

import org.springframework.ui.Model;

@Controller
public class UserController {
	
	 @Autowired
	    private RegisterRepository registerRepository; 
	 
	@GetMapping("/")
	public String ShowLogin() {
		
		return "Login";
	}
	
    @PostMapping("/register")
    public String handleRegister(@ModelAttribute RegisterModel register) {

    	System.out.println(register.toString());
    	
    	registerRepository.save(register);
    	
    	return "Login"; // Redirect to a success page or another view
    }
    
    @GetMapping("/register")
    public String showRegisterForm() {
        return "Register"; // Render the register page (make sure it's in src/main/resources/templates)
    }
    
    @GetMapping("/dashboard")
    public String showDashboar() {
    	return "Dashboard";
    }



    @PostMapping("/login")
    public String handleLogin(@ModelAttribute RegisterModel loginData, Model model) {
        // Fetch the user by email
        RegisterModel user = registerRepository.findByEmail(loginData.getEmail());

        if (user != null && user.getPassword() != null && user.getPassword().equals(loginData.getPassword())) {
        	
        	String role = user.getRole();

            if (role != null) {
                // Add user data to the model
                model.addAttribute("user", user);

                // Redirect based on role
                switch (role.toLowerCase()) {
                    case "admin":
                        return "AdminDashboard"; // Admin dashboard
                    case "user":
                        return "UserDashboard"; // User dashboard
                    case "manager":
                        return "ManagerDashboard"; // Manager dashboard
                    default:
                        model.addAttribute("error", "Invalid role. Access denied.");
                        return "Login";
                        
                }
            }
        }           
        model.addAttribute("alertMessage", "Login successfully");



        // Invalid credentials or role
        model.addAttribute("alertMessage", "Invalid email or password.");
        return "Login";
    }
}

