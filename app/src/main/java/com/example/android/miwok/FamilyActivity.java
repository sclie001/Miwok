package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    /** handles play back of audio sound */
    private MediaPlayer mMediaPlayer;

    /**
     * This listener gets triggered when the {@link MediaPlayer} has completed playing an audio file
     */
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            //now that the media player has finished playing, release the media player resources
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

        words.add(new Word("father", "әpә",
                R.drawable.family_father, R.raw.family_father));
        words.add(new Word("mother", "әṭa",
                R.drawable.family_mother, R.raw.family_mother));
        words.add(new Word("son", "angsi",
                R.drawable.family_son, R.raw.family_son));
        words.add(new Word("daughter", "tune",
                R.drawable.family_daughter, R.raw.family_daughter));
        words.add(new Word("older brother", "taachi",
                R.drawable.family_older_brother, R.raw.family_older_brother));
        words.add(new Word("younger brother", "chalitti",
                R.drawable.family_younger_brother, R.raw.family_younger_brother));
        words.add(new Word("older sister", "tete",
                R.drawable.family_older_sister, R.raw.family_older_sister));
        words.add(new Word("younger sister", "kolliti",
                R.drawable.family_younger_sister, R.raw.family_younger_sister));
        words.add(new Word("grand mother", "ama",
                R.drawable.family_grandmother, R.raw.family_grandmother));
        words.add(new Word("grand father", "paapa",
                R.drawable.family_grandfather, R.raw.family_grandfather));

        //int words_size = words.size();

        //holds the list of items and determines the layout by the resource given
        WordAdapter adapter =
                new WordAdapter(this, words, R.color.category_family);

        //Find the {@link ListView} object in the view hierarchy of the {@link Activity}
        ListView listView = findViewById(R.id.list);
        //use adapter to provide list items when requested by listView as view items are off screen
        listView.setAdapter(adapter);

        // Set a click listener to play the audio when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                // Get the {@link Word} object at the given position the user clicked on
                Word currentWord = words.get(i);
                int audioResourceId = currentWord.getAudio_resource_id();

                // Media Player handles playback of audio files
                // Create and setup the {@link MediaPlayer} for the audio resource associated
                // with the current word
                mMediaPlayer = MediaPlayer.create(FamilyActivity.this,
                        audioResourceId);

                Toast.makeText(getApplicationContext(), "audio playing",
                        Toast.LENGTH_SHORT).show();

                //start the audio file
                mMediaPlayer.start();

                // Setup a listener on the media player, so that we can stop and release the
                // media player once the sound file has finished playing
                mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });
    }

    private void releaseMediaPlayer(){
        //if the media player is not null, it may be playing a sound file
        if(mMediaPlayer != null){
            // Regardless of the current state of the media player, release its
            // resources because we no longer need it
            mMediaPlayer.release();

            // Set the media player back to null. For this code, it was easier to set it to
            // null because we can tell the media player is not configured to play
            // a sound file at the moment
            mMediaPlayer = null;
        }
    }
}
