package edu.utsa.cs3443.hotelapplication;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Pair;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import edu.utsa.cs3443.hotelapplication.controller.BookingController;
import edu.utsa.cs3443.hotelapplication.model.Booking;
import edu.utsa.cs3443.hotelapplication.model.Guest;
import edu.utsa.cs3443.hotelapplication.retrofit.HotelApi;
import edu.utsa.cs3443.hotelapplication.retrofit.RetrofitService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class BookingActivity extends AppCompatActivity {

    TextView textDate, roomSelection, roomPrice;
    Button buttonDate, bookbtn;
    String checkIn, checkOut;
    EditText inputFirstname, inputLastname, inputEmail;

    BookingController bookingController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        textDate = findViewById(R.id.bookingDate);
        buttonDate = findViewById(R.id.btnSelectDates);
        roomSelection = findViewById(R.id.roomSelection);
        bookbtn = findViewById(R.id.checkoutBtn);
        roomPrice = findViewById(R.id.total);
        inputFirstname = findViewById(R.id.firstname);
        inputLastname = findViewById(R.id.lastname);
        inputEmail = findViewById(R.id.email);

        bookingController = new BookingController(this);

        String roomType = getIntent().getStringExtra("ROOM_TYPE");
        String roomTotal = getIntent().getStringExtra("ROOM_PRICE");

        roomPrice.setText(roomTotal);
        roomSelection.setText(roomType);

        datePicker();
        setupBookBtn();


    }


    public void datePicker() {
        MaterialDatePicker.Builder<Pair<Long, Long>> materialDateBuilder = MaterialDatePicker.Builder.dateRangePicker();
        materialDateBuilder.setTitleText("Select booking dates");
        materialDateBuilder.setTheme(R.style.ThemeMaterialCalendar);

        final MaterialDatePicker materialDatePicker = materialDateBuilder.build();

        buttonDate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        try {

                            materialDatePicker.show(getSupportFragmentManager(), "MATERIAL_DATE_PICKER");
                        } catch (Exception e) {
                            Log.e("BookingActivity", "Error", e);
                        }
                    }
                });


        materialDatePicker.addOnPositiveButtonClickListener(
                new MaterialPickerOnPositiveButtonClickListener<Pair<Long, Long>>() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onPositiveButtonClick(Pair<Long, Long> selection) {

                        if (selection != null) {
                            try {
                                SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy", Locale.getDefault());

                                checkIn = sdf.format(new Date(selection.first));
                                checkOut = sdf.format(new Date(selection.second));
                                textDate.setText("Check-in: " + checkIn + " Check-out: " + checkOut);
                            } catch (Exception e) {
                                Log.e("BookingActivity", "error formatting", e);
                            }

                        }
                    }
                });
    }


    public void setupBookBtn() {
        bookbtn.setOnClickListener(view -> {
            String firstname = String.valueOf(inputFirstname.getText());
            String lastname = String.valueOf(inputLastname.getText());
            String email = String.valueOf(inputEmail.getText());

            DataStore.getInstance().setEmail(email);

            bookingController.bookRoom(firstname, lastname, email, roomSelection.getText().toString(), roomPrice.getText().toString(), checkIn, checkOut);
        });
    }
}



