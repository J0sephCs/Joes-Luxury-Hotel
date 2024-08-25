package com.hotelapi.hotelapi.contoller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotelapi.hotelapi.model.Guest;
import com.hotelapi.hotelapi.repository.GuestRepo;
import com.hotelapi.hotelapi.service.GuestService;

@RestController
@RequestMapping("/guest")
public class GuestController {

    @Autowired
    public GuestService guestService;

    @Autowired
    public GuestRepo guestRepo;

    @GetMapping
    public String getPage(){
        return "Yoooo";
    }

    @GetMapping("/getGuests")
    public List<Guest> getAllGuests(){
        return guestService.getAllGuests();
    }

    /* 
    @PostMapping("/addGuest")
    public Guest postGuestDetails(@RequestBody Guest guest){
        return guestService.saveGuest(guest);
    }
    */

    @PostMapping("/saveGuest")
    public Guest saveGuest(@RequestBody Guest guest){
        return guestService.saveGuest(guest);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginGuest(@RequestParam String email, @RequestParam String password){
        Guest guest= guestRepo.findByEmailAndPassword(email,password);

        if(guest != null){
            return ResponseEntity.ok("Login success");
        }
        else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }



    

    





}
