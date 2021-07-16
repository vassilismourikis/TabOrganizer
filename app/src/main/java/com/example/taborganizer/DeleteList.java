package com.example.taborganizer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.taborganizer.MainActivity.lists;
import static com.example.taborganizer.MainActivity.listsNames;

public class DeleteList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_list);

        // Inflate the layout for this fragment
        final ListView list = findViewById(R.id.list);


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplication(),android.R.layout.simple_list_item_1, listsNames);
        list.setAdapter(arrayAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String clickedItem=(String) list.getItemAtPosition(position);
                Toast.makeText(getApplication(),clickedItem, Toast.LENGTH_SHORT).show();
            }
        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                lists.remove(listsNames.get(position));
                listsNames.remove(position);
                arrayAdapter.notifyDataSetChanged();
            }
        });


    }
}
