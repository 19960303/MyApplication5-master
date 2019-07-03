package com.demotxt.myapp.myapplication.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.demotxt.myapp.myapplication.R;

public class Purchase extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton radioButton;
    TextView textView;
    private Button Fill;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);

        Fill=findViewById(R.id.btnfill);
      Fill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Purchase.this, CardPay.class);
                startActivity(intent);
            }
        });






    radioGroup = findViewById(R.id.radioGroup);
        textView = findViewById(R.id.text_view_selected);
        Button buttonApply = findViewById(R.id.btnApply);

        buttonApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int radioId = radioGroup.getCheckedRadioButtonId();

                radioButton = findViewById(R.id.radioCash);

                textView.setText("your choice :"+radioButton.getText());
            }
        });

    }


    public void checkButton(View v){
        int radioId = radioGroup.getCheckedRadioButtonId();

        radioButton = findViewById(radioId);

        Toast.makeText(this,"Selected Radio Button:"+radioButton.getText(),Toast.LENGTH_SHORT).show();
}



}

