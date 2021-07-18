package com.example.taborganizer;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.HashMap;


public class FragmentOne extends Fragment {

    private WebView webView;

    public FragmentOne() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_one, container, false);

        webView = (WebView) view.findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.kithara.to");

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        final Button button = view.findViewById(R.id.add);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //TODO:open other fragment/activity to choose ore create new list for the song
                Intent intent = new Intent(getActivity(), Selecter.class);
                intent.putExtra("link",webView.getUrl());
                final EditText mEdit =view.findViewById(R.id.song_name);
                System.out.println(mEdit.getText().toString());
                intent.putExtra("name",mEdit.getText().toString());
                startActivity(intent);
            }
        });
        // Inflate the layout for this fragment
        return view;
    }

}
