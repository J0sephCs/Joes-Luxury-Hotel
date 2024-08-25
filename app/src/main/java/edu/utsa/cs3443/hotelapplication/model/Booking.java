package edu.utsa.cs3443.hotelapplication.model;

public class Booking{

    public String roomType, bookingTotal, firstname, lastname, email;
    public String checkIn, checkOut;

    public Guest guest;

    public Booking(){

    }
    public Booking(String firstname, String lastname, String email, String roomType, String bookingTotal, String checkIn, String checkOut) {
        this.firstname= firstname;
        this.lastname= lastname;
        this.email= email;
        this.roomType = roomType;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.bookingTotal= bookingTotal;
    }


    public String toString() {
        return "Your Booking:\n\n" +
                "Full name- " + " " + firstname + " " + lastname + "\n\n" +
                "Room type- "+ " " + roomType + "\n\n" +
                "Booking rate- "+ " " + bookingTotal + "\n\n" +
                "Email- "+ " " + email + "\n\n" +
                "Check-in- "+ " " + checkIn + "\n\n" +
                "Check-out- "+ " " + checkOut;
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
