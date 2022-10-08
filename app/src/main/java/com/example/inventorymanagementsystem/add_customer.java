package com.example.inventorymanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class add_customer extends AppCompatActivity {

    EditText cName , cContact , cEmail , cImgUrl;
    Button addCustomer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_customer);

        getSupportActionBar().setTitle("Add Customer");

        cName = (EditText) findViewById(R.id.customerName);
        cContact = (EditText) findViewById(R.id.customerContact);
        cEmail = (EditText) findViewById(R.id.customerEmail);
        cImgUrl = (EditText) findViewById(R.id.customerImg);
        addCustomer = (Button) findViewById(R.id.btnAddCustomer);


        addCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addCustomer();
            }
        });
    }

    private void addCustomer() {

        String Name = cName.getText().toString();
        String Contact = cContact.getText().toString();
        String Email = cEmail.getText().toString();
        String Img = cImgUrl.getText().toString();

        if(Name.isEmpty()){
            cName.setError("Name is Required!");
        }else if(Contact.isEmpty()){
            cContact.setError("Contact is Required!");
        }else if(Email.isEmpty()){
            cEmail.setError("Email is Required!");
        }else if(Img.isEmpty()){
            cImgUrl.setError("Image URL is Required!");
        }else{

            FirebaseDatabase db =FirebaseDatabase.getInstance();
            DatabaseReference root =db.getReference().child("Customer");

            CustomerModel addCustomer = new CustomerModel(Name,Contact,Email,Img);

            root.child(Name).setValue(addCustomer);

            Toast.makeText(this,"Customer Added Successfully!",Toast.LENGTH_SHORT).show();
        }
    }
}