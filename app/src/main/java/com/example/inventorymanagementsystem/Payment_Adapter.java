package com.example.inventorymanagementsystem;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;


public class Payment_Adapter extends FirebaseRecyclerAdapter<PaymentModel,Payment_Adapter.myViewHolder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public Payment_Adapter(@NonNull FirebaseRecyclerOptions<PaymentModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull Payment_Adapter.myViewHolder holder, int position, @NonNull PaymentModel model) {
        holder.pName.setText(model.getProductName());
        holder.cName.setText(model.getCustomerName());
        holder.price.setText(model.getTotalAmount());

    }

    @NonNull
    @Override
    public Payment_Adapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.payment_listview,parent,false);
        return new myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder{

        TextView pName,cName,price;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            pName = (TextView) itemView.findViewById(R.id.product);
            cName = (TextView)itemView.findViewById(R.id.customer);
            price = (TextView) itemView.findViewById(R.id.price);
        }
    }
}
