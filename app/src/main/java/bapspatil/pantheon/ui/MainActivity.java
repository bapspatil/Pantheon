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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

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
            case R.id.action_team:
                setTheme(R.style.AppTheme_Team);
                bottomNavigationView.setBackgroundColor(getResources().getColor(R.color.teamPrimary));

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().setStatusBarColor(getResources().getColor(R.color.teamPrimaryDark));
                    getWindow().setNavigationBarColor(getResources().getColor(R.color.teamPrimaryDark));
                }
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_container, new TeamFragment())
                        .addToBackStack(null)
                        .commit();
        }
    }
}
