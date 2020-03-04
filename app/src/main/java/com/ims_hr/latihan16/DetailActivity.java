package com.ims_hr.latihan16;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView TV_Header;
    TextView TV_Desc;
    TextView TV_Role;
    ImageView IV_Gambar;
    RatingBar RB_Rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Inisial();
        Set_Object();
    }

    private void Inisial() {
        TV_Header = findViewById(R.id.textView_Detail_Header);
        TV_Desc = findViewById(R.id.textView_Detail_Desc);
        TV_Role = findViewById(R.id.textView_Detail_Role);
        IV_Gambar = findViewById(R.id.imageView_Detail_Gambar);
        RB_Rating = findViewById(R.id.ratingBar_Detail_Rating);
    }

    private void Set_Object() {
        Intent intent = getIntent();
        TV_Header.setText(intent.getStringExtra("nama"));
        TV_Desc.setText(intent.getStringExtra("desc"));
        TV_Role.setText(intent.getStringExtra("role"));
        IV_Gambar.setImageResource(intent.getIntExtra("gambar",0) );
        RB_Rating.setRating(intent.getFloatExtra("rating",0));
    }

}
