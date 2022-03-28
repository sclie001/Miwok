package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
//import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;


public class NumbersActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //create String array of words
        ArrayList<Word> words = new ArrayList<>();

        //Word w = new Word("one", "lutti");
        //words.add(w);

        words.add(new Word("one", "lutti",
                R.drawable.number_one));
        words.add(new Word("two", "otiiko",
                R.drawable.number_two));
        words.add(new Word("three", "tolookosu",
                R.drawable.number_three));
        words.add(new Word("four", "oyyisa",
                R.drawable.number_four));
        words.add(new Word("five", "massokka",
                R.drawable.number_five));
        words.add(new Word("six", "tommokka",
                R.drawable.number_six));
        words.add(new Word("seven", "kenekaku",
                R.drawable.number_seven));
        words.add(new Word("eight", "kawinta",
                R.drawable.number_eight));
        words.add(new Word("nine", "wo'e",
                R.drawable.number_nine));
        words.add(new Word("ten", "na'aacha",
                R.drawable.number_ten));

        //int words_size = words.size();

        //holds the list of items and determines the layout by the resource given
        WordAdapter adapter =
                new WordAdapter(this, words, R.color.category_numbers);

        //Find the {@link ListView} object in the view hierarchy of the {@link Activity}
        ListView listView = findViewById(R.id.list);
        //use adapter to provide list items when requested by listView as view items are off screen
        listView.setAdapter(adapter);





    }
}
