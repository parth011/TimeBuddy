package com.example.pc.timetab;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {
    private String[] days;
    private Context context;

    public HomeAdapter(Context context, String[] days) {
        this.days=days;
        this.context = context;
    }

    @Override
    public  ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_days,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final String day=days[position];
        holder.t1.setText(day);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            Intent intent;
            @Override
            public void onClick(View v) {
                switch (day){
                    case "Monday":

                        intent=new Intent(context,MonActivity.class);
                        intent.putExtra("day","Monday");
                        context.startActivity(intent);
                        break;
                    case "Tuesday":

                        intent=new Intent(context,TueActivity.class);
                        intent.putExtra("day","Tuesday");
                        context.startActivity(intent);
                        break;

                    case "Wednesday":

                        intent=new Intent(context,WedActivity.class);
                        intent.putExtra("day","Wednesday");
                        context.startActivity(intent);
                        break;

                    case "Thursday":

                        intent=new Intent(context,ThuActivity.class);
                        intent.putExtra("day","Thursday");
                        context.startActivity(intent);
                        break;

                    case "Friday":

                        intent=new Intent(context,FriActivity.class);
                        intent.putExtra("day","Friday");
                        context.startActivity(intent);
                        break;

                    case "Saturday":

                        intent=new Intent(context,SatActivity.class);
                        intent.putExtra("day","Saturday");
                        context.startActivity(intent);
                        break;
                    default:
                }
            }
        });
        switch (day){
            case "Monday":
                holder.cardLayout.setBackgroundColor(context.getColor(R.color.colorAccent1));
                break;

            case "Tuesday":
                holder.cardLayout.setBackgroundColor(context.getColor(R.color.colorAccent4));
                break;

            case "Wednesday":
                holder.cardLayout.setBackgroundColor(context.getColor(R.color.colorAccent3));
                break;

            case "Thursday":
                holder.cardLayout.setBackgroundColor(context.getColor(R.color.colorAccent2));
                break;

            case "Friday":
                holder.cardLayout.setBackgroundColor(context.getColor(R.color.colorAccent5));
                break;

            case "Saturday":
                holder.cardLayout.setBackgroundColor(context.getColor(R.color.colorAccent6));
                break;
            default:
                holder.cardLayout.setBackgroundColor(context.getColor(R.color.colorAccent));
        }
    }

    @Override
    public int getItemCount() {
        return days.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView t1;
        ConstraintLayout cardLayout;
        CardView cardView;
        public ViewHolder(View itemView) {
            super(itemView);
            cardView=(CardView)itemView.findViewById(R.id.cardViewDays);
            t1=(TextView)itemView.findViewById(R.id.textViewDay);
            cardLayout=(ConstraintLayout)itemView.findViewById(R.id.card_layout);
        }
    }
}

