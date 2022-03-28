package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.word_list);

        //create String array of words
        ArrayList<Word> words = new ArrayList<>();

        //Word w = new Word("one", "lutti");
        //words.add(w);

        words.add(new Word("Where are you going?", "minto wuksus"));
        words.add(new Word("What is your name?", "tinnә oyaase'nә"));
        words.add(new Word("My name is...", "oyaaset..."));
        words.add(new Word("How are you feeling?", "michәksәs?"));
        words.add(new Word("I'm feeling good.", "kuchi achit"));
        words.add(new Word("Are you comming?", "әәnәs'aa?"));
        words.add(new Word("Yes, I'm comming.", "hәә’ әәnәm"));
        words.add(new Word("I'm comming.", "әәnәm"));
        words.add(new Word("Let's go.", "yoowutis"));
        words.add(new Word("Come here.", "әnni'nem"));

        //int words_size = words.size();

        //holds the list of items and determines the layout by the resource given
        WordAdapter adapter =
                new WordAdapter(this, words, R.color.category_phrases);

        //Find the {@link ListView} object in the view hierarchy of the {@link Activity}
        ListView listView = (ListView)findViewById(R.id.list);
        //use adapter to provide list items when requested by listView as view items are off screen
        listView.setAdapter(adapter);
    }
}
