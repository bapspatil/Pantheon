package bapspatil.pantheon.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import bapspatil.pantheon.model.Events;

/**
 * Created by bapspatil
 */

public class EventsRecyclerViewAdapter extends RecyclerView.Adapter<EventsRecyclerViewAdapter.EventsViewHolder> {

    private ArrayList<Events> mEventsList;
    private Context mContext;

    public EventsRecyclerViewAdapter(Context context, ArrayList<Events> eventsList) {
        this.mContext = context;
        this.mEventsList = eventsList;
    }

    @Override
    public EventsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        return new EventsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EventsViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        if(mEventsList == null) return 0;
        else return mEventsList.size();
    }

    public class EventsViewHolder extends RecyclerView.ViewHolder {

        public EventsViewHolder(View itemView) {
            super(itemView);
        }
    }
}
