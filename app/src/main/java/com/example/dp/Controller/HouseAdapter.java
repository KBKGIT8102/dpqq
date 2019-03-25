package com.example.dp.Controller;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dp.Model.House;
import com.example.dp.R;
import com.example.dp.ViewPagerActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class HouseAdapter extends RecyclerView.Adapter<HouseAdapter.ViewHolder>
{
    private List<House> houses;
    private Context context;

    public HouseAdapter(List<House> houses, Context context) {
        this.houses = houses;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.house_item, viewGroup, false);
        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        House house = houses.get(i);
        viewHolder.title.setText(house.getTitle());
        viewHolder.district.setText(house.getDistrict_title());
        viewHolder.area.setText(house.getArea());
        viewHolder.price.setText(house.getPrice_total());
        Picasso.with(context).load(house.getPicture_path()).into(viewHolder.image);
        viewHolder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, ViewPagerActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return houses.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView title;
        private TextView district;
        private TextView area;
        private TextView price;
        private ImageView image;
        private CardView cv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title=(TextView)itemView.findViewById(R.id.title);
            district=(TextView)itemView.findViewById(R.id.district);
            area=(TextView)itemView.findViewById(R.id.area);
            price=(TextView)itemView.findViewById(R.id.price);
            image=(ImageView)itemView.findViewById(R.id.image);
            cv=itemView.findViewById(R.id.cv);
        }

    }
}
