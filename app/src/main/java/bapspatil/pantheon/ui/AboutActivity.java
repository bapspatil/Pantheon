package bapspatil.pantheon.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

import bapspatil.pantheon.BuildConfig;
import bapspatil.pantheon.R;
import bapspatil.pantheon.adapters.LibrariesRecyclerViewAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

public class AboutActivity extends AppCompatActivity {

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.google_play_iv) ImageView playButton;
    @BindView(R.id.github_iv) ImageView githubButton;
    @BindView(R.id.twitter_iv) ImageView twitterButton;
    @BindView(R.id.chrome_iv) ImageView chromeButton;
    @BindView(R.id.version_tv) TextView versionTextView;
    @BindView(R.id.libraries_rv) RecyclerView librariesRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        versionTextView.setText(BuildConfig.VERSION_NAME + "\n(version code: " + BuildConfig.VERSION_CODE + ")" );

        ArrayList<String> libraries = new ArrayList<>(Arrays.asList(
                "Android Support Libraries",
                "GSON | google",
                "Glide | bumptech",
                "Butter Knife | jakewharton",
                "Retrofit | squareup",
                "CookieBar2 | aviranabady",
                "CircleImageView | hdodenhof",
                "Crescento | developer-shivam",
                "BottomBar | roughike",
                "Recyclerview-Animators | wasabeef",
                "AVLoadingIndicatorView | 81813780"
        ));
        librariesRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        librariesRecyclerView.setAdapter(new LibrariesRecyclerViewAdapter(this, libraries));

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://play.google.com/store/apps/dev?id=7368032842071222295";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        chromeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "http://www.bapspatil.com";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        githubButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://github.com/bapspatil";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        twitterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://twitter.com/baps_patil";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
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
