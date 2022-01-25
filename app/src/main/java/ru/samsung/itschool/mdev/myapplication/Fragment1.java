package ru.samsung.itschool.mdev.myapplication;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class Fragment1 extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    private Context context;
    private Button btn3;
    private OnDataFragment1Listener listener; // null

    public Fragment1(Context c) {
        this.context = c;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof OnDataFragment1Listener) {
            listener = (OnDataFragment1Listener) context;
        } else {
            try {
                throw new Exception("Все плохо!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(MainActivity.KEY);
            Toast.makeText(context,mParam1,Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1, container, false);

        btn3 = view.findViewById(R.id.button3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onDataFragment1Sender("From fragment to Activity!");
            }
        });
        return view;
    }

    public interface OnDataFragment1Listener {
        void onDataFragment1Sender(String str);
    }
}