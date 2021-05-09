package com.example.youtubeplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class MainActivity2 extends YouTubeBaseActivity {

    private static final String TAG = "MainActivity";
    YouTubePlayerView youTubePlayerView;

    YouTubePlayer.OnInitializedListener onInitializedListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Log.d(TAG, "onCreate: Starting.");

        youTubePlayerView = findViewById(R.id.youtubePlay);

        Intent intent = getIntent();
        String link = intent.getStringExtra("input");

        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                Log.d(TAG, "onCreate: Done initializing");
                youTubePlayer.loadVideo(link);

            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

                Log.d(TAG, "onClick: Failed to initialize");
            }


        };
        youTubePlayerView.initialize(YouTubeConfig.getApiKey(), onInitializedListener);

    }
}