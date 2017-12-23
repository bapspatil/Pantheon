package bapspatil.pantheon.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import bapspatil.pantheon.model.UpdatesResponse;
import butterknife.ButterKnife;

/**
 * Created by bapspatil
 */

public class UpdatesRecyclerViewAdapter extends RecyclerView.Adapter<UpdatesRecyclerViewAdapter.UpdatesViewHolder> {
    private ArrayList<UpdatesResponse> mUpdatesList;
    private Context mContext;

    public UpdatesRecyclerViewAdapter(Context context, ArrayList<UpdatesResponse> updatesList) {
        this.mContext = context;
        this.mUpdatesList = updatesList;
    }

    @Override
    public UpdatesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        return new UpdatesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UpdatesViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        if(mUpdatesList == null) return 0;
        else return mUpdatesList.size();
    }

    public class UpdatesViewHolder extends RecyclerView.ViewHolder {

        public UpdatesViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
