package bapspatil.pantheon.ui;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
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
import bapspatil.pantheon.adapters.UpdatesRecyclerViewAdapter;
import bapspatil.pantheon.model.UpdatesResponse;
import bapspatil.pantheon.network.RetrofitAPI;
import bapspatil.pantheon.utils.NetworkUtils;
import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by bapspatil
 */
public class UpdatesFragment extends Fragment {
    @BindView(R.id.appbar) AppBarLayout appBar;
    @BindView(R.id.collapsing_bar) CollapsingToolbarLayout collapsingToolbar;
    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.updates_rv) RecyclerView updatesRecyclerView;
    @BindView(R.id.progress_bar) AVLoadingIndicatorView progressBar;

    private ArrayList<UpdatesResponse> updatesList = new ArrayList<>();
    private UpdatesRecyclerViewAdapter updatesAdapter;

    public UpdatesFragment() {
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
        View view = inflater.inflate(R.layout.fragment_updates, container, false);
        ButterKnife.bind(this, view);
        appBarInit();

        recyclerViewInit();

        fetchUpdates();

        return view;
    }

    private void recyclerViewInit() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        updatesRecyclerView.setLayoutManager(layoutManager);

        updatesAdapter = new UpdatesRecyclerViewAdapter(getContext(), updatesList);
        AlphaInAnimationAdapter alphaInAnimationAdapter = new AlphaInAnimationAdapter(updatesAdapter);
        updatesRecyclerView.setAdapter(alphaInAnimationAdapter);
    }

    private void fetchUpdates() {
        RetrofitAPI retrofitAPI = NetworkUtils.getCacheEnabledRetrofit(getContext()).create(RetrofitAPI.class);
        Call<ArrayList<UpdatesResponse>> updatesResponseCall = retrofitAPI.getUpdates();
        updatesResponseCall.enqueue(new Callback<ArrayList<UpdatesResponse>>() {
            @Override
            public void onResponse(Call<ArrayList<UpdatesResponse>> call, Response<ArrayList<UpdatesResponse>> response) {
                if(response.body() != null) {
                    updatesList.addAll(response.body());
                    updatesAdapter.notifyDataSetChanged();
                    progressBar.setVisibility(View.GONE);
                    updatesRecyclerView.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<UpdatesResponse>> call, Throwable t) {
                CookieBar.build(getActivity())
                        .setTitle("Network problem, bruh!")
                        .setMessage("Make sure you're connected to the Internet, and launch the app again.")
                        .setDuration(7000)
                        .show();
                progressBar.setVisibility(View.GONE);
            }
        });
    }

}
