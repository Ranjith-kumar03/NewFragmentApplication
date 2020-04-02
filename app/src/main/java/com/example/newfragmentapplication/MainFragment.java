package com.example.newfragmentapplication;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {
Button mainButton1;
ButtonOnClick listner;
public interface  ButtonOnClick{
    void ButtionClickToMain();
}
    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_main, container, false);
        mainButton1=v.findViewById(R.id.mainButton1);
        mainButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listner.ButtionClickToMain();
            }
        });
        return v;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof ButtonOnClick) {
            listner = (ButtonOnClick) context;
        }else {
            throw new ClassCastException(context.toString()+" Must Implement this Interface");
        }

    }
}
