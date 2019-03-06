package com.example.user.restaurant;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Restaurantlist extends AppCompatActivity {
    String url1 = "";
    String url2 = "";
    Spinner citycontainer;
    JSONObject jsonObject = new JSONObject();
    JSONParser jsonParser = new JSONParser();
    ArrayList<String> Cityname;
    int pos;
    String[] id,name,image;
    ArrayList restaurants;
    ArrayList ids;

    RecyclerView recycle;
    RecyclerView.LayoutManager mlayoutmanager;
    RecyclerView.Adapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurantlist);
        url1 = "http://192.168.43.245:80/restaurant/apiCity.php";
        url2 = "http://192.168.43.245:80/restaurant/apiList.php";
        citycontainer=(Spinner)findViewById(R.id.cityspinner);
        Cityname=new ArrayList<>();
        ids=new ArrayList<>();
        citycontainer.setSelection(pos, true);
        restaurants = new ArrayList<>();
        recycle=(RecyclerView)findViewById(R.id.re);
        recycle.setHasFixedSize(true);
     //   recycle.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        try {
            String loginid = "loginid";
            java.util.List<NameValuePair> para1 = new ArrayList<NameValuePair>();
            para1.add(new BasicNameValuePair("loginid", loginid));
            jsonObject = jsonParser.makeHttpRequest(url1, "GET", para1);
            JSONArray ar = jsonObject.getJSONArray("citieslist");

            for (int j = 0; j < ar.length(); j++) {
                JSONObject jsons = ar.getJSONObject(j);
                String id = jsons.getString("id");
                String name = jsons.getString("name");
                ids.add(id);

                Cityname.add(name);
                }

            citycontainer.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, Cityname));


        }catch(Exception ex){
            Toast.makeText(getApplicationContext(), ex.toString(), Toast.LENGTH_LONG).show();
        }
        citycontainer.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                restaurants.clear();
                pos=citycontainer.getSelectedItemPosition();
            //  citycontainer.setSelection(pos, true);
                View v = citycontainer.getSelectedView();
                ((TextView)v).setTextColor(getResources().getColor(R.color.colorPrimaryDark));
               int sselectedcity=citycontainer.getSelectedItemPosition();

                try {
                    String cityid = ids.get(sselectedcity)+"";
                    java.util.List<NameValuePair> para1 = new ArrayList<NameValuePair>();
                    para1.add(new BasicNameValuePair("cityid", cityid));
                    jsonObject = jsonParser.makeHttpRequest(url2, "GET", para1);
                    JSONArray ar = jsonObject.getJSONArray("restaurantlist");

                    name=new String[ar.length()];
                    id=new String[ar.length()];
                    image=new String[ar.length()];

                    for (int j = 0; j < ar.length(); j++) {
                        JSONObject jsons = ar.getJSONObject(j);

                        name[j]=jsons.getString("rest_name");
                        id[j]=jsons.getString("id");
                        image[j]=jsons.getString("image");

                        String rname=name[j];
                        String rid=id[j];
                        String rimage=image[j];
                        restaurantarraylist list = new restaurantarraylist(rid,rname,rimage);
                        restaurants.add(list);
                        }
                        }catch(Exception ex){
                    Toast.makeText(getApplicationContext(), ex.toString(), Toast.LENGTH_LONG).show();
                }
                mlayoutmanager = new LinearLayoutManager(getApplicationContext());
                mAdapter = new RestaurantAdapter(getApplicationContext(),restaurants);
                recycle.setLayoutManager(mlayoutmanager);
                recycle.setAdapter(mAdapter);

                }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        }
    }
