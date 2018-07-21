package bapspatil.pantheon.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import bapspatil.pantheon.BuildConfig;
import bapspatil.pantheon.R;
import bapspatil.pantheon.utils.GlideApp;
import butterknife.BindView;
import butterknife.ButterKnife;

public class AboutActivity extends AppCompatActivity {

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.baps_iv) ImageView bapsImageView;
    @BindView(R.id.google_play_iv) ImageView playButton;
    @BindView(R.id.github_iv) ImageView githubButton;
    @BindView(R.id.twitter_iv) ImageView twitterButton;
    @BindView(R.id.chrome_iv) ImageView chromeButton;
    @BindView(R.id.version_tv) TextView versionTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        GlideApp.with(this)
                .load("https://github.com/bapspatil.png")
                .dontAnimate()
                .placeholder(R.drawable.user_placeholder)
                .error(R.drawable.user_placeholder)
                .fallback(R.drawable.user_placeholder)
                .into(bapsImageView);

        versionTextView.setText(BuildConfig.VERSION_NAME + "\n(version code: " + BuildConfig.VERSION_CODE + ")" );

        playButton.setOnClickListener(view -> {
            String url = "https://play.google.com/store/apps/dev?id=7368032842071222295";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        });
        chromeButton.setOnClickListener(view -> {
            String url = "https://bapspatil.com";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        });
        githubButton.setOnClickListener(view -> {
            String url = "https://github.com/bapspatil";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        });
        twitterButton.setOnClickListener(view -> {
            String url = "https://twitter.com/baps_patil";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
