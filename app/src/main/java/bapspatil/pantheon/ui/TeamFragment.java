package bapspatil.pantheon.ui;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wang.avi.AVLoadingIndicatorView;

import org.aviran.cookiebar2.CookieBar;

import java.util.ArrayList;

import bapspatil.pantheon.R;
import bapspatil.pantheon.adapters.TeamRecyclerViewAdapter;
import bapspatil.pantheon.model.Team;
import bapspatil.pantheon.model.TeamResponse;
import bapspatil.pantheon.network.RetrofitAPI;
import bapspatil.pantheon.utils.NetworkUtils;
import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/*
**  Created by bapspatil
*/

public class TeamFragment extends Fragment {

    private ArrayList<Team> techTeam = new ArrayList<>();
    private TeamRecyclerViewAdapter techTeamAdapter;

    @BindView(R.id.tech_team_rv) RecyclerView techTeamRecyclerView;
    @BindView(R.id.appbar) AppBarLayout appBar;
    @BindView(R.id.collapsing_bar) CollapsingToolbarLayout collapsingToolbar;
    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.progress_bar) AVLoadingIndicatorView progressBar;
    @BindView(R.id.nested_sv) NestedScrollView scrollView;

    public TeamFragment() {
        // Required empty public constructor
    }

    private void appBarInit() {
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        collapsingToolbar.setExpandedTitleColor(ContextCompat.getColor(getContext(), android.R.color.white));
        collapsingToolbar.setCollapsedTitleTextColor(ContextCompat.getColor(getContext(), android.R.color.white));
        Typeface typeface = ResourcesCompat.getFont(getContext(), R.font.titillium);
        collapsingToolbar.setCollapsedTitleTypeface(typeface);
        collapsingToolbar.setExpandedTitleTypeface(typeface);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_team, container, false);
        ButterKnife.bind(this, view);
        appBarInit();

        recyclerViewInit();

        fetchTeam();

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    private void recyclerViewInit() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        techTeamRecyclerView.setLayoutManager(layoutManager);

        techTeamAdapter = new TeamRecyclerViewAdapter(getContext(), techTeam);
        ScaleInAnimationAdapter scaleInAnimationAdapter = new ScaleInAnimationAdapter(techTeamAdapter);
        scaleInAnimationAdapter.setDuration(200);
        techTeamRecyclerView.setAdapter(scaleInAnimationAdapter);
    }

    private void fetchTeam() {
        // Making it work offline

        RetrofitAPI retrofitAPI = NetworkUtils.getCacheEnabledRetrofit(getContext()).create(RetrofitAPI.class);
        Call<TeamResponse> teamResponseCall = retrofitAPI.getTeam();
        teamResponseCall.enqueue(new Callback<TeamResponse>() {
            @Override
            public void onResponse(Call<TeamResponse> call, Response<TeamResponse> response) {
                if(response.body() != null) {
                    techTeam.addAll(response.body().getTechTeam());
                    techTeamAdapter.notifyDataSetChanged();
                    progressBar.setVisibility(View.GONE);
                    scrollView.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onFailure(Call<TeamResponse> call, Throwable t) {
                CookieBar.Build(getActivity())
                        .setTitle("Network problem, bruh!")
                        .setMessage("Make sure you're connected to the Internet, and launch the app again.")
                        .setDuration(7000)
                        .show();
                progressBar.setVisibility(View.GONE);
            }
        });
    }
}
