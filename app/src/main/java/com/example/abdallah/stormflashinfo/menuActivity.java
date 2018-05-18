package com.example.abdallah.stormflashinfo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;

public class menuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_menu);
    }

    public void choose0(View view) {
        chooseCategory(0);
    }

    public void choose1(View view) {
        chooseCategory(1);
    }

    public void choose2(View view) {
        chooseCategory(2);
    }

    public void choose3(View view) {
        chooseCategory(3);
    }

    public void choose4(View view) {
        chooseCategory(4);
    }

    public void choose5(View view) {
        chooseCategory(5);
    }

    public void choose6(View view) {
        chooseCategory(6);
    }


    public void chooseCategory(int category) {
        Intent intent = new Intent(this, categorieActivity.class);
        intent.putExtra("color",category);
        startActivity(intent);
    }

}