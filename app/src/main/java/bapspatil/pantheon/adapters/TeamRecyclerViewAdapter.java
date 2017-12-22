package bapspatil.pantheon.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import bapspatil.pantheon.R;
import bapspatil.pantheon.model.Team;
import bapspatil.pantheon.utils.GlideApp;
import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by bapspatil
 */

public class TeamRecyclerViewAdapter extends RecyclerView.Adapter<TeamRecyclerViewAdapter.TeamViewHolder> {
    private Context mContext;
    private ArrayList<Team> mTeam;

    public TeamRecyclerViewAdapter(Context context, ArrayList<Team> team) {
        this.mContext = context;
        this.mTeam = team;
    }

    @Override
    public TeamViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.rv_team_member, parent, false);
        return new TeamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TeamViewHolder holder, int position) {
        holder.nameTextView.setText(mTeam.get(position).getName());
        GlideApp.with(mContext)
                .load(mTeam.get(position).getAvatar())
                .dontAnimate()
                .placeholder(R.drawable.user_placeholder)
                .error(R.drawable.user_placeholder)
                .fallback(R.drawable.user_placeholder)
                .into(holder.avatarImageView);
    }

    @Override
    public int getItemCount() {
        if(mTeam == null) return 0;
        else return mTeam.size();
    }

    public class TeamViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.avatar_iv) CircleImageView avatarImageView;
        @BindView(R.id.name_tv) TextView nameTextView;

        public TeamViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
