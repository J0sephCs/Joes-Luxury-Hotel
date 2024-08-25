package edu.utsa.cs3443.hotelapplication;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import edu.utsa.cs3443.hotelapplication.amenitites.AmenitiesHolder;
import edu.utsa.cs3443.hotelapplication.amenitites.AmenitiesListAdapter;
import edu.utsa.cs3443.hotelapplication.model.Amenities;
import edu.utsa.cs3443.hotelapplication.rooms.RoomListAdapter;

public class AmenitiesActivity extends AppCompatActivity {

    public RecyclerView recyclerView;
    public AmenitiesListAdapter amenitiesListAdapter;
    public ArrayList<Amenities> amenitiesList= new ArrayList<Amenities>();
    private String JSON_URL= "https://run.mocky.io/v3/834f76de-caf1-4797-8268-ed3dd60a4525";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amenities_list);

        recyclerView= findViewById(R.id.amenities_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        amenitiesListAdapter= new AmenitiesListAdapter(AmenitiesActivity.this, amenitiesList);
        recyclerView.setAdapter(amenitiesListAdapter);


        GetData getData= new GetData();
        getData.execute();
    }


    public class GetData extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... strings) {
            String curr= "";

            try{
                URL url= new URL(JSON_URL);
                HttpURLConnection urlConnection= (HttpURLConnection) url.openConnection();

                InputStream inputStream= urlConnection.getInputStream();
                InputStreamReader inputStreamReader= new InputStreamReader(inputStream);

                int data= inputStreamReader.read();
                while(data != -1){
                    curr+= (char) data;
                    data= inputStreamReader.read();
                }
                return curr;

            }catch (Exception e){
                e.printStackTrace();
            }

            return curr;
        }

        @Override
        protected void onPostExecute(String s){

            try{
                JSONObject jsonObject= new JSONObject(s);
                JSONArray jsonArray= jsonObject.getJSONArray("amenities");

                for(int i=0; i<jsonArray.length(); i++){
                    JSONObject jsonObject1= jsonArray.getJSONObject(i);

                    Amenities amenities= new Amenities();
                    amenities.setImg(jsonObject1.getString("image"));
                    amenities.setName(jsonObject1.getString("name"));
                    amenities.setHours(jsonObject1.getString("hours"));
                    amenities.setDesc(jsonObject1.getString("desc"));
                    amenitiesList.add(amenities);
                }

            }catch(JSONException e){
                e.printStackTrace();
            }
            PutDataInRecyclerView(amenitiesList);
        }
    }

    private void PutDataInRecyclerView(ArrayList<Amenities> amenitiesList){
        AmenitiesListAdapter amenitiesListAdapter= new AmenitiesListAdapter(this, amenitiesList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(amenitiesListAdapter);
    }





}
