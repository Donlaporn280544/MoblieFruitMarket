package com.example.fruitshop.ui.credit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.fruitshop.CreditActivity;
import com.example.fruitshop.databinding.FragmentCreditBinding;


public class CreditFragment extends Fragment {

    private FragmentCreditBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        CreditViewModel creditViewModel =
                new ViewModelProvider(this).get(CreditViewModel.class);

        binding = FragmentCreditBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        Button button=binding.payNow;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreditActivity creditActivity=new CreditActivity();
                creditActivity.show(getActivity().getSupportFragmentManager(), creditActivity.getTag());
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}