package ru.samsung.itschool.mdev.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements Fragment1.OnDataFragment1Listener {

    private Button btn1,btn2;
    public static final String KEY = "KEYSTRING";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);
        btn1.setOnClickListener(v -> changeFragment(new Fragment1(getApplicationContext())));
        btn2.setOnClickListener(v -> changeFragment(new Fragment2(getApplicationContext())));

    }
    public void changeFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();

        Bundle bundle = new Bundle();
        bundle.putString(KEY,"Something string!!!");
        fragment.setArguments(bundle);

        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frBody,fragment);
        ft.addToBackStack(null);
        ft.commit();
    }


    @Override
    public void onDataFragment1Sender(String str) {
       Snackbar.make(findViewById(R.id.root),str,Snackbar.LENGTH_LONG).show();
    }
}