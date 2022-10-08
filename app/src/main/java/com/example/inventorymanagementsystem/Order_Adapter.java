package com.example.inventorymanagementsystem;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;


public class Order_Adapter extends FirebaseRecyclerAdapter<OrderModel,Order_Adapter.myViewHolder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public Order_Adapter(@NonNull FirebaseRecyclerOptions<OrderModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull Order_Adapter.myViewHolder holder, int position, @NonNull OrderModel model) {
        holder.pname.setText(model.getProductName());
        holder.cname.setText(model.getCustomerName());
        holder.price.setText(model.getPrice());
        holder.quan.setText(model.getQuantity());

    }

    @NonNull
    @Override
    public Order_Adapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_listview,parent,false);
        return new myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder{

        TextView pname,cname,price,quan;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            pname = (TextView) itemView.findViewById(R.id.productNameTextView2);
            cname = (TextView)itemView.findViewById(R.id.customerNameTextView2);
            price = (TextView) itemView.findViewById(R.id.productPriceTextView2);
            quan = (TextView) itemView.findViewById(R.id.productQuanTextView2);

        }
    }
}