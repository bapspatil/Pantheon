package bapspatil.pantheon.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import org.aviran.cookiebar2.CookieBar;

import bapspatil.pantheon.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.bottom_nav_view) BottomBar bottomNavigationView;
    @BindView(R.id.toolbar) @Nullable Toolbar toolbar;
    private CookieBar backCookieBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

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
                        .replace(R.id.main_container, new HomeFragment())
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.action_updates:
                setSupportActionBar(toolbar);
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
                setSupportActionBar(toolbar);
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
                setSupportActionBar(toolbar);
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

    @Override
    public void onBackPressed() {
        if (backCookieBar != null) {
            finish();
        } else {
            backCookieBar = CookieBar.Build(MainActivity.this)
                    .setLayoutGravity(Gravity.BOTTOM)
                    .setTitle("Hit the back button again to quit.")
                    .setDuration(7000)
                    .show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_about:
                Toast.makeText(this, "About item clicked!", Toast.LENGTH_LONG).show();
                return true;
            default:
                return true;
        }
    }
}
