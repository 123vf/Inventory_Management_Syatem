package com.example.inventorymanagementsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class payment_details extends AppCompatActivity {

    RecyclerView recyclerView4;
    Payment_Adapter mainAdapter4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_details);

        getSupportActionBar().setTitle("Payment Details");

        recyclerView4 = (RecyclerView) findViewById(R.id.rv4);
        recyclerView4.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<PaymentModel> options =
                new FirebaseRecyclerOptions.Builder<PaymentModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Payment Details"),PaymentModel.class)
                        .build();

        mainAdapter4 = new Payment_Adapter(options);
        recyclerView4.setAdapter(mainAdapter4);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mainAdapter4.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainAdapter4.stopListening();
    }
}