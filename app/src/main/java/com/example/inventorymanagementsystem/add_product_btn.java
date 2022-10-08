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
import android.widget.Button;
import android.widget.EditText;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class add_product_btn extends AppCompatActivity {

    RecyclerView recyclerView2;
    Product_Adapter mainAdapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product_btn);

        getSupportActionBar().setTitle("Product Details");

        recyclerView2 = (RecyclerView) findViewById(R.id.rv2);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<ProductModel> options =
                new FirebaseRecyclerOptions.Builder<ProductModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Product"), ProductModel.class)
                        .build();

        mainAdapter2 = new Product_Adapter(options);
        recyclerView2.setAdapter(mainAdapter2);

    }

    @Override
    protected void onStart() {
        super.onStart();
        mainAdapter2.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainAdapter2.stopListening();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.search,menu);
        MenuItem item = menu.findItem(R.id.search);
//        SearchView searchView = (SearchView)item.getActionView();
//
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                txtSearch(query);
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String query) {
//                txtSearch(query);
//                return false;
//            }
//        });

        return super.onCreateOptionsMenu(menu);
    }

//   private void txtSearch(String s){
//        FirebaseRecyclerOptions<ProductModel> options =
//                new FirebaseRecyclerOptions.Builder<ProductModel>()
//                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Customer").orderByChild("name").startAt(s).endAt(s+"~"), ProductModel.class)
//                        .build();
//
//        mainAdapter1 = new Customer_Adapter(options);
//        mainAdapter1.startListening();
//        recyclerView1.setAdapter(mainAdapter1);
//    }

        public void add_product(View view){
        Intent intent = new Intent(add_product_btn.this, add_product.class);
        startActivity(intent);
    }

}