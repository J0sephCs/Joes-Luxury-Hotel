package edu.utsa.cs3443.hotelapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.List;

import edu.utsa.cs3443.hotelapplication.amenitites.AmenitiesListAdapter;
import edu.utsa.cs3443.hotelapplication.controller.RoomController;
import edu.utsa.cs3443.hotelapplication.model.Booking;
import edu.utsa.cs3443.hotelapplication.retrofit.HotelApi;
import edu.utsa.cs3443.hotelapplication.retrofit.RetrofitService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class BookingInfoActivity extends AppCompatActivity {

    public TextView bookingInfo;

    public Button deleteBtn;
    HotelApi hotelApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookinginfo);
        bookingInfo= findViewById(R.id.booking_info);
        deleteBtn= findViewById(R.id.deleteBtn);

        RetrofitService retrofitService= new RetrofitService();
        retrofitService.initRetrofit();
        Retrofit retrofit= retrofitService.getRetrofit();
        hotelApi= retrofit.create(HotelApi.class);


        String guestEmail= DataStore.getInstance().getEmail();
        Log.d("BookingInfoActivity", "Email"+ guestEmail);

        if(guestEmail != null){
            fetchBookingInfo(guestEmail);
        }else {
            bookingInfo.setText("Invalid email");
        }

        deleteBtn.setOnClickListener(view -> {
            if(guestEmail != null){
                deleteBooking(guestEmail);
            }else{
                bookingInfo.setText("No email to delete");
            }
        });



    }


    public void fetchBookingInfo(String email){
        hotelApi.fetchBookingInfo(email).enqueue(new Callback<Booking>() {
            @Override
            public void onResponse(Call<Booking> call, Response<Booking> response) {
                if(response.isSuccessful()){
                    Booking booking= response.body();

                    if(booking != null){
                        StringBuilder info= new StringBuilder();
                        info.append(booking.toString()).append("\n");
                        bookingInfo.setText(info.toString());
                    }else {
                        bookingInfo.setText("No booking info");
                    }
                }else{
                    bookingInfo.setText("Error"  + response.message());
                }
            }

            @Override
            public void onFailure(Call<Booking> call, Throwable throwable) {
                bookingInfo.setText("Error" + throwable.getMessage());
                Log.d("Error", throwable.getMessage());
            }
        });
    }

    public void deleteBooking(String email){
        hotelApi.deleteBooking(email).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(response.isSuccessful()){
                    bookingInfo.setText("Check-out successful. Safe travels home!");

                    new Handler().postDelayed(()->{
                       Intent intent= new Intent(BookingInfoActivity.this, HomeActivity.class);
                       startActivity(intent);
                       finish();
                    }, 1500);
                }else{
                    bookingInfo.setText("Error: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable throwable) {
                bookingInfo.setText("Error" + throwable.getMessage());
                Log.e("BookingInfoActivity", "Delete error", throwable);
            }
        });
    }









}
