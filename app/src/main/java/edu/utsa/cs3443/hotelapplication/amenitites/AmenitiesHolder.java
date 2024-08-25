package edu.utsa.cs3443.hotelapplication.amenitites;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import edu.utsa.cs3443.hotelapplication.R;

public class AmenitiesHolder extends RecyclerView.ViewHolder {

    TextView name, hours, desc;
    ImageView imageView;
    public AmenitiesHolder(@NonNull View itemView) {
        super(itemView);
        name= itemView.findViewById(R.id.amen_name);
        hours= itemView.findViewById(R.id.amen_hours);
        desc= itemView.findViewById(R.id.amen_desc);
        imageView= itemView.findViewById(R.id.amen_img);
    }
}
