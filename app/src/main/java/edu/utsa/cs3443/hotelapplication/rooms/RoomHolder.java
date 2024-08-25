package edu.utsa.cs3443.hotelapplication.rooms;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import edu.utsa.cs3443.hotelapplication.R;
import edu.utsa.cs3443.hotelapplication.model.Room;

public class RoomHolder extends RecyclerView.ViewHolder {
    public TextView desc, price, type;

    public ImageView image;
    Button bookBtn;

    public RoomHolder(@NonNull View itemView) {
        super(itemView);
        desc = itemView.findViewById(R.id.room_desc);
        price = itemView.findViewById(R.id.room_price);
        type = itemView.findViewById(R.id.room_type);
        image = itemView.findViewById(R.id.room_img);
        bookBtn= itemView.findViewById(R.id.book_button);
    }
}




