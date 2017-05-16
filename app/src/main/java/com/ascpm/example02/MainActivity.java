package com.ascpm.example02;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private LinearLayout sideLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();

        switch (itemId) {
            case R.id.sideLayoutShowButton:
                if (this.sideLayout.getVisibility() == View.GONE) {
                    this.sideLayout.setVisibility(View.VISIBLE);
                    item.setTitle(item.getTitle().toString().replace("펼치기", "접기"));
                } else {
                    this.sideLayout.setVisibility(View.GONE);
                    item.setTitle(item.getTitle().toString().replace("접기", "펼치기"));
                }
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void init() {
        this.sideLayout = LinearLayout.class.cast(findViewById(R.id.sideLayout));
    }
}
