package com.example.pc.timetab;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import java.util.Calendar;


public class AlarmBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        Intent intent1;
        switch (day) {
            case Calendar.MONDAY:
                intent1=new Intent(context,MonActivity.class);
                intent1.setFlags(intent1.FLAG_ACTIVITY_NEW_TASK);
                intent1.putExtra("day","Monday");
                context.startActivity(intent1);
                break;
            case Calendar.TUESDAY:
                intent1=new Intent(context,TueActivity.class);
                intent1.setFlags(intent1.FLAG_ACTIVITY_NEW_TASK);
                intent1.putExtra("day","Tuesday");
                context.startActivity(intent1);
                break;
            case Calendar.WEDNESDAY:
                intent1=new Intent(context,WedActivity.class);
                intent1.setFlags(intent1.FLAG_ACTIVITY_NEW_TASK);
                intent1.putExtra("day","Wednesday");
                context.startActivity(intent1);
                break;
            case Calendar.THURSDAY:
                intent1=new Intent(context,ThuActivity.class);
                intent1.setFlags(intent1.FLAG_ACTIVITY_NEW_TASK);
                intent1.putExtra("day","Thursday");
                context.startActivity(intent1);
                break;
            case Calendar.FRIDAY:
                intent1=new Intent(context,FriActivity.class);
                intent1.setFlags(intent1.FLAG_ACTIVITY_NEW_TASK);
                intent1.putExtra("day","Friday");
                context.startActivity(intent1);
                break;
            case Calendar.SATURDAY:
                intent1=new Intent(context,SatActivity.class);
                intent1.setFlags(intent1.FLAG_ACTIVITY_NEW_TASK);
                intent1.putExtra("day","Saturday");
                context.startActivity(intent1);
                break;
            default:
                break;
        }
    }
}
