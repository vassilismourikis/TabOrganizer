package com.example.taborganizer;

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

public class ListContainer extends AppCompatActivity{

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_selecter);

            Bundle b = getIntent().getExtras();


            ArrayList<String> links =  b.getStringArrayList("contains");
            if(links==null) links= new ArrayList<String>();
            // Inflate the layout for this fragment
            final ListView list =findViewById(R.id.list);
            ArrayList<String> arrayList = links;
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, arrayList);
            list.setAdapter(arrayAdapter);

            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                            @Override
                                            public void onItemClick(AdapterView<?> parent, View view,
                                                                    int position, long id) {

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


    }

