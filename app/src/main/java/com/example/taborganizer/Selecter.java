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

public class Selecter extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecter);

        Bundle b = getIntent().getExtras();


        String link =  b.getString("link");
        String name =  b.getString("name");

        // Inflate the layout for this fragment
        final ListView list =findViewById(R.id.list);
        ArrayList<String> arrayList = listsNames;
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, arrayList);
        list.setAdapter(arrayAdapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                        @Override
                                        public void onItemClick(AdapterView<?> parent, View view,
                                                                int position, long id) {
                                            //FOR LINKS---------------------------------------------
                                            ArrayList<String> ar= lists.get(listsNames.get(position));
                                            if(ar==null){
                                                ar=new ArrayList<String>();
                                                ar.add(link);
                                            }
                                            else ar.add(link);
                                            lists.put(listsNames.get(position),ar);
                                            //FOR LINKS---------------------------------------------

                                            //FOR Names------------------------------------------------
                                            ar= names.get(listsNames.get(position));
                                            if(ar==null){
                                                ar=new ArrayList<String>();
                                                ar.add(name);
                                            }
                                            else ar.add(name);
                                            names.put(listsNames.get(position),ar);
                                            //FOR Names------------------------------------------------
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
