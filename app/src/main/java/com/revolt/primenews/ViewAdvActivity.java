package com.revolt.primenews;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ViewAdvActivity extends AppCompatActivity {

ImageSlider mainslider;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_adv);


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