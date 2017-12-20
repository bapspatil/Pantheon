package bapspatil.pantheon.ui;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import bapspatil.pantheon.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.bottom_nav_view) BottomNavigationView bottomNavigationView;
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

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                handleBottomNavClicked(item);
                return true;
            }
        });
    }

    private void handleBottomNavClicked(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_home:
                setTheme(R.style.AppTheme_Home);
                bottomNavigationView.setBackgroundColor(getResources().getColor(R.color.homePrimary));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().setStatusBarColor(getResources().getColor(R.color.homePrimaryDark));
                    getWindow().setNavigationBarColor(getResources().getColor(R.color.homePrimaryDark));
                }
                getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                        .replace(R.id.main_container, homeFragment)
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.action_updates:
                setTheme(R.style.AppTheme_Updates);
                bottomNavigationView.setBackgroundColor(getResources().getColor(R.color.updatesPrimary));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().setStatusBarColor(getResources().getColor(R.color.updatesPrimaryDark));
                    getWindow().setNavigationBarColor(getResources().getColor(R.color.updatesPrimaryDark));
                }

                getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                        .replace(R.id.main_container, new UpdatesFragment())
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.action_events:
                setTheme(R.style.AppTheme_Events);
                bottomNavigationView.setBackgroundColor(getResources().getColor(R.color.eventsPrimary));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().setStatusBarColor(getResources().getColor(R.color.eventsPrimaryDark));
                    getWindow().setNavigationBarColor(getResources().getColor(R.color.eventsPrimaryDark));
                }

                getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                        .replace(R.id.main_container, new EventsFragment())
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.action_team:
                setTheme(R.style.AppTheme_Team);
                bottomNavigationView.setBackgroundColor(getResources().getColor(R.color.teamPrimary));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().setStatusBarColor(getResources().getColor(R.color.teamPrimaryDark));
                    getWindow().setNavigationBarColor(getResources().getColor(R.color.teamPrimaryDark));
                }

                getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                        .replace(R.id.main_container, new TeamFragment())
                        .addToBackStack(null)
                        .commit();
                break;
        }
    }
}
