package com.example.LapTimer;

/**
 * Created by kimbell on 1/09/2014.
 */
public class LTTime{

    public String comment;
    public String time;


    LTTime(String c, String t){

        comment = c;
        time = t;
    }
    public void setTime(String saveTime){

      time = saveTime;

    }

    public void setComment(String saveComment){

        comment = saveComment;

    }
    public String getTime(){


        return time;
    }
}
