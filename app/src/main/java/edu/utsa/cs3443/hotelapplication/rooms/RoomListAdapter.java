package edu.utsa.cs3443.hotelapplication.rooms;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import edu.utsa.cs3443.hotelapplication.BookingActivity;
import edu.utsa.cs3443.hotelapplication.R;
import edu.utsa.cs3443.hotelapplication.RoomActivity;
import edu.utsa.cs3443.hotelapplication.model.Room;

public class RoomListAdapter extends RecyclerView.Adapter<RoomHolder> {

    public ArrayList<Room> roomList;
    public Context context;

    public RoomListAdapter(Context context, ArrayList<Room> roomList){
        this.context= context;
        this.roomList= roomList;
    }


    @NonNull
    @Override
    public RoomHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context)
                .inflate(R.layout.activity_rooms, parent, false);
        return new RoomHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RoomHolder holder, int position) {
        holder.type.setText(roomList.get(position).getRoomType());
        holder.desc.setText(roomList.get(position).getRoomDesc());
        holder.price.setText(roomList.get(position).getRoomPrice());

        String imageURL= roomList.get(position).getRoomImg();
        if(imageURL != null && !imageURL.isEmpty()){
            Glide.with(context)
                    .load(imageURL)
                    .into(holder.image);
        }

        Room room= roomList.get(position);
        holder.bookBtn.setOnClickListener(v->{
            Intent intent= new Intent(context, BookingActivity.class);
            intent.putExtra("ROOM_PRICE", room.getRoomPrice());
            intent.putExtra("ROOM_TYPE", room.getRoomType());
            context.startActivity(intent);
        });



    }



    @Override
    public int getItemCount() {
        if(roomList != null){
            return roomList.size();
        }
        return 0;
    }


}
