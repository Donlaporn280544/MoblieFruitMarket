package com.example.fruitshop.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.fruitshop.R;
import com.example.fruitshop.databinding.FragmentHomeBinding;
import com.example.fruitshop.fruit;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private FirebaseFirestore db;
    private FirestoreRecyclerAdapter<fruit, fruitViewHolder> adapter;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //Initialize Firestore
        db = FirebaseFirestore.getInstance();

        //Query the Manga collection in Firestore
        Query query = db.collection("PopularPtoducts");

        //Configure the adapter options
        FirestoreRecyclerOptions<fruit> options = new FirestoreRecyclerOptions.Builder<fruit>()
                .setQuery(query, fruit.class)
                .build();

        //Initialize the adapter
        adapter = new FirestoreRecyclerAdapter<fruit, fruitViewHolder>(options) {
            @Nullable
            @Override
            protected void onBindViewHolder(@NonNull fruitViewHolder holder, int position, @NonNull fruit model) {
                holder.bind(model);

            }
            @NonNull
            @Override
            public fruitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.popular_item, parent, false);
                ImageView pop_img = view.findViewById(R.id.pop_Img);
                TextView pop_name = view.findViewById(R.id.pop_name);
                TextView pop_des = view.findViewById(R.id.pop_des);
                ImageView imageView = view.findViewById(R.id.pop_star);
                TextView pop_rating = view.findViewById(R.id.pop_rating);
                TextView pop_discount = view.findViewById(R.id.pop_discount);
                return new fruitViewHolder(view,pop_img , pop_des,pop_name,pop_rating,pop_discount, parent.getContext());
            }
        };

        //Set up the RecycleView
        RecyclerView recyclerView = binding.popRec;
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerView.setAdapter(adapter);

        return root;
    }
    // Define the ViewHolder for the adapter
    private static class fruitViewHolder extends RecyclerView.ViewHolder {
        private final ImageView pop_Img;
        private final TextView pop_des;
        private final TextView pop_name;
        private final TextView pop_rating;
        private final TextView pop_discount;

        private Context mContext;

        public fruitViewHolder(@NonNull View itemView  , ImageView pop_img, TextView pop_des, TextView pop_name, TextView pop_rating, TextView pop_discount, Context context) {
            super(itemView);
            pop_Img = pop_img;
            this.pop_des = pop_des;
            this.pop_name = pop_name;
            this.pop_rating = pop_rating;
            this.pop_discount = pop_discount;
            mContext = context;
        }

        public void bind(fruit fruit) {
            //Bind the data to the views
            Glide.with(mContext)
                    .load(fruit.getImg_url())
                    .centerCrop()
                    .into(pop_Img);
            pop_des.setText(fruit.getDescription());
            pop_name.setText(fruit.getName());
            pop_rating.setText(fruit.getRating());
            pop_discount.setText(fruit.getDiscount());
        }
    }
    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }

}