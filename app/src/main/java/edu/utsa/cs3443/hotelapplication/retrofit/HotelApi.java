package edu.utsa.cs3443.hotelapplication.retrofit;

import java.util.List;

import edu.utsa.cs3443.hotelapplication.model.Booking;
import edu.utsa.cs3443.hotelapplication.model.Guest;
import edu.utsa.cs3443.hotelapplication.model.Room;
import edu.utsa.cs3443.hotelapplication.rooms.RoomListApiResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface HotelApi {

    @GET("/guest/getGuests")
    Call<List<Guest>> getAllGuests();

    @POST("/guest/saveGuest")
    Call<Guest> save(@Body Guest guest);

    @POST("/booking/saveBooking")
    Call<Booking> saveBooking(@Body Booking booking);

    @GET("/booking/getBooking")
    Call<Booking> fetchBookingInfo(@Query("email") String email);

    @POST("/guest/login")
    Call<String> loginGuest(@Query("email") String email, @Query("password") String password);

    @DELETE("/booking/deleteBooking")
    Call<Void> deleteBooking(@Query("email") String email);

    @GET("/getRooms")
    Call<RoomListApiResponse> getRoomList();
}

