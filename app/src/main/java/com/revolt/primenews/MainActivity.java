package com.revolt.primenews;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.onesignal.OneSignal;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ImageSlider mainslider;
    private static final String ONESIGNAL_APP_ID = "0136dd72-b8cd-44f6-9932-924dc5a1e627";
    Button Ann,News,Bus,auto,taxi,workers,sevanam,shops,offices,emergency,market,hospital,
    blood,restaurant,general,theatre,tourism,media,feedback,links,about;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         TextView textView = findViewById(R.id.txt);
         textView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
         textView.setSelected(true);
         OneSignal.initWithContext(this);
         OneSignal.setAppId(ONESIGNAL_APP_ID);

         Ann=findViewById(R.id.ann);
         News=findViewById(R.id.news);
         Bus=findViewById(R.id.bustime);
         auto=findViewById(R.id.Auto);
         taxi=findViewById(R.id.Taxi);
         workers=findViewById(R.id.Workers);
         sevanam=findViewById(R.id.Sevanam);
         shops=findViewById(R.id.shops);
         offices=findViewById(R.id.offices);
         emergency=findViewById(R.id.emergency);
         market=findViewById(R.id.market);
         hospital=findViewById(R.id.Hospital);
         blood=findViewById(R.id.BloodBank);
         restaurant=findViewById(R.id.restaurant);
         general=findViewById(R.id.general);
         theatre=findViewById(R.id.Theatre);
         tourism=findViewById(R.id.Tourism);
         media=findViewById(R.id.Media);
         feedback=findViewById(R.id.Feedback);
         links=findViewById(R.id.Links);
         about=findViewById(R.id.Aboutus);

         Ann.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent i=new Intent(MainActivity.this,ViewAnnouncementActivity.class);
                 startActivity(i);
             }
         });
         News.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent i=new Intent(MainActivity.this,ViewNewsActivity.class);
                 startActivity(i);
             }
         });
         Bus.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent i=new Intent(MainActivity.this,ViewbusStationsActivity.class);
                 startActivity(i);
             }
         });
         auto.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent i=new Intent(MainActivity.this,ViewAutoActivity.class);
                 startActivity(i);
             }
         });
         taxi.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent i=new Intent(MainActivity.this,ViewTaxiActivity.class);
                 startActivity(i);
             }
         });
         workers.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent i=new Intent(MainActivity.this,ViewThorilaliActivity.class);
                 startActivity(i);
             }
         });
         sevanam.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent i=new Intent(MainActivity.this,ViewSevanamActivity.class);
                 startActivity(i);
             }
         });
         shops.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent i=new Intent(MainActivity.this,ViewShopsActivity.class);
                 startActivity(i);
             }
         });
         offices.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent i=new Intent(MainActivity.this,ViewOfficeActivity.class);
                 startActivity(i);
             }
         });
         emergency.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent i=new Intent(MainActivity.this,ViewEmergencyActivity.class);
                 startActivity(i);
             }
         });
         market.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent i=new Intent(MainActivity.this,ViewNattuActivity.class);
                 startActivity(i);
             }
         });
         hospital.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent i=new Intent(MainActivity.this,ViewHospitalsActivity.class);
                 startActivity(i);
             }
         });
         blood.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent i=new Intent(MainActivity.this,ViewBloodActivity.class);
                 startActivity(i);
             }
         });
         restaurant.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent i=new Intent(MainActivity.this,ViewRestaurantActivity.class);
                 startActivity(i);
             }
         });
         general.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent i=new Intent(MainActivity.this,ViewGeneralActivity.class);
                 startActivity(i);
             }
         });
         theatre.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent i=new Intent(MainActivity.this,ViewTheatreActivity.class);
                 startActivity(i);
             }
         });
         tourism.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent i=new Intent(MainActivity.this,ViewTourismActivity.class);
                 startActivity(i);
             }
         });
         media.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent i=new Intent(MainActivity.this,ViewMediaActivity.class);
                 startActivity(i);
             }
         });
         feedback.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent i=new Intent(MainActivity.this,ViewFeedbackActivity.class);
                 startActivity(i);
             }
         });
         links.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent i=new Intent(MainActivity.this,ViewLinksActivity.class);
                 startActivity(i);
             }
         });
         about.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent i=new Intent(MainActivity.this,ViewAboutUsActivity.class);
                 startActivity(i);
             }
         });

        mainslider = (ImageSlider) findViewById(R.id.image_slider);
        final List<SlideModel> remoteimages = new ArrayList<>();

         FirebaseDatabase.getInstance().getReference().child("Image")
                 .addListenerForSingleValueEvent(new ValueEventListener() {
                     @Override
                     public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                         for (DataSnapshot data:datasnapshot.getChildren())
                         {
                             remoteimages.add(new SlideModel(data.child("imageurl").getValue().toString(), ScaleTypes.FIT));
                         }
                         mainslider.setImageList(remoteimages,ScaleTypes.FIT);
                     }

                     @Override
                     public void onCancelled(@NonNull DatabaseError error) {

                     }
                 });



    }



}