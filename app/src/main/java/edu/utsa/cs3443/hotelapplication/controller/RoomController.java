package edu.utsa.cs3443.hotelapplication.controller;

import android.content.Context;
import android.os.AsyncTask;

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

import edu.utsa.cs3443.hotelapplication.RoomActivity;
import edu.utsa.cs3443.hotelapplication.model.Room;
import edu.utsa.cs3443.hotelapplication.rooms.RoomListAdapter;

public class RoomController {

    public static Context context;
    public static RecyclerView recyclerView;
    public RoomListAdapter roomListAdapter;

    public static ArrayList<Room> roomList= new ArrayList<>();
    public static String JSON_URL= "https://run.mocky.io/v3/882eb57b-2ccf-46f5-a90d-137900af8acd";

    public RoomController(Context context, RecyclerView recyclerView){
        this.context= context;
        this.recyclerView= recyclerView;
        roomListAdapter= new RoomListAdapter(context, roomList);
        this.recyclerView.setAdapter(roomListAdapter);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(context));

        GetData getData= new GetData();
        getData.execute();
    }



    public static class GetData extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... strings) {

            String current= "";

            try{
                URL url;
                HttpURLConnection urlConnection= null;

                try {
                    url= new URL(JSON_URL);
                    urlConnection= (HttpURLConnection) url.openConnection();

                    InputStream inputStream= urlConnection.getInputStream();
                    InputStreamReader inputStreamReader= new InputStreamReader(inputStream);

                    int data= inputStreamReader.read();
                    while(data != -1){
                        current+= (char) data;
                        data= inputStreamReader.read();
                    }
                    return current;

                }catch(MalformedURLException e){
                    e.printStackTrace();
                }catch(IOException e){
                    e.printStackTrace();
                }finally {
                    if(urlConnection != null){
                        urlConnection.disconnect();
                    }
                }

            }catch (Exception e){
                e.printStackTrace();
            }
            return current;
        }

        @Override
        protected void onPostExecute(String s){

            try{
                JSONObject jsonObject= new JSONObject(s);
                JSONArray jsonArray= jsonObject.getJSONArray("rooms");

                for(int i=0; i<jsonArray.length(); i++){
                    JSONObject jsonObject1= jsonArray.getJSONObject(i);

                    Room room= new Room();
                    room.setRoomId(Integer.parseInt(jsonObject1.getString("id")));
                    room.setRoomImg(jsonObject1.getString("image"));
                    room.setRoomPrice(jsonObject1.getString("roomPrice"));
                    room.setRoomType(jsonObject1.getString("roomType"));
                    room.setRoomDesc(jsonObject1.getString("roomDesc"));
                    roomList.add(room);
                }
            }catch(JSONException e){
                e.printStackTrace();
            }
            PutDataIntoRecyclerView(roomList);

        }
    }
    private static void PutDataIntoRecyclerView(ArrayList<Room> roomList){
        RoomListAdapter roomListAdapter= new RoomListAdapter(context, roomList);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(roomListAdapter);
    }










}
