package com.example.inventorymanagementsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class add_order extends AppCompatActivity {

    Spinner spinner1,spinner2;
    EditText price , quantity;
    Button addOrder;
    DatabaseReference databaseReference;
    List<String> names,names2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_order);

        getSupportActionBar().setTitle("Add Order");

        spinner1 = findViewById(R.id.sp1);
        spinner2 = findViewById(R.id.sp2);
        price = findViewById(R.id.pri);
        quantity = findViewById(R.id.qua);
        addOrder = findViewById(R.id.btnAddOrder);

        names = new ArrayList<>();
        names2 = new ArrayList<>();

        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.child("Product").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot childSnapshot:dataSnapshot.getChildren()) {
                    String spinnerName = childSnapshot.child("name").getValue(String.class);
                    names.add(spinnerName);
                }
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(add_order.this, android.R.layout.simple_spinner_item,names);
                arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
                spinner1.setAdapter(arrayAdapter);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        databaseReference.child("Customer").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot2) {

                for(DataSnapshot childSnapshot2:dataSnapshot2.getChildren()) {
                    String spinnerName2 = childSnapshot2.child("customerName").getValue(String.class);
                    names2.add(spinnerName2);
                }
                ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<>(add_order.this, android.R.layout.simple_spinner_item,names2);
                arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_item);
                spinner2.setAdapter(arrayAdapter2);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        addOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addOrderDetail();
            }
        });

//        String sp_data = spinner1.getSelectedItem().toString();
//        DatabaseReference pri = FirebaseDatabase.getInstance().getReference().child("Product").child(sp_data).child("price");
//        price.setText((CharSequence) pri);

    }

    private void addOrderDetail() {

        String ProductName = spinner1.getSelectedItem().toString();
        String CustomerName = spinner2.getSelectedItem().toString();
        String ProductPrice = price.getText().toString();
        String ProductQuantity = quantity.getText().toString();

        if(ProductPrice.isEmpty()){
            price.setError("Price is required!");
        }else if(ProductQuantity.isEmpty()){
            quantity.setError("Quantity is Required!");
        }else {

            FirebaseDatabase db =FirebaseDatabase.getInstance();
            DatabaseReference root =db.getReference().child("Orders");

            OrderModel addOrder = new OrderModel(ProductName,CustomerName,ProductPrice,ProductQuantity);

            root.child(ProductName).setValue(addOrder);

            Toast.makeText(this,"Order Added Successfully!",Toast.LENGTH_SHORT).show();


            int pPrice = Integer.parseInt(ProductPrice);
            int pQua = Integer.parseInt(ProductQuantity);

            int totalAmount = pPrice * pQua;

            String amount = Integer.toString(totalAmount);

            FirebaseDatabase db2 = FirebaseDatabase.getInstance();
            DatabaseReference root2 = db2.getReference().child("Payment Details");

            PaymentModel addPayment = new PaymentModel(ProductName,CustomerName,amount);

            root2.child(CustomerName).setValue(addPayment);
        }
    }
}