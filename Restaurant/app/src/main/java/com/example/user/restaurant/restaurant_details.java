package com.example.user.restaurant;

import android.app.ActionBar;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class restaurant_details extends AppCompatActivity {
    String url1 = "";
    TextView name,address,mail,phone;
    ImageView image;
    JSONObject jsonObject = new JSONObject();
    JSONParser jsonParser = new JSONParser();
    SharedPreferences sp2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_details);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        url1 = "http://192.168.43.245:80/restaurant/apiSingle.php";
        name=(TextView)findViewById(R.id.name);
        address=(TextView)findViewById(R.id.addres);
        mail=(TextView)findViewById(R.id.mail);
        phone=(TextView)findViewById(R.id.phone);
        image=(ImageView) findViewById(R.id.fullimage);
        String path1="http://192.168.43.245/restaurant/uploads/";
        sp2= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        try {
            String selectedrestaurantid =sp2.getString("rid","");
            java.util.List<NameValuePair> para1 = new ArrayList<NameValuePair>();
            para1.add(new BasicNameValuePair("restaurantid", selectedrestaurantid));
            jsonObject = jsonParser.makeHttpRequest(url1, "GET", para1);
            String result=jsonObject.getString("success");
            if(result.equalsIgnoreCase("1"))
            {
                String id = jsonObject.getString("rid");
                String name1 = jsonObject.getString("name");
                String address1 = jsonObject.getString("address");
                String mail1 = jsonObject.getString("mail");
                String phone1 = jsonObject.getString("phone");
                String image1 = jsonObject.getString("image");
                name.setText(name1);
                address.setText(address1);
                mail.setText(mail1);
                phone.setText(phone1);

                URL url1 = new URL(path1.concat(image1));
                Bitmap bm1 = BitmapFactory.decodeStream(url1.openStream());
                image.setImageBitmap(bm1);
                image.setScaleType(ImageView.ScaleType.FIT_XY);

            }
            else{
                Toast.makeText(getApplicationContext(),"No Data",Toast.LENGTH_LONG).show();

            }


        }catch(Exception ex){
            Toast.makeText(restaurant_details.this, ex.toString(), Toast.LENGTH_LONG).show();
        }

    }
    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), Restaurantlist.class);
        startActivityForResult(myIntent, 0);
        return true;
    }
    }
