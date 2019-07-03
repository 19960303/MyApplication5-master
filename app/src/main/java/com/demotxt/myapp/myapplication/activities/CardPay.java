package com.demotxt.myapp.myapplication.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.craftman.cardform.Card;
import com.craftman.cardform.CardForm;
import com.craftman.cardform.OnPayBtnClickListner;
import com.demotxt.myapp.myapplication.R;

public class CardPay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_pay);

        CardForm cardForm= (CardForm)findViewById(R.id.cardform);
        TextView text= (TextView)findViewById(R.id.payment_amount);
        Button btnPay= (Button)findViewById(R.id.btn_pay);

        text.setText("1999");
        btnPay.setText((String.format("payer is",text.getText())));

        cardForm.setPayBtnClickListner(new OnPayBtnClickListner() {
            @Override
            public void onClick(Card card) {
                Toast.makeText(CardPay.this,"Number"+card.getNumber()+"I CVC:"+card.getCVC(),Toast.LENGTH_SHORT).show();
            }
        });


    }
}
