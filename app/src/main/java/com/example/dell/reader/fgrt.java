package com.example.dell.reader;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

/**
 * Created by dell on 5/24/2016.
 */
public class fgrt extends ListFragment {
    Intent intent;
    String[] players={"ALL black","Afghan jalebi","Bapu zimidar"};
    ArrayAdapter<String> adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        adapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,players);
        setListAdapter(adapter);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:
                        intent = new Intent(getActivity().getApplicationContext(),activity1.class);
                        break;
                    case 1:
                        intent = new Intent(getActivity().getApplicationContext(),activity3.class);

                        break;
                    case 2:
                        intent = new Intent(getActivity().getApplicationContext(),activity2.class);

                        break;
                                    }
                startActivity(intent);
            }


        });
    }
}