package com.example.LapTimer;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import java.util.ArrayList;

public class TimerActivity extends Activity implements ChallengesFragment.SendMessage {
    /**
     * Called when the activity is first created.
     */

    LTModel model = new LTModel();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);



        model.Challenges.add(new LTChallenge("100m Sprint"));
        model.Challenges.add(new LTChallenge("250m Hurdles"));
        model.Challenges.add(new LTChallenge("50m Backstroke"));





        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

         ChallengesFragment fragmentChallenge = new ChallengesFragment();
         fragmentTransaction.add(R.id.mainframe, fragmentChallenge).commit();





    }


    @Override
    public void sendInt(int pos) {

        TimerFragment tf = (TimerFragment)getFragmentManager().findFragmentById(R.id.timerFrag);
        tf.getMessage(pos);
    }
}
