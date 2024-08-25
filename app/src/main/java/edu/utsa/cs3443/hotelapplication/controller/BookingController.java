package edu.utsa.cs3443.hotelapplication.controller;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import java.util.logging.Level;
import java.util.logging.Logger;

import edu.utsa.cs3443.hotelapplication.BookingActivity;
import edu.utsa.cs3443.hotelapplication.HomeActivity;
import edu.utsa.cs3443.hotelapplication.model.Booking;
import edu.utsa.cs3443.hotelapplication.retrofit.HotelApi;
import edu.utsa.cs3443.hotelapplication.retrofit.RetrofitService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class BookingController {
    private Context context;
    private HotelApi hotelApi;

    public BookingController(Context context){
        this.context= context;
        RetrofitService retrofitService= new RetrofitService();
        retrofitService.initRetrofit();
        Retrofit retrofit= retrofitService.getRetrofit();
        hotelApi= retrofit.create(HotelApi.class);
    }


    public void bookRoom(String firstname, String lastname, String email, String roomType, String bookingTotal, String checkIn, String checkOut){
        if(firstname.isEmpty() || lastname.isEmpty() || email.isEmpty()){
            Toast.makeText(context, "Please enter all fields", Toast.LENGTH_LONG).show();
        }

        Booking booking= new Booking(firstname, lastname, email, roomType, bookingTotal, checkIn, checkOut);

        hotelApi.saveBooking(booking)
                .enqueue(new Callback<Booking>() {
                    @Override
                    public void onResponse(Call<Booking> call, Response<Booking> response) {
                        if (response.isSuccessful()) {
                            Toast.makeText(context, "Welcome booking saved! Enjoy your stay.", Toast.LENGTH_LONG).show();
                            Intent intent= new Intent(context, HomeActivity.class);
                            context.startActivity(intent);
                        } else {
                            Toast.makeText(context, "Failed to save booking: " + response.code(), Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Booking> call, Throwable throwable) {
                        Toast.makeText(context, "Booking failed", Toast.LENGTH_LONG).show();
//                        Logger.getLogger(BookingActivity.class.getName()).log(Level.SEVERE, "Error occurred", throwable);
                        Log.e("BookingController", "Error occurred", throwable);
                    }
                });

    }








}
