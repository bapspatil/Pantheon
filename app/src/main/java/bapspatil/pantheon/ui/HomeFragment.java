package bapspatil.pantheon.ui;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.core.app.ActivityOptionsCompat;
import androidx.fragment.app.Fragment;
import androidx.cardview.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import org.aviran.cookiebar2.CookieBar;

import java.util.HashMap;

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
    @BindView(R.id.throwback_slider) SliderLayout throwbackSlider;
    @BindView(R.id.throwback_slider_indicator) PagerIndicator throwBackSliderIndicator;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);

        setupSlider();

        shareCardView.setOnClickListener(view13 -> {
            CookieBar.build(getActivity())
                    .setTitle("Sharing is caring, apparently.")
                    .setMessage("Thanks for sharing our Pantheon app!")
                    .setBackgroundColor(R.color.purple)
                    .setDuration(6000)
                    .show();
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Pantheon");
            String appendedString = "Download the official Pantheon companion app for the latest updates about the activities in Pantheon here:\n";
            appendedString = appendedString + "https://play.google.com/store/apps/details?id=bapspatil.pantheon\n";
            shareIntent.putExtra(Intent.EXTRA_TEXT, appendedString);
            startActivity(Intent.createChooser(shareIntent, "Where do you want to share the Pantheon app?"));
        });

        locationCardView.setOnClickListener(view12 -> {
            CookieBar.build(getActivity())
                    .setTitle("Still having problems getting to our event?")
                    .setMessage("Just contact any one of our event coordinators, and they'll guide you (they have a good idea of where our college is).")
                    .setBackgroundColor(R.color.purple)
                    .setDuration(6000)
                    .show();
            String location = "https://maps.google.com/maps?q=loc:" + "37.4220041" + "," + "-122.0862462" + " (Googleplex)";
            Intent locationIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(location));
            startActivity(locationIntent);

        });

        aboutAppImageView.setOnClickListener(view1 -> {
            Intent i = new Intent(getActivity(), AboutActivity.class);
            ActivityOptionsCompat options = ActivityOptionsCompat.makeCustomAnimation(getActivity(), android.R.anim.fade_in, android.R.anim.fade_out);
            startActivity(i, options.toBundle());
        });
        return view;
    }

    private void setupSlider() {
        HashMap<String,Integer> slidesMap = new HashMap<>();
        slidesMap.put("We look forward to this year's event!", R.drawable.slide5);
        slidesMap.put("Lots of activities to participate in!", R.drawable.slide4);
        slidesMap.put("Party hall's for everyone!",R.drawable.slide0);
        slidesMap.put("We had an excellent art show!",R.drawable.slide2);
        slidesMap.put("Yes, we had a DJ play.",R.drawable.slide1);
        slidesMap.put("The band was great!", R.drawable.slide3);

        for(String caption : slidesMap.keySet()) {
            TextSliderView textSliderView = new TextSliderView(getContext());
            textSliderView
                    .description(caption)
                    .image(slidesMap.get(caption))
                    .setScaleType(BaseSliderView.ScaleType.CenterCrop);

            throwbackSlider.addSlider(textSliderView);
        }
        throwbackSlider.setCustomIndicator(throwBackSliderIndicator);
    }

    @Override
    public void onStop() {
        throwbackSlider.stopAutoCycle();
        super.onStop();
    }
}
