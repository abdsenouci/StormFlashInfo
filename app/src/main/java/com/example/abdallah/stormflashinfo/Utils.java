package com.example.abdallah.stormflashinfo;

import android.content.Context;
import android.support.v4.content.ContextCompat;

public class Utils {
    public static int[] getColors(Context context, int colorCode) {
        int[] colors = new int[3];
        switch (colorCode) {
            case 0:
                colors[0] = ContextCompat.getColor(context,R.color.category0);
                colors[1] = ContextCompat.getColor(context,R.color.category0Off);
                colors[2] = ContextCompat.getColor(context,R.color.category0Btn);
                break;
            case 1:
                colors[0] = ContextCompat.getColor(context,R.color.category1);
                colors[1] = ContextCompat.getColor(context,R.color.category1Off);
                colors[2] = ContextCompat.getColor(context,R.color.category1Btn);
                break;
            case 2:
                colors[0] = ContextCompat.getColor(context,R.color.category2);
                colors[1] = ContextCompat.getColor(context,R.color.category2Off);
                colors[2] = ContextCompat.getColor(context,R.color.category2Btn);
                break;
            case 3:
                colors[0] = ContextCompat.getColor(context,R.color.category3);
                colors[1] = ContextCompat.getColor(context,R.color.category3Off);
                colors[2] = ContextCompat.getColor(context,R.color.category3Btn);
                break;
            case 4:
                colors[0] = ContextCompat.getColor(context,R.color.category4);
                colors[1] = ContextCompat.getColor(context,R.color.category4Off);
                colors[2] = ContextCompat.getColor(context,R.color.category4Btn);
                break;
            case 5:
                colors[0] = ContextCompat.getColor(context,R.color.category5);
                colors[1] = ContextCompat.getColor(context,R.color.category5Off);
                colors[2] = ContextCompat.getColor(context,R.color.category5Btn);
                break;
            case 6:
                colors[0] = ContextCompat.getColor(context,R.color.category6);
                colors[1] = ContextCompat.getColor(context,R.color.category6Off);
                colors[2] = ContextCompat.getColor(context,R.color.category6Btn);
                break;
            default:
                colors[0] = ContextCompat.getColor(context,R.color.colorPrimary);
                colors[1] = ContextCompat.getColor(context,R.color.colorPrimaryDark);
                colors[2] = ContextCompat.getColor(context,R.color.colorAccent);
                break;
        }
        return colors;
    }
}
