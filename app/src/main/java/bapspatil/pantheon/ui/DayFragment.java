package bapspatil.pantheon.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import bapspatil.pantheon.R;
import bapspatil.pantheon.adapters.EventsRecyclerViewAdapter;
import bapspatil.pantheon.model.Events;
import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;

/**
 * Created by bapspatil
 */

public class DayFragment extends Fragment {

    private static final String DAY = "day";
    private int dayNumber;
    private ArrayList<Events> eventsList = new ArrayList<>();
    private EventsRecyclerViewAdapter eventsAdapter;

    @BindView(R.id.events_rv) RecyclerView eventsRecyclerView;

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
            dayNumber = getArguments().getInt(DAY);
            fetchDayEvents();
        }

        return view;
    }

    private void recyclerViewInit() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        eventsRecyclerView.setLayoutManager(layoutManager);

        eventsAdapter = new EventsRecyclerViewAdapter(getContext(), eventsList);
        ScaleInAnimationAdapter scaleInAnimationAdapter = new ScaleInAnimationAdapter(eventsAdapter);
        scaleInAnimationAdapter.setDuration(200);
        eventsRecyclerView.setAdapter(scaleInAnimationAdapter);
    }

    private void fetchDayEvents() {
        if (dayNumber == 0) {

        } else {

        }
    }

}
