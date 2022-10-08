package com.example.inventorymanagementsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class add_order_btn extends AppCompatActivity {

    RecyclerView recyclerView3;
    Order_Adapter mainAdapter3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_order_btn);

        getSupportActionBar().setTitle("Order List");

        recyclerView3 = (RecyclerView) findViewById(R.id.rv3);
        recyclerView3.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<OrderModel> options =
                new FirebaseRecyclerOptions.Builder<OrderModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Orders"),OrderModel.class)
                        .build();

        mainAdapter3 = new Order_Adapter(options);
        recyclerView3.setAdapter(mainAdapter3);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mainAdapter3.startListening();;
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainAdapter3.stopListening();;
    }

    public void add_order(View view){
        Intent intent = new Intent(add_order_btn.this, add_order.class);
        startActivity(intent);
    }
}