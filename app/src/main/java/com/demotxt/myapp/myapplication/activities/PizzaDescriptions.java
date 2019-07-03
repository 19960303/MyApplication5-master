package com.demotxt.myapp.myapplication.activities;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.demotxt.myapp.myapplication.R ;

public class PizzaDescriptions extends AppCompatActivity {
    private Button Purchase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizzadescription);

        // hide the default actionbar
        //getSupportActionBar().hide();

        // Recieve data

        String pname  = getIntent().getExtras().getString("pizza_name");
        String description = getIntent().getExtras().getString("pizza_description");
        int pId = getIntent().getExtras().getInt("pizza_pizzaId") ;
        int price = getIntent().getExtras().getInt("pizza_price") ;
        String image_url = getIntent().getExtras().getString("pizza_img") ;

        // ini views

        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsingtoolbar_id);
        collapsingToolbarLayout.setTitleEnabled(true);

        TextView tv_name = findViewById(R.id.pizza_name);

        TextView tv_id = findViewById(R.id.pizza_id) ;
        TextView tv_description = findViewById(R.id.pizza_description);
        TextView tv_rating  = findViewById(R.id.pizza_price) ;
        ImageView img = findViewById(R.id.pizza_thumbnail);

        // setting values to each view

        tv_name.setText(pname);
        tv_id.setText(String.valueOf(pId));
        tv_description.setText(description);
        tv_rating.setText(String.valueOf(price));


        collapsingToolbarLayout.setTitle(pname);


        RequestOptions requestOptions = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);


        // set image using Glide
        Glide.with(this).load(image_url).apply(requestOptions).into(img);

        Purchase = (Button) findViewById(R.id.btnpurchase);

        Purchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PizzaDescriptions.this, Purchase.class);
                startActivity(intent);
            }
        });




    }
}
