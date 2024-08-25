package com.hotelapi.hotelapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hotelapi.hotelapi.model.Guest;
import com.hotelapi.hotelapi.service.BookingService;
import com.hotelapi.hotelapi.service.GuestService;

@SpringBootTest
class HotelApiApplicationTests {
	@Autowired
	public GuestService guestService;

	@Autowired
	public BookingService bookingService;


	@Test
	void addGuestTest() {
		Guest guest= new Guest();
		guest.setFirstname("YPOOOOOOOOO");
		guest.setLastname("FTUKFYU");
		guest.setEmail("hk;hk@gmail.com");
		guest.setPassword("joe");
		guest.setPhonenumber("111-111-1111");
		guestService.saveGuest(guest);
	}



	// //@Test
	// void getAllGuestsAndDelete(){
	// 	List<Guest> guest = guestService.getAllGuests();
	// 	for(Guest guests : guest){
	// 		guestService.delete(guests);
	// 	}
	// }


	
	// @Test
	// void addBookingTest() {
	// 	Booking booking= new Booking();
	// 	Guest guest= new Guest("MEEEE", "MEEE", "ME@yahoo.com", "wjkhcuk", "344-455-7654");
	// 	guestService.saveGuest(guest);

	// 	booking.setFirstname("MEEEE");
	// 	booking.setLastname("MEEE");
	// 	booking.setEmail("ME@yahoo.com");
	// 	booking.setCheckIn("Mon");
	// 	booking.setCheckOut("Fri");
	// 	booking.setBookingTotal("$500");
	// 	booking.setRoomType("Executive");
	// 	booking.setGuest(guest);
	// 	bookingService.saveBooking(booking);
	// }


}
