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

public class PhrasesActivity extends AppCompatActivity{

    /** handles play back of audio sound */
    private MediaPlayer mMediaPlayer;

    /**
     * This listener gets triggered when the media player has finished playing an audio file
     */
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            // now that the media player has finished playing, release its resources
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

        words.add(new Word("Where are you going?", "minto wuksus",
                R.raw.phrase_where_are_you_going));
        words.add(new Word("What is your name?", "tinnә oyaase'nә",
                R.raw.phrase_what_is_your_name));
        words.add(new Word("My name is...", "oyaaset...",
                R.raw.phrase_my_name_is));
        words.add(new Word("How are you feeling?", "michәksәs?",
                R.raw.phrase_how_are_you_feeling));
        words.add(new Word("I'm feeling good.", "kuchi achit",
                R.raw.phrase_im_feeling_good));
        words.add(new Word("Are you comming?", "әәnәs'aa?",
                R.raw.phrase_are_you_coming));
        words.add(new Word("Yes, I'm comming.", "hәә’ әәnәm",
                R.raw.phrase_yes_im_coming));
        words.add(new Word("I'm comming.", "әәnәm",
                R.raw.phrase_im_coming));
        words.add(new Word("Let's go.", "yoowutis",
                R.raw.phrase_lets_go));
        words.add(new Word("Come here.", "әnni'nem",
                R.raw.phrase_come_here));

        //int words_size = words.size();

        //holds the list of items and determines the layout by the resource given
        WordAdapter adapter =
                new WordAdapter(this, words, R.color.category_phrases);

        //Find the {@link ListView} object in the view hierarchy of the {@link Activity}
        ListView listView = (ListView)findViewById(R.id.list);
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
                mMediaPlayer = MediaPlayer.create(PhrasesActivity.this,
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
        // if the media player is not null, it may be playing a sound file
        if(mMediaPlayer != null){
            // Regardless of the current state of the media player, release its
            // resources because we no longer need it
            mMediaPlayer.release();

            // Set the media player back to null. For this code, it was easier to set it to
            // null because we can tell the media player is not configured to play sound
            // at the moment
            mMediaPlayer = null;
        }
    }
}
