package Functionality;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class RentTimer {
    boolean rentOver;

    public boolean setTheTimer(int rentPeriod) {
        Timer timer = new Timer();

        TimerTask countTime = new TimerTask() {
            int seconds = rentPeriod;
            @Override
            public void run() {
                if(seconds >= 0){
                    rentOver = false;
                    System.out.println(seconds);
                    seconds--;
                }else{
                    rentOver = true;
                    System.out.println("movie rent is over");
                    timer.cancel();
                }
            }
        };

        Calendar date = Calendar.getInstance();
        //  date.setTime();
        //date.se
        timer.scheduleAtFixedRate(countTime, date.getTime(), rentPeriod * 1000);
        return rentOver;
    }
}
