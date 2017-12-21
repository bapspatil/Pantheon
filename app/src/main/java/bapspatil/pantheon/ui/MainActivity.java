package bapspatil.pantheon.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import bapspatil.pantheon.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.bottom_nav_view) BottomBar bottomNavigationView;
    HomeFragment homeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        homeFragment = new HomeFragment();
        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                .replace(R.id.main_container, homeFragment)
                .addToBackStack(null)
                .commit();

        bottomNavigationView.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(int tabId) {
                handleBottomNavClicked(tabId);
            }
        });
    }

    private void handleBottomNavClicked(int item) {
        switch (item) {
            case R.id.action_home:
                setTheme(R.style.AppTheme_Home);
                getWindow().setStatusBarColor(getResources().getColor(R.color.homePrimaryDark));
                getWindow().setNavigationBarColor(getResources().getColor(R.color.homePrimaryDark));

                getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                        .replace(R.id.main_container, homeFragment)
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.action_updates:
                setTheme(R.style.AppTheme_Updates);
                getWindow().setStatusBarColor(getResources().getColor(R.color.updatesPrimaryDark));
                getWindow().setNavigationBarColor(getResources().getColor(R.color.updatesPrimaryDark));

                getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                        .replace(R.id.main_container, new UpdatesFragment())
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.action_events:
                setTheme(R.style.AppTheme_Events);
                getWindow().setStatusBarColor(getResources().getColor(R.color.eventsPrimaryDark));
                getWindow().setNavigationBarColor(getResources().getColor(R.color.eventsPrimaryDark));

                getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                        .replace(R.id.main_container, new EventsFragment())
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.action_team:
                setTheme(R.style.AppTheme_Team);
                getWindow().setStatusBarColor(getResources().getColor(R.color.teamPrimaryDark));
                getWindow().setNavigationBarColor(getResources().getColor(R.color.teamPrimaryDark));

                getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                        .replace(R.id.main_container, new TeamFragment())
                        .addToBackStack(null)
                        .commit();
                break;
        }
    }
}
