package com.example.abdallah.stormflashinfo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class menuActivity extends AppCompatActivity {
    protected static int colorCode;

    public static int getColorCode() {
        return colorCode;
    }

    public static void setColorCode(int colorCode) {
        menuActivity.colorCode = colorCode;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_menu);
    }

    public void choose0(View view) {
        setColorCode(0);
        chooseCategory(view, 0);
    }

    public void choose1(View view) {
        setColorCode(1);
        chooseCategory(view, 1);
    }

    public void choose2(View view) {
        setColorCode(2);
        chooseCategory(view, 2);
    }

    public void choose3(View view) {
        setColorCode(3);
        chooseCategory(view, 3);
    }

    public void choose4(View view) {
        setColorCode(4);
        chooseCategory(view, 4);
    }

    public void choose5(View view) {
        setColorCode(5);
        chooseCategory(view, 5);
    }

    public void choose6(View view) {
        setColorCode(6);
        chooseCategory(view, 6);
    }

    public void chooseCategory(View view, int category) {
        Intent intent = new Intent(this, categoryActivity.class);
        startActivity(intent);
    }

    public static int[] getColors() {
        int[] colors = new int[3];
        switch (colorCode) {
            case 0:
                colors[0] = R.color.category0;
                colors[1] = R.color.category0Off;
                colors[2] = R.color.category0Btn;
                break;
            case 1:
                colors[0] = R.color.category1;
                colors[1] = R.color.category1Off;
                colors[2] = R.color.category1Btn;
                break;
            case 2:
                colors[0] = R.color.category2;
                colors[1] = R.color.category2Off;
                colors[2] = R.color.category2Btn;
                break;
            case 3:
                colors[0] = R.color.category3;
                colors[1] = R.color.category3Off;
                colors[2] = R.color.category3Btn;
                break;
            case 4:
                colors[0] = R.color.category4;
                colors[1] = R.color.category4Off;
                colors[2] = R.color.category4Btn;
                break;
            case 5:
                colors[0] = R.color.category5;
                colors[1] = R.color.category5Off;
                colors[2] = R.color.category5Btn;
                break;
            case 6:
                colors[0] = R.color.category6;
                colors[1] = R.color.category6Off;
                colors[2] = R.color.category6Btn;
                break;
            default:
                colors[0] = R.color.colorPrimary;
                colors[1] = R.color.colorPrimaryDark;
                colors[2] = R.color.colorAccent;
                break;
        }
        return colors;
    }
}