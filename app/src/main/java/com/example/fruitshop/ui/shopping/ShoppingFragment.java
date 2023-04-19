package com.example.fruitshop.ui.shopping;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;


import com.example.fruitshop.R;
import com.example.fruitshop.databinding.FragmentShoppingBinding;

public class ShoppingFragment extends Fragment {

    private FragmentShoppingBinding binding;

    ImageView imgcart;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        ShoppingViewModel shoppingViewModel =
                new ViewModelProvider(this).get(ShoppingViewModel.class);

        binding = FragmentShoppingBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        return root;
    }

    public ImageView Imgcart() {
        //ใส่ภาพลงimgview
        //imgcart   = (Image) getView().findViewById(R.id.imgcart);
        //imgcart.setImageResource(R.drawable.bg1.jpg);
        imgcart = (ImageView) getView().findViewById(R.id.imageView);
        imgcart.setImageResource(R.drawable.bg1);
        return imgcart;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}