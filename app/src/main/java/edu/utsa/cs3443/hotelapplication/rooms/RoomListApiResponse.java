package edu.utsa.cs3443.hotelapplication.rooms;

import java.util.ArrayList;

import edu.utsa.cs3443.hotelapplication.model.Room;

public class RoomListApiResponse {
    public ArrayList<Room> data;

    public ArrayList<Room> getData(){
        return data;
    }
}
