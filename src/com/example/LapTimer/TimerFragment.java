package com.example.LapTimer;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Handler;
import org.w3c.dom.Text;

import java.util.Timer;
import java.util.TimerTask;


/**
 * Created by kimbell on 31/08/2014.
 */
public class TimerFragment extends Fragment {

    private TextView timerDisplay;
    private TextView current;
    private TextView best;
    private TextView worst;
    private EditText input;
    private Button startStop;

    static int index = 0;
    long miliSecs = 0L;
    int btCheck = 0;
    long seconds = 0;
    long minutes = 0;

    String bestDisplay = null;
    String worstDisplay = null;
    String AverageDisplay = null;


    Timer time;
    final TimerActivity myactivity = (TimerActivity)getActivity();

    public void onAttach(Activity activity){

        super.onAttach(activity);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.timerlayout, container, false);

        startStop = (Button) rootView.findViewById(R.id.BTstart);
        timerDisplay = (TextView) rootView.findViewById(R.id.timer);
        current = (TextView) rootView.findViewById(R.id.Current);
        best = (TextView) rootView.findViewById(R.id.best);
         worst = (TextView) rootView.findViewById(R.id.worst);

        input = new EditText(getActivity());




        //Dialogue box
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.message)
                .setTitle(R.string.save).setView(input);

        builder.setPositiveButton(R.string.pos, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            // Creates new time object for the challenge and initializes the correct challenge
                  //using the index from Challenge fragment



        // myactivity.model.Challenges.get(index).tTimes.add(new LTTime(input.getText().toString(),
                                                              //              timerDisplay.getText().toString()));
              // getTime();

            }
        });

        builder.setNegativeButton(R.string.neg, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                System.out.println("User clicked discard");
            }
        });

        final AlertDialog alertbox =  builder.create();




        startStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (btCheck == 0) {

                    time = new Timer();
                    time.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            getActivity().runOnUiThread(updateTimer);
                        }
                    },0, 100);
                    timerDisplay.refreshDrawableState();
                    startStop.setText("Stop");
                    btCheck++;

                } else if (btCheck == 1) {

                    time.cancel();

                    alertbox.show();
                     startStop.setText("Reset");
                     current.setText("Current: " + timerDisplay.getText());
                    btCheck++;


                } else if (btCheck == 2) {


                    btCheck = 0;
                    miliSecs = 0;
                    minutes =0;
                    seconds = 0;
                    time.purge();
                    timerDisplay.setText("00:00.0");
                    startStop.setText("Start");

                }
            }
        });



        return rootView;
    }


private Runnable updateTimer = new Runnable() {
    @Override
    public void run() {

        miliSecs++;

        if(miliSecs ==10){

            miliSecs = 0;
            seconds++;

        }
        if(seconds == 60){

            seconds = 0;
            minutes++;
        }

        timerDisplay.setText("" + minutes + ":" + String.format("%02d", seconds) + "."
                    + String.format("%01d", miliSecs));

    }
};


    public float getSeconds(String time){

        String buffer;
        float secs = 0;

        buffer = time.substring(2,6);

        secs = Float.parseFloat(buffer);

        return secs;
    }

    public int getMinutes(String time){

        String buffer;
        int mins;

        buffer = time.substring(0, 1);

        mins = Integer.parseInt(buffer);

        return mins;
    }
    public void getTime(){

   /*     float seconds;
        int mins;


        for(int i = 0; i < myactivity.model.Challenges.get(index).tTimes.size(); i++){

            seconds = getSeconds(myactivity.model.Challenges.get(index).tTimes.get(i).getTime());

            mins =  getMinutes(myactivity.model.Challenges.get(index).tTimes.get(i).getTime());)

            if(> mins){
                best.setText("Best: " + m + ":" + s);


                }else if (m == mins && s > seconds){

                    best.setText("Best: " + m + ":" + s);

                    } else if (m < mins){

                        best.setText("Best: " + mins + ":" + seconds);

                    } else if (m == mins && s < seconds){


            }
        }

  */

    }
        //Gets position on listview which was clicked
    //so challenge data is correct
    public void getMessage(int pos){

        index = pos;

    }


}



