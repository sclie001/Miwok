package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity{

    /** handles playback of all sound files */
    private MediaPlayer mMediaPlayer;

    /**
     * This listener gets triggered when the {@link MediaPlayer} has completed playing the audio
     * file
     */
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.word_list);

        //create String array of words
        final ArrayList<Word> words = new ArrayList<>();

        //Word w = new Word("one", "lutti");
        //words.add(w);

        words.add(new Word("red", "weṭeṭṭi",
                R.drawable.color_red, R.raw.color_red));
        words.add(new Word("green", "chokokki",
                R.drawable.color_green, R.raw.color_green));
        words.add(new Word("brown", "ṭakaakki",
                R.drawable.color_brown, R.raw.color_brown));
        words.add(new Word("gray", "ṭopoppi",
                R.drawable.color_gray, R.raw.color_gray));
        words.add(new Word("black", "kululli",
                R.drawable.color_black, R.raw.color_black));
        words.add(new Word("white", "kelelli",
                R.drawable.color_white, R.raw.color_white));
        words.add(new Word("dusty yellow", "ṭopiisә",
                R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        words.add(new Word("mustard yellow", "chiwiiṭә",
                R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));

        //int words_size = words.size();

        //holds the list of items and determines the layout by the resource given
        WordAdapter adapter =
                new WordAdapter(this, words, R.color.category_colors);

        //Find the {@link ListView} object in the view hierarchy of the {@link Activity}
        ListView listView = findViewById(R.id.list);
        //use adapter to provide list items when requested by listView as view items are off screen
        listView.setAdapter(adapter);

        // Set a click listener to play the audio when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Release the media player if it currently exists because we are
                // about to play a different sound file
                releaseMediaPlayer();

                // Get the {@link Word} object at the given position the user clicked on
                Word currentWord = words.get(i);
                int audioResourceId = currentWord.getAudio_resource_id();

                //Media Player handles playback of audio files
                // Create and setup the {@link MediaPlayer} for the audio resource associated
                // with the current word
                mMediaPlayer = MediaPlayer.create(ColorsActivity.this,
                        audioResourceId);

                Toast.makeText(getApplicationContext(), "audio playing",
                        Toast.LENGTH_SHORT).show();
                //start the audio file
                mMediaPlayer.start();

                //Setup a listener on the media player, so that we can stop and release
                // the media player once the sound has finished playing
                mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });

    }

    /**
     * Clean up the media player by releasing its resources
     */
    private void releaseMediaPlayer(){
        //if the media player is not null, it may be currently playing a sound file
        if(mMediaPlayer != null){
            //Regardless of the current state of the media player, release its resources
            // because we no longer need it
            mMediaPlayer.release();

            // Set the media player back to null. For this code, by setting the media player to
            // null, it is easy to tell that the media player is not configured to play audio
            // at the moment
            mMediaPlayer = null;
        }
    }
}
