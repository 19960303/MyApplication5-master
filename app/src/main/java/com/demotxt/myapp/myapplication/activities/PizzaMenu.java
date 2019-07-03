package com.demotxt.myapp.myapplication.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.demotxt.myapp.myapplication.R;
import com.demotxt.myapp.myapplication.adapters.RecyclerViewAdapter;
import com.demotxt.myapp.myapplication.model.PizzaDetails;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class PizzaMenu extends AppCompatActivity {

    private final String JSON_URL = "http://172.16.53.50:8080/demo/all" ;
    private JsonArrayRequest request ;
    private RequestQueue requestQueue ;
    private List<PizzaDetails> lstPizzaDetails;
    private RecyclerView recyclerView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_menu);

        lstPizzaDetails = new ArrayList<>() ;
        recyclerView = findViewById(R.id.recyclerviewid);
        jsonrequest();

    }
    private void jsonrequest() {

        request = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject  = null ;

                for (int i = 0 ; i < response.length(); i++ ) {


                    try {
                        jsonObject = response.getJSONObject(i) ;
                        PizzaDetails pizzaDetails = new PizzaDetails() ;
                        pizzaDetails.setName(jsonObject.getString("name"));
                        pizzaDetails.setDescription(jsonObject.getString("description"));
                        pizzaDetails.setPizzaId(jsonObject.getInt("pizzaId"));
                        pizzaDetails.setPrice(jsonObject.getInt("price"));
                        pizzaDetails.setImageUrl(jsonObject.getString("imageUrl"));
                        lstPizzaDetails.add(pizzaDetails);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }

                setuprecyclerview(lstPizzaDetails);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });


        requestQueue = Volley.newRequestQueue(PizzaMenu.this);
        requestQueue.add(request) ;


    }

    private void setuprecyclerview(List<PizzaDetails> lstPizzaDetails) {


        RecyclerViewAdapter myadapter = new RecyclerViewAdapter(this, lstPizzaDetails) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myadapter);

    }
}
