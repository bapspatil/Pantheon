package bapspatil.pantheon.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wang.avi.AVLoadingIndicatorView;

import org.aviran.cookiebar2.CookieBar;

import java.util.ArrayList;

import bapspatil.pantheon.R;
import bapspatil.pantheon.adapters.EventsRecyclerViewAdapter;
import bapspatil.pantheon.model.Events;
import bapspatil.pantheon.model.EventsResponse;
import bapspatil.pantheon.network.RetrofitAPI;
import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by bapspatil
 */

public class DayFragment extends Fragment {
    @BindView(R.id.events_rv) RecyclerView eventsRecyclerView;
    @BindView(R.id.progress_bar) AVLoadingIndicatorView progressBar;

    private static final String DAY = "day";
    private ArrayList<Events> eventsList = new ArrayList<>();
    private EventsRecyclerViewAdapter eventsAdapter;

    public DayFragment() {
        // Required empty public constructor
    }

    public static DayFragment newInstance(int day) {
        DayFragment fragment = new DayFragment();
        Bundle args = new Bundle();
        args.putInt(DAY, day);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_day, container, false);
        ButterKnife.bind(this, view);

        recyclerViewInit();

        if (getArguments() != null) {
            int dayNumber = getArguments().getInt(DAY);
            fetchDayEvents(dayNumber);
        }

        return view;
    }

    private void recyclerViewInit() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        eventsRecyclerView.setLayoutManager(layoutManager);

        eventsAdapter = new EventsRecyclerViewAdapter(getContext(), eventsList);
        AlphaInAnimationAdapter alphaInAnimationAdapter = new AlphaInAnimationAdapter(eventsAdapter);
        eventsRecyclerView.setAdapter(alphaInAnimationAdapter);
    }

    private void fetchDayEvents(int dayNumber) {
        RetrofitAPI retrofitAPI = RetrofitAPI.retrofit.create(RetrofitAPI.class);
        Call<EventsResponse> eventsResponseCall = retrofitAPI.getEvents();
        if(dayNumber == 0) {
            eventsResponseCall.enqueue(new Callback<EventsResponse>() {
                @Override
                public void onResponse(Call<EventsResponse> call, Response<EventsResponse> response) {
                    eventsList.addAll(response.body().getDayOneEvents());
                    eventsAdapter.notifyDataSetChanged();
                    progressBar.setVisibility(View.GONE);
                    eventsRecyclerView.setVisibility(View.VISIBLE);
                }

                @Override
                public void onFailure(Call<EventsResponse> call, Throwable t) {
                    CookieBar.Build(getActivity())
                            .setTitle("Network problem, bruh!")
                            .setMessage("Make sure you're connected to the Internet, and launch the app again.")
                            .setDuration(7000)
                            .show();
                    progressBar.setVisibility(View.GONE);
                }
            });
        } else {
            eventsResponseCall.enqueue(new Callback<EventsResponse>() {
                @Override
                public void onResponse(Call<EventsResponse> call, Response<EventsResponse> response) {
                    eventsList.addAll(response.body().getDayTwoEvents());
                    eventsAdapter.notifyDataSetChanged();
                    progressBar.setVisibility(View.GONE);
                    eventsRecyclerView.setVisibility(View.VISIBLE);
                }

                @Override
                public void onFailure(Call<EventsResponse> call, Throwable t) {
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

}
