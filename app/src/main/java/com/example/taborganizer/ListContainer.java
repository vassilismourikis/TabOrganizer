package com.example.taborganizer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import static com.example.taborganizer.MainActivity.lists;
import static com.example.taborganizer.MainActivity.listsNames;
import static com.example.taborganizer.MainActivity.names;

public class ListContainer extends AppCompatActivity{
    ArrayList<String> links;
    String key;
    ArrayAdapter<String> arrayAdapter;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_selecter);

            Bundle b = getIntent().getExtras();
            String listname=b.getString("listName");

            if(links==null) links= lists.get(listname);//arraylist
            // Inflate the layout for this fragment
            final ListView list =findViewById(R.id.list);
            ArrayList<String> arrayList = names.get(listname);
            if(names.get(listname)==null) //in case list is empty we need to create an object otherwise the app will freeze
                arrayList=new ArrayList<String>();
            arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, arrayList);
            list.setAdapter(arrayAdapter);

            ArrayList<String> finalArrayList = arrayList;
            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                            @Override
                                            public void onItemClick(AdapterView<?> parent, View view,
                                                                    int position, long id) {
                                                Intent intent = new Intent(getApplication(), Song.class);
                                                intent.putExtra("listName",listname);
                                                intent.putExtra("name", finalArrayList.get(position));
                                                intent.putExtra("link",links.get(position));
                                                startActivity(intent);
                                            }
                                        }
            );

            final Button button = findViewById(R.id.button);
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    finish();
                }
            });

        }

    @Override
    protected void onResume() {
        super.onResume();
        arrayAdapter.notifyDataSetChanged();
    }


    }

