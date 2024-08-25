package com.hotelapi.hotelapi.contoller;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotelapi.hotelapi.model.Booking;
import com.hotelapi.hotelapi.service.BookingService;




@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    public BookingService bookingService;

    private static final Logger LOGGER = Logger.getLogger(BookingController.class.getName());


    @GetMapping
    public String getPage(){
        return "BOOKINGS";
    }

    @PostMapping("/saveBooking")
    public ResponseEntity<Booking> saveBooking(@RequestBody Booking booking){

        try{
            Booking savedBooking= bookingService.saveBooking(booking);
            return ResponseEntity.ok(savedBooking);

        }catch(Exception e){
            Logger.getLogger(BookingController.class.getName()).log(Level.SEVERE, "Error creating booking",e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }
    }

    @GetMapping("/getBooking")
    public ResponseEntity<Booking> fetchBookingInfo(@RequestParam String email){

        try {
            Booking booking= bookingService.fetchBookingInfo(email);
            return ResponseEntity.ok(booking);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }



    @DeleteMapping("/deleteBooking")
    public ResponseEntity<Void> deleteBooking(@RequestParam String email){
        try{
            Booking booking= bookingService.fetchBookingInfo(email);

            if(booking != null){
                bookingService.deleteBooking(booking);
                return ResponseEntity.noContent().build();
            }else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        }catch(Exception e){
            LOGGER.log(Level.SEVERE, "Error deleting booking", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    




 }

   

    

