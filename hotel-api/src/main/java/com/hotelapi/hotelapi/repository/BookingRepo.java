package com.hotelapi.hotelapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hotelapi.hotelapi.model.Booking;





@Repository
public interface BookingRepo extends CrudRepository <Booking, Integer> {

    Booking findByEmail(String email);

    Booking findGuestByEmail(String email);

    


}
