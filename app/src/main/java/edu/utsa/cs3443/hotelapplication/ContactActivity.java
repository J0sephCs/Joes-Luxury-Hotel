package edu.utsa.cs3443.hotelapplication;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ContactActivity extends AppCompatActivity {
    EditText phoneNum, email;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        phoneNum= findViewById(R.id.editTextPhone);
        email= findViewById(R.id.editTextTextEmailAddress);

        toolbar= findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


       // actionBar.getSupportActionBar().setHomeButtonEnabled(true);
    }

//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item){
//        if(item.getItemId() == R.id.toolbar2){
//            Intent intent= new Intent(getApplicationContext(), HomeActivity.class);
//            startActivity(intent);
//            this.finish();
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }

    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }

}
