package com.example.LapTimer;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

import java.lang.reflect.Array;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

/**
 * Created by kimbell on 31/08/2014.
 */
public class ChallengesFragment extends Fragment {



    static SendMessage pos;
    private Button newCH;
    private EditText input;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.chanllengelayout, container, false);
        final TimerActivity myactivity = (TimerActivity)getActivity();
        input = new EditText(getActivity());
        newCH = (Button)rootView.findViewById(R.id.btCh);

        //Alert Box setup
       final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Add new Challenge?")
                .setTitle("Max Power").setView(input);

            //Display names of Challenges from LTChallenge array
         final ArrayAdapter<String> adapter = new ArrayAdapter<String>(rootView.getContext(),
                android.R.layout.simple_list_item_1, myactivity.model.getNames());

        ListView list = (ListView)rootView.findViewById(R.id.theList);

        //Button to add new challenges
        builder.setPositiveButton(R.string.pos, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //Get new challenge from user input and add new Challenge to ArrayList
                myactivity.model.Challenges.add(new LTChallenge(input.getText().toString()));
                //For some reason couldnt get new challenges to show in ListView even though they successfully
                //entered arraylist
                adapter.notifyDataSetChanged();

            }
        });

        builder.setNegativeButton(R.string.neg, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                System.out.println("User clicked discard");
            }
        });

        final AlertDialog alertbox =  builder.create();

        //Alert box
        newCH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                alertbox.show();

            }
        });


        list.setAdapter(adapter);

        // Fragment transaction
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {

              //  pos.sendInt(position);
                //Need to figure out how to send position variable to next fragment for indexing challenge
                TimerFragment tf = new TimerFragment();
                final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.mainframe, tf);
                ft.commit();
            }
        });

        return rootView;
    }

       public interface SendMessage{

           public void sendInt(int posi);
       }

 /*   public void onAttach(Activity activity){

        super.onAttach(activity);

        try{

            pos = (SendMessage)activity;
        }catch (ClassCastException e){
            throw new ClassCastException("That failed");
        }
    }*/
}