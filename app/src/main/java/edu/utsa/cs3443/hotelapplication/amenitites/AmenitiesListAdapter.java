package edu.utsa.cs3443.hotelapplication.amenitites;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import edu.utsa.cs3443.hotelapplication.R;
import edu.utsa.cs3443.hotelapplication.model.Amenities;

public class AmenitiesListAdapter extends RecyclerView.Adapter<AmenitiesHolder> {

    public Context context;
    public ArrayList<Amenities> amenitiesList;

    public AmenitiesListAdapter(Context context, ArrayList<Amenities> amenitiesList){
        this.context= context;
        this.amenitiesList= amenitiesList;
    }


    @NonNull
    @Override
    public AmenitiesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context)
                .inflate(R.layout.activity_amenities, parent, false);
        return new AmenitiesHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AmenitiesHolder holder, int position) {
        holder.name.setText(amenitiesList.get(position).getName());
        holder.hours.setText(amenitiesList.get(position).getHours());
        holder.desc.setText(amenitiesList.get(position).getDesc());

        String url= amenitiesList.get(position).getImg();
        if(url != null){
            Glide.with(context)
                    .load(url)
                    .into(holder.imageView);
        }
    }

    @Override
    public int getItemCount() {
        if(amenitiesList != null){
            return amenitiesList.size();
        }
        return 0;
    }
}
