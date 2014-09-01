package com.example.LapTimer;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.List;
import java.util.Map;

/**
 * Created by kimbell on 31/08/2014.
 */
public class RecordsFragment extends Fragment {

    private List<Map<String,String>> data;
    private ListView listview;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.recordlay, container, false);
        final TimerActivity myactivity = (TimerActivity)getActivity();

        listview = (ListView)rootView.findViewById(R.id.recordList);

        //SimpleAdapter adapter = new SimpleAdapter(this, data, android.R.layout.simple_list_item_1, new


        return inflater.inflate(R.layout.recordlay, container, false);



    }
}