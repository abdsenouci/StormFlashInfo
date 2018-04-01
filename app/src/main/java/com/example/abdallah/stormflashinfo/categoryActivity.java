package com.example.abdallah.stormflashinfo;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class categoryActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

       /*
        TabHost host = findViewById(R.id.tabhost);
        host.setup();
*/

/*
        //Tab 1
        TabHost.TabSpec spec = host.newTabSpec("Tab One");
        spec.setContent(R.id.Bonsplan);
        spec.setIndicator("Tab One");
        host.addTab(spec);

        //Tab 2
        TabHost.TabSpec spec1 = host.newTabSpec("Tab Two");
        spec1.setContent(R.id.Lieux);
        spec1.setIndicator("Tab Two");
        host.addTab(spec1);
*/
        Intent intent = getIntent();
        int colorCode = intent.getIntExtra("color",-1);

        int[] colors = getColors(colorCode);
        initColors(colors);
    }

    public void initColors(int[] colors){

        //AppBarLayout appBar = findViewById(R.id.appbar);
        //Toolbar toolbar = findViewById(R.id.toolbar);
        //toolbar.setBackgroundColor(colors[0]);
        //appBar.setBackgroundColor((colors[0]));
        /*
        TabWidget tabwidget = findViewById(R.id.tabWidget);
        tabwidget.getChildTabViewAt(0).setBackgroundColor(0);
        TextView textView = findViewById(R.id.textView29);
        textView.setBackgroundColor(getResources().getColor(R.color.category0));
        textView.setText(colors[0]);
        TextView textView1 = findViewById(R.id.textView30);
        textView1.setBackgroundColor(colors[1]);
        textView1.setText(colors[1]);
        TextView textView2 = findViewById(R.id.textView31);
        textView2.setBackgroundColor(colors[2]);
        textView2.setText(colors[2]);
*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_category, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public int[] getColors(int colorCode) {
        int[] colors = new int[3];
        switch (colorCode) {
            case 0:
                colors[0] = ContextCompat.getColor(this,R.color.category0);
                colors[1] = ContextCompat.getColor(this,R.color.category0Off);
                colors[2] = ContextCompat.getColor(this,R.color.category0Btn);
                break;
            case 1:
                colors[0] = ContextCompat.getColor(this,R.color.category1);
                colors[1] = ContextCompat.getColor(this,R.color.category1Off);
                colors[2] = ContextCompat.getColor(this,R.color.category1Btn);
                break;
            case 2:
                colors[0] = ContextCompat.getColor(this,R.color.category2);
                colors[1] = ContextCompat.getColor(this,R.color.category2Off);
                colors[2] = ContextCompat.getColor(this,R.color.category2Btn);
                break;
            case 3:
                colors[0] = ContextCompat.getColor(this,R.color.category3);
                colors[1] = ContextCompat.getColor(this,R.color.category3Off);
                colors[2] = ContextCompat.getColor(this,R.color.category3Btn);
                break;
            case 4:
                colors[0] = ContextCompat.getColor(this,R.color.category4);
                colors[1] = ContextCompat.getColor(this,R.color.category4Off);
                colors[2] = ContextCompat.getColor(this,R.color.category4Btn);
                break;
            case 5:
                colors[0] = ContextCompat.getColor(this,R.color.category5);
                colors[1] = ContextCompat.getColor(this,R.color.category5Off);
                colors[2] = ContextCompat.getColor(this,R.color.category5Btn);
                break;
            case 6:
                colors[0] = ContextCompat.getColor(this,R.color.category6);
                colors[1] = ContextCompat.getColor(this,R.color.category6Off);
                colors[2] = ContextCompat.getColor(this,R.color.category6Btn);
                break;
            default:
                colors[0] = ContextCompat.getColor(this,R.color.colorPrimary);
                colors[1] = ContextCompat.getColor(this,R.color.colorPrimaryDark);
                colors[2] = ContextCompat.getColor(this,R.color.colorAccent);
                break;
        }
        return colors;
    }
}