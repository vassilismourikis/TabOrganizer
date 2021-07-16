package com.example.taborganizer;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import static com.example.taborganizer.MainActivity.lists;

public class Song extends AppCompatActivity {

    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);

        Bundle b = getIntent().getExtras();

        String listName=b.getString("listName");
        String link = b.getString("link");

        webView = (WebView) findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(link);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        final Button button = findViewById(R.id.del_song);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ArrayList<String> r=lists.get(listName);
                r.remove(link);
                lists.remove(listName);
                lists.put(listName,r);

            }
        });

    }


}
