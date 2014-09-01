package com.example.LapTimer;

import java.util.ArrayList;

/**
 * Created by kimbell on 1/09/2014.
 */
public class LTChallenge {

        String name;

        ArrayList<LTTime> tTimes;


    LTChallenge(String s){

        name = s;

    }

    LTChallenge(){

        tTimes = new ArrayList<LTTime>();
    }
    public String [] getTimes(String n){

          String [] array = new String[tTimes.size()];

         for(int i = 0; i < tTimes.size();i++){

             array[i] = tTimes.get(i).getTime();

         }
            return array;
        }


    
    public String populate(){

        return name;
            
        }

}
