package com.example.LapTimer;

import java.util.ArrayList;

/**
 * Created by kimbell on 1/09/2014.
 */
public class LTModel {

    ArrayList<LTChallenge> Challenges;

    LTModel(){

        Challenges = new ArrayList<LTChallenge>();
    }

    public String [] getNames(){

        String [] array = new String[Challenges.size()];

        for(int i = 0; i < Challenges.size(); i++)
        {

           array[i] = Challenges.get(i).populate();

        }

        return array;
    }






}
