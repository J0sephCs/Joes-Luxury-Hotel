package com.hotelapi.hotelapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelapi.hotelapi.model.Booking;
import com.hotelapi.hotelapi.model.Guest;
import com.hotelapi.hotelapi.repository.BookingRepo;
import com.hotelapi.hotelapi.repository.GuestRepo;

@Service
public class BookingService {

    @Autowired
    public BookingRepo bookingRepo;

    @Autowired
    public GuestRepo guestRepo;

    
    public Booking saveBooking(Booking booking){
        Guest guest= guestRepo.findByEmail(booking.getEmail());

        if(guest == null){
            guest= new Guest();

            guest.setFirstname(booking.getFirstname());
            guest.setLastname(booking.getLastname());
            guest.setEmail(booking.getEmail());
            guestRepo.save(guest);
        }

        booking.setGuest(guest);
        return bookingRepo.save(booking);
    }



    public void deleteBooking(Booking booking){
        bookingRepo.delete(booking);
    }


    public Booking fetchBookingInfo(String email){
        return bookingRepo.findGuestByEmail(email);

    }

    
}
