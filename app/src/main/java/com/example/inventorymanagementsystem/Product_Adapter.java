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

public class Product_Adapter extends FirebaseRecyclerAdapter<ProductModel,Product_Adapter.myViewHolder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public Product_Adapter(@NonNull FirebaseRecyclerOptions<ProductModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull ProductModel model) {
        holder.name.setText(model.getName());
        holder.disc.setText(model.getDiscription());
        holder.quantity.setText(model.getQuantity());
        holder.price.setText(model.getPrice());

        Glide.with(holder.img2.getContext())
                .load(model.getPurl())
                .placeholder(R.drawable.img)
                .circleCrop()
                .error(R.drawable.img)
                .into(holder.img2);

    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_listview,parent,false);
        return new myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder{

        CircleImageView img2;
        TextView name , disc , quantity, price;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            img2 =(CircleImageView) itemView.findViewById(R.id.img2);
            name = (TextView) itemView.findViewById(R.id.productNameTextView);
            disc = (TextView) itemView.findViewById(R.id.productDiscTextView);
            quantity = (TextView) itemView.findViewById(R.id.productQuanTextView);
            price = (TextView) itemView.findViewById(R.id.productPriceTextView);
        }
    }
}
