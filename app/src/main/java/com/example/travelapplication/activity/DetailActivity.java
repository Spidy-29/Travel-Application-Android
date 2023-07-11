package com.example.travelapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.travelapplication.R;
import com.example.travelapplication.domains.PopularDomain;

public class DetailActivity extends AppCompatActivity {

    private TextView tv_title, tv_location, tv_star, tv_bed, tv_guide, tv_wifi, tv_description, tv_price;
    private ImageView iv_pic, iv_back_btn, iv_like;
    private PopularDomain item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initView();
        setVariable();
    }

    private void setVariable() {
        item = (PopularDomain) getIntent().getSerializableExtra("object");

        tv_title.setText(item.getTitle());
        tv_star.setText(""+(int) item.getScore());
        tv_location.setText(item.getLocation());
        tv_bed.setText(item.getBed() + " Bed");
        tv_description.setText(item.getDescription());

        if (item.isGuide()) {
            tv_guide.setText("Guide");
        } else {
            tv_guide.setText("No-Guide");
        }
        if (item.isWifi()) {
            tv_wifi.setText("wifi");
        } else {
            tv_wifi.setText("No-wifi");
        }

        int drawableResId = getResources().getIdentifier(item.getPic(), "drawable", getPackageName());

        Glide.with(this).load(drawableResId).into(iv_pic);

        iv_back_btn.setOnClickListener(v -> finish());
    }

    private void initView() {
        tv_title = findViewById(R.id.tv_title);
        tv_location = findViewById(R.id.tv_location);
        tv_star = findViewById(R.id.tv_star);
        tv_bed = findViewById(R.id.tv_bed);
        tv_guide = findViewById(R.id.tv_guide);
        tv_wifi = findViewById(R.id.tv_wifi);
        tv_description = findViewById(R.id.tv_description);
        tv_price = findViewById(R.id.tv_price);
        iv_pic = findViewById(R.id.iv_pic);
        iv_back_btn = findViewById(R.id.iv_back_btn);
        iv_like = findViewById(R.id.iv_like);
    }
}