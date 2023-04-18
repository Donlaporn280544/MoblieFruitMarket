package com.example.fruitshop;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class CreditActivity extends BottomSheetDialogFragment {
    private EditText Name;
    private EditText LastName;
    private EditText Cardnumber;
    private EditText Date;
    private EditText CVC;
    Button btnpay;

    @Override
    public void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle saveInstanceState) {
        View view = inflater.inflate(R.layout.creditinfo, viewGroup, false);

        Name = view.findViewById(R.id.Name);
        LastName = view.findViewById(R.id.LastName);
        Cardnumber = view.findViewById(R.id.Cardnumber);
        Date = view.findViewById(R.id.Date);
        CVC = view.findViewById(R.id.CVC);
        btnpay=view.findViewById(R.id.pay_now);
        btnpay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Name.setText("");
                LastName.setText("");
                Cardnumber.setText("");
                Date.setText("");
                CVC.setText("");
                Toast.makeText(requireContext(),"บันทึกข้อมูลเรียบร้อย",Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
