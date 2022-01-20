/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        //find the view that shows the numbers category
        TextView numbers = findViewById(R.id.numbers);

        //set click listener on that view
        numbers.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent numbersActivity = new Intent(MainActivity.this, NumbersActivity.class);
                startActivity(numbersActivity);

            }
        });

        //find the view that shows the colors category
        TextView colors = findViewById((R.id.colors));

        //set clickListener on that view
        colors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent colorsActivity = new Intent(MainActivity.this, ColorsActivity.class);
                startActivity(colorsActivity);
            }
        });

        //find the view that shows the family category
        TextView family = findViewById(R.id.family);

        //set clickListener on that view
        family.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent familyActivity = new Intent(MainActivity.this, FamilyActivity.class);
                startActivity(familyActivity);
            }
        });

        //find the view that shows the phrases category
        TextView phrases = findViewById(R.id.phrases);

        //set clickListener on that view
        phrases.setOnClickListener((new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent phrasesActivity = new Intent(MainActivity.this, PhrasesActivity.class);
                startActivity(phrasesActivity);
            }
        }));



    }
}
