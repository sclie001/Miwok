package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
//import android.util.Log;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class NumbersActivity extends AppCompatActivity{

    /** handles playback of all sound files */
    private MediaPlayer mMediaPlayer;

    /**
     * This listener gets triggered when the {@link MediaPlayer} has completed playing the audio
     * file
     */
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            //now that the sound file has finished playing, release the media player resources
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

        words.add(new Word("one", "lutti",
                R.drawable.number_one, R.raw.number_one));
        words.add(new Word("two", "otiiko",
                R.drawable.number_two, R.raw.number_two));
        words.add(new Word("three", "tolookosu",
                R.drawable.number_three, R.raw.number_three));
        words.add(new Word("four", "oyyisa",
                R.drawable.number_four, R.raw.number_four));
        words.add(new Word("five", "massokka",
                R.drawable.number_five, R.raw.number_five));
        words.add(new Word("six", "tommokka",
                R.drawable.number_six, R.raw.number_six));
        words.add(new Word("seven", "kenekaku",
                R.drawable.number_seven, R.raw.number_seven));
        words.add(new Word("eight", "kawinta",
                R.drawable.number_eight, R.raw.number_eight));
        words.add(new Word("nine", "wo'e",
                R.drawable.number_nine, R.raw.number_nine));
        words.add(new Word("ten", "na'aacha",
                R.drawable.number_ten, R.raw.number_ten));

        //int words_size = words.size();

        //holds the list of items and determines the layout by the resource given
        WordAdapter adapter =
                new WordAdapter(this, words, R.color.category_numbers);

        //Find the {@link ListView} object in the view hierarchy of the {@link Activity}
        ListView listView = findViewById(R.id.list);
        //use adapter to provide list items when requested by listView as view items are off screen
        listView.setAdapter(adapter);

        // Set a click listener to play the audio when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Release the media player if it exists because we are about to play
                // a different sound file
                releaseMediaPlayer();

                // Get the {@link Word} object at the given position the user clicked on
                Word currentWord = words.get(i);
                int audioResourceId = currentWord.getAudio_resource_id();

                // Media Player handles playback of audio files
                // Create and setup the {@link MediaPlayer} for the audio resource associated
                // with the current word
                mMediaPlayer = MediaPlayer.create(NumbersActivity.this,
                        audioResourceId);

                Toast.makeText(getApplicationContext(), "audio playing",
                        Toast.LENGTH_SHORT).show();

                //start the audio file
                mMediaPlayer.start();


                // Setup a listener on the media player, so that we can stop and release the
                // media player once the sound has finished playing

                mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });

    }

    /**
     * Clean up the media player by releasing its resources
     */
    private void releaseMediaPlayer(){
        //if the media player is not null, it may be playing a sound
        if(mMediaPlayer != null){
            // Regardless of the current state of the media player, release
            // its resources because we no longer need it
            mMediaPlayer.release();

            //Set the media player back to null. For this code, it was easier
            // to set to null so that we can tell that the media player is not
            // configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }
}
