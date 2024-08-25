package edu.utsa.cs3443.hotelapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.logging.Level;
import java.util.logging.Logger;

import edu.utsa.cs3443.hotelapplication.retrofit.HotelApi;
import edu.utsa.cs3443.hotelapplication.retrofit.RetrofitService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {


    TextView createAcct;
    EditText email, password;
    Button loginBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        createAcct= (TextView) findViewById(R.id.createAccountBtn);
        email= (EditText) findViewById(R.id.emailText);
        password= (EditText) findViewById(R.id.passwordText);
        loginBtn= (Button) findViewById(R.id.loginButton);

        RetrofitService retrofitService= new RetrofitService();
        retrofitService.initRetrofit();

        Retrofit retrofit= retrofitService.getRetrofit();
        HotelApi hotelApi= retrofit.create(HotelApi.class);


        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String guestEmail= email.getText().toString();
                String guestPass= password.getText().toString();

                 if(guestEmail.isEmpty() || guestPass.isEmpty()){
                     Toast.makeText(MainActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                 }
                 else{
                     hotelApi.loginGuest(guestEmail, guestPass).enqueue(new Callback<String>() {
                         @Override
                         public void onResponse(Call<String> call, Response<String> response) {
                             Toast.makeText(MainActivity.this, "Logged in guest", Toast.LENGTH_SHORT).show();
                             Intent intent= new Intent(MainActivity.this, HomeActivity.class);
                             startActivity(intent);
                         }

                         @Override
                         public void onFailure(Call<String> call, Throwable throwable) {
                             Toast.makeText(MainActivity.this, "Login failed", Toast.LENGTH_LONG).show();
                             Logger.getLogger(MainActivity.class.getName()).log(Level.SEVERE, "Error occurred", throwable);

                         }
                     });
                 }
            }
        });


        createAcct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent intent= new Intent(MainActivity.this, CreateAcctActivity.class);
                    startActivity(intent);
            }
        });
    }



}