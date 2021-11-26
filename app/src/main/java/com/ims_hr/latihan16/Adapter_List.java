package com.ims_hr.latihan16;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class Adapter_List extends ArrayAdapter<Adapter_Array> {

    Context context;
    int layputResourceID;
    List<Adapter_Array> Data;

    public Adapter_List(@NonNull Context context, int resource, @NonNull List<Adapter_Array> objects) {
        super(context, resource, objects);
        this.context = context;
        this.layputResourceID = resource;
        this.Data = objects;
    }

    static class DataHolder{
        ImageView IV_Gambar;
        TextView TV_Header;
        TextView TV_Desc;
        TextView TV_Role;
        RatingBar RB_Rating;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        DataHolder holder;
        if(convertView == null){
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            convertView = inflater.inflate(layputResourceID,parent,false);
            holder = new DataHolder();
            holder.IV_Gambar = convertView.findViewById(R.id.imageView_Template_Gambar);
            holder.TV_Header = convertView.findViewById(R.id.textView_Template_Header);
            holder.TV_Desc = convertView.findViewById(R.id.textView_Template_Desc);
            holder.TV_Role = convertView.findViewById(R.id.textView_Template_Role);
            holder.RB_Rating = convertView.findViewById(R.id.ratingBar_Template_Rating);
            convertView.setTag(holder);
        } else {
            holder = (DataHolder)convertView.getTag();
        }
        Adapter_Array dataItem = Data.get(position);
        holder.TV_Header.setText(dataItem.getHeader());
        holder.TV_Desc.setText(dataItem.getDesc());
        holder.TV_Role.setText(dataItem.getRole());
        holder.RB_Rating.setRating(dataItem.getRating());
        holder.IV_Gambar.setImageResource(dataItem.getResID());
        return convertView;
    }

}
