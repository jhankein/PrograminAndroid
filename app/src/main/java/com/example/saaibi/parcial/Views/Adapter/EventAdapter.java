package com.example.saaibi.parcial.Views.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.saaibi.parcial.Domain.Event;
import com.example.saaibi.parcial.R;

import java.util.List;

/**
 * Created by SAAIBI on 14/9/2017.
 */

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {

    private List<Event> eventList;
    Context context;


    public EventAdapter(Context context, List<Event> eventList){
        this.context = context;
        this.eventList = eventList;
    }

    @Override
    public EventAdapter.EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = (View) LayoutInflater.from(parent.getContext()).inflate(R.layout.content_user, parent, false);
        EventViewHolder vh = new EventViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(EventAdapter.EventViewHolder holder, int position) {
        holder.txtIdEvent.setText(Integer.toString(eventList.get(position).get_id()));
        holder.txtNameEvent.setText(eventList.get(position).getNameEvent());
        holder.txtTypeEvent.setText(eventList.get(position).getTipeEvent());
        holder.txtDateEvent.setText(eventList.get(position).getDateEvent());
        holder.txtHourEvent.setText(eventList.get(position).getHourEvent());
       //holder.linIdEvent.setText(Integer.toString(eventList.get(position).get_id()));
    }

    @Override
    public int getItemCount() {
        if(eventList!= null){
            return eventList.size();
        }
        return 0;
    }

    class EventViewHolder extends RecyclerView.ViewHolder {
        private TextView
                txtIdEvent,
                txtNameEvent,
                txtTypeEvent,
                txtDateEvent,
                txtHourEvent;
        private LinearLayout linIdEvent;

        public EventViewHolder(View v) {
            super(v);
            linIdEvent = (LinearLayout) v.findViewById(R.id.lin_idEvent);
            txtIdEvent = (TextView) v.findViewById(R.id.txt_idEvent);
            txtNameEvent = (TextView) v.findViewById(R.id.txt_nameEvent);
            txtTypeEvent =(TextView) v.findViewById(R.id.txt_typeEvent);
            txtDateEvent = (TextView) v.findViewById(R.id.txt_dateEvent);
            txtHourEvent = (TextView) v.findViewById(R.id.txt_hourEvent);
        }
    }

}
