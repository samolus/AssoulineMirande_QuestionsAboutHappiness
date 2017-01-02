package com.example.pit_5.assoulinemirande_questionsabouthappiness;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by pit_5 on 14/12/2016.
 */

public class QuizzAdapter extends RecyclerView.Adapter
{
    String[] quizz_list = new String[]{"Love","Friend","Party"};


    Context context;
    public QuizzAdapter(Context context)
    {
        Log.i("samuel", "QuizzAdapter");
        this.context = context;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view1 = LayoutInflater.from(context).inflate(R.layout.cells,parent,false);

        ViewHolder viewHolder1 = new ViewHolder(view1);

        return viewHolder1;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        Log.i("samuel", "ls element " + position + " "  +quizz_list[position] );
        ((ViewHolder)holder).textView.setText(quizz_list[position]);

    }

    @Override
    public int getItemCount() {

        Log.i("samuel", "ls count " +quizz_list.length );
        return quizz_list.length;
    }



    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textView;

        public ViewHolder(View v){

            super(v);

           textView = (TextView)v.findViewById(R.id.textViewCell);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    Intent intent;
                    switch (textView.getText().toString()   ) {
                        case "Love" :
                            intent = new Intent(context, LoveQ.class);
                            Intent g = new Intent(context, myservice.class);
                            context.startService(g);

                            BroadcastReceiver receiver = ((FirstQ)context).getBroadcastReceiverBroadcastReceiver();
                            LocalBroadcastManager.getInstance(context).registerReceiver(receiver, new IntentFilter("assouline"));

                            break;
                        case "Party" :
                            intent = new Intent(context, PartyQ.class);
                            Intent g2 = new Intent(context, myservice.class);
                            context.startService(g2);

                            BroadcastReceiver receiver1 = ((FirstQ)context).getBroadcastReceiverBroadcastReceiver();
                            LocalBroadcastManager.getInstance(context).registerReceiver(receiver1, new IntentFilter("assouline"));
                            break;
                        case "Friend" :
                            intent = new Intent(context, FriendQ.class);
                            Intent g3 = new Intent(context, myservice.class);
                            context.startService(g3);

                            BroadcastReceiver receiver2 = ((FirstQ)context).getBroadcastReceiverBroadcastReceiver();
                            LocalBroadcastManager.getInstance(context).registerReceiver(receiver2, new IntentFilter("assouline"));
                            break;

                        default :
                            return;
                    }
                    context.startActivity(intent);

                }
            });

        }
    }



}
