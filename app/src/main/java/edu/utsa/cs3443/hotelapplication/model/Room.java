package edu.utsa.cs3443.hotelapplication.model;

import android.media.Image;
import android.widget.ImageView;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Room {
    @SerializedName("roomid")
    public int roomId;
    @SerializedName("roomtype")
    public String roomType;
    @SerializedName("roomdesc")
    public String roomDesc;
    @SerializedName("roomprice")
    public String roomPrice;
    @SerializedName("roomimage")
    public String  roomImg;




    public Room(int roomId, String roomType, String roomPrice, String roomDesc, String roomImg){
        this.roomId= roomId;
        this.roomType= roomType;
        this.roomPrice= roomPrice;
        this.roomDesc= roomDesc;
        this.roomImg= roomImg;
    }

    public Room(){}
    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(String roomPrice) {
        this.roomPrice = roomPrice;
    }

    public String getRoomDesc() {
        return roomDesc;
    }

    public void setRoomDesc(String roomDesc) {
        this.roomDesc = roomDesc;
    }

    public String getRoomImg(){return roomImg;}
    public void setRoomImg(String roomImg){
        this.roomImg= roomImg;
    }


}
