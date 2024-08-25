package com.hotelapi.hotelapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hotelapi.hotelapi.model.Guest;




@Repository
public interface GuestRepo extends CrudRepository <Guest, Integer> {
    Guest findByEmailAndPassword(String email, String password);

    Guest findByEmail(String email);

}
