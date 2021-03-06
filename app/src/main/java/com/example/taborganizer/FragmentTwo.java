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

import static com.example.taborganizer.MainActivity.lists;
import static com.example.taborganizer.MainActivity.listsNames;

public class FragmentTwo extends Fragment {

    ArrayAdapter<String> arrayAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_two, container, false);

    }


    @Override
    public void onResume() {
        super.onResume();
        arrayAdapter.notifyDataSetChanged();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final ListView list = view.findViewById(R.id.list);


        arrayAdapter = new ArrayAdapter<String>(this.getContext(),android.R.layout.simple_list_item_1, listsNames);
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
                                            intent.putExtra("listName",listsNames.get(position));
                                            startActivity(intent);
                                        }
                                    });

        Button mButton =view.findViewById(R.id.btn_new);

        mButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View inView) {
                final EditText mEdit =view.findViewById(R.id.name);
                listsNames.add(mEdit.getText().toString());
                lists.put(mEdit.getText().toString(),null);
                arrayAdapter.notifyDataSetChanged();
            }
        });

        Button del =view.findViewById(R.id.del);

        del.setOnClickListener(new View.OnClickListener() {

            public void onClick(View inView) {
                Intent intent = new Intent(getActivity(), DeleteList.class);
                startActivity(intent);

            }
        });


    }

}
