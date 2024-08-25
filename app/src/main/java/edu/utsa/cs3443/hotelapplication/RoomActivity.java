package edu.utsa.cs3443.hotelapplication;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
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

import edu.utsa.cs3443.hotelapplication.R.id;
import edu.utsa.cs3443.hotelapplication.controller.RoomController;
import edu.utsa.cs3443.hotelapplication.model.Room;


import edu.utsa.cs3443.hotelapplication.rooms.RoomListAdapter;



public class RoomActivity extends AppCompatActivity {

    public RecyclerView recyclerView;
    public RoomController roomController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_list);
        recyclerView= findViewById(id.room_list);
        roomController= new RoomController(this, recyclerView);
    }
}
