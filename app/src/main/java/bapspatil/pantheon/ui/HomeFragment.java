package bapspatil.pantheon.ui;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import org.aviran.cookiebar2.CookieBar;

import bapspatil.pantheon.R;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * * Created by bapspatil
 */
public class HomeFragment extends Fragment {

    @BindView(R.id.about_app_iv) ImageView aboutAppImageView;
    @BindView(R.id.share_cv) CardView shareCardView;
    @BindView(R.id.location_cv) CardView locationCardView;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);

        shareCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CookieBar.Build(getActivity())
                        .setTitle("Sharing is caring, apparently.")
                        .setMessage("Thanks for sharing our Pantheon app!")
                        .setBackgroundColor(R.color.purple)
                        .setDuration(6000)
                        .show();
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Pantheon 2018");
                String appendedString = "Download the official Pantheon 2018 companion app for the latest updates about the events in Pantheon 2018, brought to you by RNSIT, here:\n";
                appendedString = appendedString + "https://play.google.com/store/apps/details?id=bapspatil.pantheon\n";
                shareIntent.putExtra(Intent.EXTRA_TEXT, appendedString);
                startActivity(Intent.createChooser(shareIntent, "Where do you want to share the Pantheon app?"));
            }
        });

        locationCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CookieBar.Build(getActivity())
                        .setTitle("Still having problems getting to RNSIT?")
                        .setMessage("Just contact any one of our event coordinators, and they'll guide you (they have a good idea of where our college is).")
                        .setBackgroundColor(R.color.purple)
                        .setDuration(6000)
                        .show();
                String location = "https://maps.google.com/maps?q=loc:" + "12.9021902" + "," + "77.518582" + " (RNS Institute of Technology)";
                Intent locationIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(location));
                startActivity(locationIntent);

            }
        });

        aboutAppImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), AboutActivity.class);
                ActivityOptionsCompat options = ActivityOptionsCompat.makeCustomAnimation(getActivity(), android.R.anim.fade_in, android.R.anim.fade_out);
                startActivity(i, options.toBundle());
            }
        });
        return view;
    }

}
