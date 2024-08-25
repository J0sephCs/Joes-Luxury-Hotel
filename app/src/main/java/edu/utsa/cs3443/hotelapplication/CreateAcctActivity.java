package edu.utsa.cs3443.hotelapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;

import edu.utsa.cs3443.hotelapplication.model.Guest;
import edu.utsa.cs3443.hotelapplication.retrofit.HotelApi;
import edu.utsa.cs3443.hotelapplication.retrofit.RetrofitService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class CreateAcctActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        initComponents();
       }

        private void initComponents(){
            EditText inputFirstname= (EditText) findViewById(R.id.firstname);
            EditText inputLastname= (EditText) findViewById(R.id.lastname);
            EditText inputPhoneNumber= (EditText) findViewById(R.id.phoneNum);
            EditText inputEmail= (EditText) findViewById(R.id.email);
            EditText inputPassword= (EditText) findViewById(R.id.password1);
            EditText inputRePassword= (EditText) findViewById(R.id.repassword);
            Button createAcct= (Button) findViewById(R.id.createAccount);



            RetrofitService retrofitService= new RetrofitService();
            retrofitService.initRetrofit();

            Retrofit retrofit= retrofitService.getRetrofit();
            HotelApi hotelApi= retrofit.create(HotelApi.class);

            createAcct.setOnClickListener(view->{
                String firstname= String.valueOf(inputFirstname.getText());
                String lastname= String.valueOf(inputLastname.getText());
                String guestEmail= String.valueOf(inputEmail.getText());
                String number= String.valueOf(inputPhoneNumber.getText());
                String guestPassword= String.valueOf(inputPassword.getText());
                String guestRePassword= String.valueOf(inputRePassword.getText());

                String hashedPassword= Hashing.sha256()
                        .hashString(guestPassword, StandardCharsets.UTF_8)
                        .toString();

                if(firstname.isEmpty() || lastname.isEmpty() || number.isEmpty() || guestEmail.isEmpty() || guestPassword.isEmpty() || guestRePassword.isEmpty()){
                    Toast.makeText(CreateAcctActivity.this, "Please enter all fields", Toast.LENGTH_LONG).show();
                } else if (!guestPassword.equals(guestRePassword)) {
                    Toast.makeText(CreateAcctActivity.this, "Passwords DO NOT match", Toast.LENGTH_LONG).show();
                }

                Guest guest = new Guest();
                guest.setFirstName(firstname);
                guest.setLastName(lastname);
                guest.setPhonenumber(number);
                guest.setEmail(guestEmail);
                guest.setPassword(hashedPassword);

                hotelApi.save(guest)
                        .enqueue(new Callback<Guest>() {
                            @Override
                            public void onResponse(Call<Guest> call, Response<Guest> response) {
                                Toast.makeText(CreateAcctActivity.this, "Saved guest", Toast.LENGTH_SHORT).show();
                                Intent intent= new Intent(CreateAcctActivity.this, MainActivity.class);
                                startActivity(intent);

                            }

                            @Override
                            public void onFailure(Call<Guest> call, Throwable throwable) {
                                Toast.makeText(CreateAcctActivity.this, "Save failed", Toast.LENGTH_LONG).show();
                                Logger.getLogger(CreateAcctActivity.class.getName()).log(Level.SEVERE, "Error occurred", throwable);
                            }
                        });
            });
        }
    }
