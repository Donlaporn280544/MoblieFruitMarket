package com.example.fruitshop.ui.account;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.fruitshop.LogoutActivity;
import com.example.fruitshop.R;
import com.example.fruitshop.databinding.FragmentAccountBinding;
import com.example.fruitshop.ui.shopping.ShoppingActivity;

public class AccountFragment extends Fragment {

    private FragmentAccountBinding binding;
    Button Btn_to_payment;
    Button Btn_to_logout;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        AccountViewModel homeViewModel =
                new ViewModelProvider(this).get(AccountViewModel.class);

        binding = FragmentAccountBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;


    }
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Btn_to_payment = view.findViewById(R.id.btn_to_payment);
        Btn_to_logout = view.findViewById(R.id.btn_to_logout);
        Btn_to_payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),ShoppingActivity.class);
                startActivity(intent);
            }
        });
        Btn_to_logout = view.findViewById(R.id.btn_to_logout);
        Btn_to_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LogoutActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
