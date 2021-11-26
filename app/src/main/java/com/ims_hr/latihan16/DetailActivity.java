package com.ims_hr.latihan16;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.ims_hr.latihan16.setting.GlobalVar;

public class DetailActivity extends AppCompatActivity {

    TextView TV_Header, TV_Desc, TV_Role;
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
        TV_Header.setText(intent.getStringExtra(GlobalVar.EXTRA_NAMA));
        TV_Desc.setText(intent.getStringExtra(GlobalVar.EXTRA_DESC));
        TV_Role.setText(intent.getStringExtra(GlobalVar.EXTRA_ROLE));
        IV_Gambar.setImageResource(intent.getIntExtra(GlobalVar.EXTRA_GAMBAR,0) );
        RB_Rating.setRating(intent.getFloatExtra(GlobalVar.EXTRA_RATING,0));
    }

}
