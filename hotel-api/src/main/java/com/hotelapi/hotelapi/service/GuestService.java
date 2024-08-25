package com.hotelapi.hotelapi.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import com.hotelapi.hotelapi.model.Guest;
import com.hotelapi.hotelapi.repository.BookingRepo;
import com.hotelapi.hotelapi.repository.GuestRepo;

@Service
public class GuestService {

    @Autowired
    public GuestRepo guestRepo;

    @Autowired
    public BookingRepo bookingRepo;

    public Guest saveGuest(Guest guest){
        return guestRepo.save(guest);
    }

    

    public void delete(Guest guest){
        guestRepo.delete(guest);
    }

    public List<Guest> getAllGuests(){
        List<Guest> guests= new ArrayList<>();
        Streamable.of(guestRepo.findAll())
            .forEach(guests::add);
        return guests;
    }

 

}
