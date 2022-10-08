package com.example.inventorymanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class add_product extends AppCompatActivity {

    EditText pName , pPrice , pQuantity , pDisc , pImg;
    Button addPro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        getSupportActionBar().setTitle("Add Product");

        pName = (EditText) findViewById(R.id.productName);
        pPrice = (EditText) findViewById(R.id.productPrice);
        pQuantity = (EditText) findViewById(R.id.productQuantity);
        pDisc = (EditText) findViewById(R.id.productDiscription);
        pImg = (EditText) findViewById(R.id.productImgUrl);
        addPro = (Button) findViewById(R.id.btnAddProduct);

        addPro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addProduct();
            }
        });

    }

    private void addProduct() {

        String prName = pName.getText().toString();
        String prPrice = pPrice.getText().toString();
        String prQuantity = pQuantity.getText().toString();
        String prDisc = pDisc.getText().toString();
        String prImg = pImg.getText().toString();

        if(prName.isEmpty()){
            pName.setError("Product Name is Required!");
        }else if(prPrice.isEmpty()){
            pPrice.setError("Price is Required!");
        }else if(prQuantity.isEmpty()){
            pQuantity.setError("Quantity is Required!");
        }else if(prDisc.isEmpty()){
            pDisc.setError("Discription is Required!");
        }else if(prImg.isEmpty()){
            pImg.setError("Image Link is Required!");
        }else{

            FirebaseDatabase db = FirebaseDatabase.getInstance();
            DatabaseReference root = db.getReference().child("Product");

            ProductModel addProduct = new ProductModel(prName,prPrice,prQuantity,prDisc,prImg);

            root.child(prName).setValue(addProduct);

            Toast.makeText(this,"Product Added Successfully!",Toast.LENGTH_SHORT).show();
        }
    }

}