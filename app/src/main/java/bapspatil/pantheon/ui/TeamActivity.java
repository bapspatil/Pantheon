package bapspatil.pantheon.ui;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

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
    @BindView(R.id.appbar) AppBarLayout appBar;
    @BindView(R.id.collapsing_bar) CollapsingToolbarLayout collapsingToolbar;
    @BindView(R.id.toolbar) Toolbar toolbar;

    private void appBarInit() {
        setSupportActionBar(toolbar);
        collapsingToolbar.setExpandedTitleColor(ContextCompat.getColor(this, android.R.color.white));
        collapsingToolbar.setCollapsedTitleTextColor(ContextCompat.getColor(this, android.R.color.white));
        Typeface typeface = ResourcesCompat.getFont(this, R.font.cabin_medium);
        collapsingToolbar.setCollapsedTitleTypeface(typeface);
        collapsingToolbar.setExpandedTitleTypeface(typeface);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);
        ButterKnife.bind(this);

        appBarInit();

        recyclerViewInit();

        fetchTeam();
    }

    private void recyclerViewInit() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        techTeamRecyclerView.setLayoutManager(layoutManager);

        techTeamAdapter = new TeamRecyclerViewAdapter(this, techTeam);
        techTeamRecyclerView.setAdapter(techTeamAdapter);
    }

    private void fetchTeam() {
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
