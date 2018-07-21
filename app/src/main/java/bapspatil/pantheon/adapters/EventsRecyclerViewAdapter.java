package bapspatil.pantheon.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import bapspatil.pantheon.R;
import bapspatil.pantheon.model.Event;
import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by bapspatil
 */

public class EventsRecyclerViewAdapter extends RecyclerView.Adapter<EventsRecyclerViewAdapter.EventsViewHolder> {
    private ArrayList<Event> mEventsList;
    private Context mContext;

    public EventsRecyclerViewAdapter(Context context, ArrayList<Event> eventsList) {
        this.mContext = context;
        this.mEventsList = eventsList;
    }

    @Override
    public EventsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.rv_events_item, parent, false);
        return new EventsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EventsViewHolder holder, int position) {
        holder.mTimeTextView.setText(mEventsList.get(position).getTime());
        holder.mTitleTextView.setText(mEventsList.get(position).getTitle());
        holder.mBodyTextView.setText(mEventsList.get(position).getBody());
        holder.mLocationTextView.setText(mEventsList.get(position).getLocation());
        holder.mMembersTextView.setText(mEventsList.get(position).getMaxMembers());
        // To call the coordinator of the event
        final int i = position;
        holder.mCallImageView.setOnClickListener(view -> {
            Intent callIntent = new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse("tel:" + mEventsList.get(i).getContact()));
            mContext.startActivity(callIntent);
        });
    }

    @Override
    public int getItemCount() {
        if(mEventsList == null) return 0;
        else return mEventsList.size();
    }

    public class EventsViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.time_tv) TextView mTimeTextView;
        @BindView(R.id.title_tv) TextView mTitleTextView;
        @BindView(R.id.body_tv) TextView mBodyTextView;
        @BindView(R.id.location_tv) TextView mLocationTextView;
        @BindView(R.id.members_tv) TextView mMembersTextView;
        @BindView(R.id.call_iv) CircleImageView mCallImageView;

        public EventsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
