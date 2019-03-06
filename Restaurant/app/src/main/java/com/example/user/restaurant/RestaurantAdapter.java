package com.example.user.restaurant;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.preference.PreferenceManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URL;
import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.ViewHolder> {
    ArrayList<restaurantarraylist>restaurant;
    Context cont;
    SharedPreferences sp2;
    public RestaurantAdapter(Context context, ArrayList<restaurantarraylist>restaurants){
        restaurant= restaurants;
        cont=context;

    }



    @Override
    public RestaurantAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View View = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem, parent, false);
        return new ViewHolder(View);
    }

    @Override
    public void onBindViewHolder(final RestaurantAdapter.ViewHolder holder, int position) {
     final    restaurantarraylist List = restaurant.get(position);
       final String path1="http://192.168.43.245/restaurant/uploads/";
try {
    holder.name.setText(List.getName());
    URL url1 = new URL(path1.concat(List.getImage()));
    Bitmap bm1 = BitmapFactory.decodeStream(url1.openStream());
    holder.imag.setImageBitmap(bm1);
}
          catch (Exception e) {
            Toast.makeText(cont, e.toString(), Toast.LENGTH_LONG).show();

        }
        holder.imag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cont = holder.itemView.getContext();
                AlertDialog.Builder alertimg = new AlertDialog.Builder(cont);
                LayoutInflater factory = LayoutInflater.from(cont);
                final View view1 = factory.inflate(R.layout.imagepreviewalert, null);
                alertimg.setView(view1);
                ImageView pre = (ImageView) view1.findViewById(R.id.preimage);
try {
    URL url1 = new URL(path1.concat(List.getImage()));
    Bitmap bm1 = BitmapFactory.decodeStream(url1.openStream());
    pre.setImageBitmap(bm1);
    pre.setScaleType(ImageView.ScaleType.FIT_XY);
}
catch(Exception ex){
    Toast.makeText(cont, ex.toString(), Toast.LENGTH_LONG).show();
}
                alertimg.setNeutralButton("Ok!", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dlg, int sumthin) {

                    }
                });
                AlertDialog alertDialog = alertimg.create();
                alertDialog.show();
               // alertimg.show();

            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String restaurantid=List.getId();
                SharedPreferences.Editor ed = sp2.edit();
                ed.putString("rid",restaurantid);
                ed.commit();
                Intent in = new Intent(cont,restaurant_details.class);
                in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                cont.startActivity(in);
            }
        });


    }

    @Override
    public int getItemCount() {
        return restaurant.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        CircleImageView imag;



        public ViewHolder(View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.rname);
            imag=itemView.findViewById(R.id.rimg);
            sp2= PreferenceManager.getDefaultSharedPreferences(cont);

        }
    }
}
