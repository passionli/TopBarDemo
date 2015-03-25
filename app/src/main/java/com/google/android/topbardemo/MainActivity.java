package com.google.android.topbardemo;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    private TopBar mTopBar;
    private TopBar mBottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayUseLogoEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);

        View view = getLayoutInflater().inflate(R.layout.action_bar, null);
        actionBar.setCustomView(view);
        actionBar.setDisplayOptions(0, ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setDisplayShowCustomEnabled(true);

        mTopBar = (TopBar) view;
        mTopBar.setOnClickListener(new TopBar.OnClickListener() {
            @Override
            public void onLeftClick(View view) {
                Toast.makeText(MainActivity.this, "Click Left", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onMiddleClick(View view) {
                Toast.makeText(MainActivity.this, "Click Middle", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRightClick(View view) {
                Toast.makeText(MainActivity.this, "Click Right", Toast.LENGTH_SHORT).show();
            }
        });
        mTopBar.setVisibility(TopBar.TOP_BAR_POSITION.LEFT, View.GONE);

        mBottomBar = (TopBar) findViewById(R.id.bottomBar);
        mBottomBar.setOnClickListener(new TopBar.OnClickListener() {
            @Override
            public void onLeftClick(View view) {
                Toast.makeText(MainActivity.this, "Click Bottom Left", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onMiddleClick(View view) {
                Toast.makeText(MainActivity.this, "Click Bottom Middle", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRightClick(View view) {
                Toast.makeText(MainActivity.this, "Click Bottom Right", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
