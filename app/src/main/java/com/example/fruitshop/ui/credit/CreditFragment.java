package com.example.fruitshop.ui.credit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.fruitshop.databinding.FragmentCreditBinding;


public class CreditFragment extends Fragment {

    private FragmentCreditBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        CreditViewModel creditViewModel =
                new ViewModelProvider(this).get(CreditViewModel.class);

        binding = FragmentCreditBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textCredit;
        creditViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}