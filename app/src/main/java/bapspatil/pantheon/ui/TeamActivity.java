package bapspatil.pantheon.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.aviran.cookiebar2.CookieBar;

import java.util.ArrayList;

import bapspatil.pantheon.R;
import bapspatil.pantheon.adapters.TeamRecyclerViewAdapter;
import bapspatil.pantheon.model.Team;
import bapspatil.pantheon.model.TeamResponse;
import bapspatil.pantheon.network.RetrofitAPI;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeamActivity extends AppCompatActivity {

    private ArrayList<Team> techTeam = new ArrayList<>();
    private TeamRecyclerViewAdapter techTeamAdapter;

    @BindView(R.id.tech_team_rv) RecyclerView techTeamRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);
        ButterKnife.bind(this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        techTeamRecyclerView.setLayoutManager(layoutManager);

        techTeamAdapter = new TeamRecyclerViewAdapter(this, techTeam);
        techTeamRecyclerView.setAdapter(techTeamAdapter);

        RetrofitAPI retrofitAPI = RetrofitAPI.retrofit.create(RetrofitAPI.class);
        Call<TeamResponse> teamResponseCall = retrofitAPI.getTeam();
        teamResponseCall.enqueue(new Callback<TeamResponse>() {
            @Override
            public void onResponse(Call<TeamResponse> call, Response<TeamResponse> response) {
                techTeam.addAll(response.body().getTechTeam());
                techTeamAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<TeamResponse> call, Throwable t) {
                CookieBar.Build(TeamActivity.this)
                        .setTitle("Error in fetching data")
                        .show();
            }
        });
    }
}
