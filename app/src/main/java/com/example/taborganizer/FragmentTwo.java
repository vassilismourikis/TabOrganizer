package com.example.taborganizer;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import static com.example.taborganizer.MainActivity.lists;
import static com.example.taborganizer.MainActivity.listsNames;

public class FragmentTwo extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_two, container, false);

    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final ListView list = view.findViewById(R.id.list);


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this.getContext(),android.R.layout.simple_list_item_1, listsNames);
        list.setAdapter(arrayAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String clickedItem=(String) list.getItemAtPosition(position);
                Toast.makeText(FragmentTwo.this.getContext(),clickedItem, Toast.LENGTH_SHORT).show();
            }
        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                        @Override
                                        public void onItemClick(AdapterView<?> parent, View view,
                                                                int position, long id) {

                                            Intent intent = new Intent(getActivity(), ListContainer.class);
                                            intent.putStringArrayListExtra("contains",lists.get(listsNames.get(position)));
                                            startActivity(intent);
                                        }
                                    });

        Button mButton =view.findViewById(R.id.btn_new);

        mButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View inView) {
                final EditText mEdit =view.findViewById(R.id.search_text2);
                listsNames.add(mEdit.getText().toString());
                arrayAdapter.notifyDataSetChanged();
            }
        });


    }

}
