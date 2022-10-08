package com.example.inventorymanagementsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class add_customer_btn extends AppCompatActivity {

    RecyclerView recyclerView1;
    Customer_Adapter mainAdapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_customer_btn);

        getSupportActionBar().setTitle("Customer Details");

        recyclerView1 = (RecyclerView) findViewById(R.id.rv1);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<CustomerModel> options =
                new FirebaseRecyclerOptions.Builder<CustomerModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Customer"),CustomerModel.class)
                        .build();

        mainAdapter1 = new Customer_Adapter(options);
        recyclerView1.setAdapter(mainAdapter1);
    }
    @Override
    protected void onStart() {
        super.onStart();
        mainAdapter1.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainAdapter1.stopListening();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.search,menu);
        MenuItem item = menu.findItem(R.id.search);
//        SearchView searchView = (SearchView)item.getActionView();
//
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String s) {
//                txtSearch(s);
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String s) {
//                txtSearch(s);
//                return false;
//            }
//        });

        return super.onCreateOptionsMenu(menu);
    }

//    private void txtSearch(String s){
//        FirebaseRecyclerOptions<ProductModel> options =
//                new FirebaseRecyclerOptions.Builder<ProductModel>()
//                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Customer").orderByChild("name").startAt(s).endAt(s+"~"), ProductModel.class)
//                        .build();
//
//        mainAdapter1 = new Customer_Adapter(options);
//        mainAdapter1.startListening();
//        recyclerView1.setAdapter(mainAdapter1);
//    }

    public void add_customer(View view){
        Intent intent = new Intent(add_customer_btn.this, add_customer.class);
        startActivity(intent);
    }
}