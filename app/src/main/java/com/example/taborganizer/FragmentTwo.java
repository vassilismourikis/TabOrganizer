package com.example.taborganizer;

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

public class FragmentTwo extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        System.out.println("ONCREATE");

        return inflater.inflate(R.layout.fragment_two, container, false);

    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final ListView list = view.findViewById(R.id.list);


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this.getContext(),android.R.layout.simple_list_item_1, lists);
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

                                            //Intent intent = new Intent(getActivity(), UsersVideos.class);

                                            //startActivity(intent);
                                        }
                                    });

        Button mButton =view.findViewById(R.id.btn_new);

        mButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View inView) {
                final EditText mEdit =view.findViewById(R.id.search_text2);
                System.out.println(mEdit.getText().toString() + "TAG");
                lists.add(mEdit.getText().toString());


            }
        });


    }
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {

        super.setUserVisibleHint(isVisibleToUser);

        if (isVisibleToUser) {
                FragmentTwo fragment = new FragmentTwo();
                getFragmentManager().beginTransaction().replace(R.id.frag_two, fragment).commit();
        }
    }
}
