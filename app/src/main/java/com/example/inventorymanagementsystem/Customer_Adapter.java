package com.example.inventorymanagementsystem;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import de.hdodenhof.circleimageview.CircleImageView;

public class Customer_Adapter extends FirebaseRecyclerAdapter<CustomerModel,Customer_Adapter.myViewHolder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public Customer_Adapter(@NonNull FirebaseRecyclerOptions<CustomerModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull CustomerModel model) {
        holder.name.setText(model.getCustomerName());
        holder.contact.setText(model.getContact());
        holder.email.setText(model.getEmail());

        Glide.with(holder.img1.getContext())
                .load(model.getCurl())
                .placeholder(R.drawable.custimg)
                .circleCrop()
                .error(R.drawable.custimg)
                .into(holder.img1);
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.customer_listview,parent,false);
        return new myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder{

        CircleImageView img1;
        TextView name,contact,email;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            img1 =(CircleImageView) itemView.findViewById(R.id.img1);
            name = (TextView) itemView.findViewById(R.id.nameTextView);
            contact = (TextView) itemView.findViewById(R.id.contactTextView);
            email = (TextView) itemView.findViewById(R.id.emailTextView);
        }
    }
}
