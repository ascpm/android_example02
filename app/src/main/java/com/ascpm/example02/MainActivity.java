package com.ascpm.example02;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private Button menuButton;

    private WebView webView;

    private LinearLayout sideLayout;
    private Button sideButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        event();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        View actionView = menu.findItem(R.id.menuMain).getActionView();

        if (actionView != null) {
            this.menuButton = Button.class.cast(actionView.findViewById(R.id.menuButton));
            this.menuButton.setOnClickListener(v -> this.setSideLayoutVisibility());
        }

        return true;
    }

    private void init() {
        getSupportActionBar().setTitle("");
        this.webView = WebView.class.cast(findViewById(R.id.webView));
        this.webView.getSettings().setJavaScriptEnabled(true);
        // this.webView.setWebChromeClient(new WebChromeClient());
        this.webView.setWebViewClient(new WebViewClient());

        this.sideLayout = LinearLayout.class.cast(findViewById(R.id.sideLayout));
        this.sideButton = Button.class.cast(findViewById(R.id.sideButton));
    }

    private void event() {
        this.sideButton.setOnClickListener(v -> {
            this.webView.loadUrl("https://www.kakaofriends.com");
            this.setSideLayoutVisibility();
        });
    }

    private void setSideLayoutVisibility() {
        if (this.sideLayout.getVisibility() == View.GONE) {
            this.sideLayout.setVisibility(View.VISIBLE);
            this.menuButton.setText(R.string.menu_button_off_text);
        } else {
            this.sideLayout.setVisibility(View.GONE);
            this.menuButton.setText(R.string.menu_button_on_text);
        }
    }
}
