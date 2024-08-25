package com.hotelapi.hotelapi.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;



@NoArgsConstructor
@Entity
@Table(name= "booking")
public class Booking{

    @Id
    @Column(name="bookingid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer bookingid;
    @Column(name= "bookingtotal")
    public String bookingTotal;
    @Column(name= "roomtype")
    public String roomType;
    @Column(name="checkin")
    public String checkIn;
    @Column(name="checkout")
    public String checkOut;

    @Column(name= "firstname")
    public String firstname;
    @Column(name="lastname")
    public String lastname;
    @Column(name="email")
    public String email;

    @OneToOne
    @JoinColumn(name= "guestid")
    private Guest guest;

    

    public Booking(String firstname, String lastname, String email, String roomType, String bookingTotal, String checkIn, String checkOut) {
        this.firstname= firstname;
        this.lastname= lastname;
        this.email= email;
        this.roomType = roomType;
        this.bookingTotal= bookingTotal;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }


   


    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public String getBookingTotal(){
        return bookingTotal;
    }
    public void setBookingTotal(String bookingTotal){
        this.bookingTotal= bookingTotal;
    }


    
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    
    public void setEmail(String email) {
        this.email = email;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }
    
}
