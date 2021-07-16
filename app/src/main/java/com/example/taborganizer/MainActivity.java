package com.example.taborganizer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.viewpager.widget.ViewPager;

import android.Manifest;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;

import com.google.android.material.tabs.TabLayout;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import static android.os.Environment.getExternalStorageDirectory;


public class MainActivity extends AppCompatActivity {
    private final int STORAGE_PERMISSION_CODE = 1;
    ViewPager viewPager;
    public static HashMap<String,ArrayList<String>> lists=new HashMap<String,ArrayList<String>>();
    public static ArrayList<String> listsNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                STORAGE_PERMISSION_CODE);
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                STORAGE_PERMISSION_CODE);

        File file=new File(getFilesDir()+"data.txt");
        HashMap<String, ArrayList<String>> ldapContent = new HashMap<String,ArrayList<String>>();
        if(file.isFile()){

            BufferedReader br = null;

            try {



                // create BufferedReader object from the File
                br = new BufferedReader(new FileReader(file));

                String line = null;

                // read file line by line
                while ((line = br.readLine()) != null) {

                    // split the line by :
                    String[] parts = line.split("#");

                    // first part is key, second is thwe list
                    String name = parts[0].trim();
                    String arr = parts[1];
                    String ar="";
                    ArrayList<String> array = new ArrayList<String>();
                    int j=1;  //starts after the "["
                    while(j<parts[1].length()-1) {
                        ar="";
                        System.out.println(parts[1]);
                        for (int i = j; i < parts[1].length(); i++) {
                            if (parts[1].charAt(i) == ',' || parts[1].charAt(i) == ']'){
                                j=i+1;
                                break;
                            }
                            ar += parts[1].charAt(i);
                            if(i==parts[1].length()-1) j=i+1; //to keep the i before end
                        }
                        if(ar.equals("ull")) continue;  //means it saw a null means no entries
                        array.add(ar);

                    }


                    // put name, number in HashMap if they are
                    // not empty

                        ldapContent.put(name, array);
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            finally {

                // Always close the BufferedReader
                if (br != null) {
                    try {
                        br.close();
                    }
                    catch (Exception e) {
                    };
                }
            }
        }
        lists= ldapContent;
        Set<String> keySet = ldapContent.keySet();

        // Creating an ArrayList of keys
        // by passing the keySet
        ArrayList<String> listOfKeys
                = new ArrayList<String>(keySet);

        listsNames = listOfKeys;
        System.out.println(ldapContent+"EXISTSsssssssssssssssssssssssssssssssssss");
        viewPager = findViewById(R.id.viewPager);

        addTabs(viewPager);
        ((TabLayout) findViewById(R.id.tabLayout)).setupWithViewPager( viewPager );


    }

    @Override
    protected void onStop(){
        super.onStop();

        HashMap<String, ArrayList<String>> ldapContent = lists;
        System.out.println(ldapContent + "BEFORE WRITEEEEEEEEEEEEEE");


        // new file object
        File file = new File(getFilesDir()+"data.txt");

        BufferedWriter bf = null;

        try {

            // create new BufferedWriter for the output file
            bf = new BufferedWriter(new FileWriter(file));

            // iterate map entries
            for (Map.Entry<String, ArrayList<String>> entry :
                    ldapContent.entrySet()) {

                // put key and value separated by a colon
                bf.write(entry.getKey() + "#" //one of 2-3 characters that not being used at urls
                        + entry.getValue());
                System.out.println(entry.getKey() + ":"
                        + entry.getValue() + "       AYTOGRAFTHKEEEEEEEEEEEEEEEEEEEEE");
                // new line
                bf.newLine();
            }

            bf.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {

            try {
                // always close the writer
                bf.close();
            }
            catch (Exception e) {
            }
        }
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();

        HashMap<String, ArrayList<String>> ldapContent = lists;
        System.out.println(ldapContent + "BEFORE WRITEEEEEEEEEEEEEE");


        // new file object
        File file = new File(getFilesDir()+"data.txt");

        BufferedWriter bf = null;

        try {

            // create new BufferedWriter for the output file
            bf = new BufferedWriter(new FileWriter(file));

            // iterate map entries
            for (Map.Entry<String, ArrayList<String>> entry :
                    ldapContent.entrySet()) {

                // put key and value separated by a colon
                bf.write(entry.getKey() + "#"//one of 2-3 characters that not being used at urls
                        + entry.getValue());

                // new line
                bf.newLine();
            }

            bf.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {

            try {
                // always close the writer
                bf.close();
            }
            catch (Exception e) {
            }
        }
    }




    private void addTabs(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new FragmentOne(), "kithara.to");
        adapter.addFrag(new FragmentTwo(), "lists");
        viewPager.setAdapter(adapter);
    }
}