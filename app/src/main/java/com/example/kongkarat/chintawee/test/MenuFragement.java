package com.example.kongkarat.chintawee.test;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MenuFragement extends Fragment {

    ArrayList<String> _menu = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_menu,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        _menu.add("Add");
        _menu.add("View");
        _menu.add("Theme");
        _menu.add("LoadImage");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1,_menu);
        ListView listview = getView().findViewById(R.id.menu_fragent);
        listview.setAdapter(adapter);//ใส่อแดบเตอร์ที่เป็นอเร

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(_menu.get(position).equals("Add")){
                    Log.d("Menu","go to add");
//                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_page,/*new AddFragent()*/).addToBackStack(null).commit();
                }
                else if (_menu.get(position).equals("View")){
                    Log.d("MENU", "go to view");
                    //getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_page,new /*new ViewFragent()*/).addToBackStack(null).commit();
                }
                else if (_menu.get(position).equals("Theme")){
                    Log.d("MENU", "go to theme");
                    //getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_page,new /*new ViewFragent()*/).addToBackStack(null).commit();
                }
                else if (_menu.get(position).equals("LoadImage")){
                    Log.d("MENU", "go to loadImmage");
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_page,new ImageFragmment()).addToBackStack(null).commit();
                    _menu.clear();
                }

            }
        });


    }

}
