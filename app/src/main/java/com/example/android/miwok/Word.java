package com.example.android.miwok;

/**
* {@Link Word} represents the word the user wants to learn
* It contains a default translation and a Miwok translation for that word
*/

public class Word {
    /*Miwok translation of the word*/
    private final String miwok_translation;
    /*default translation of Miwok word*/
    private final String default_translation;

    /**
     * Create a new Word object
     * @param defaultTranslation is the word in a language that the user is familiar with
     * (such as English)
     *
     * @param miwokTranslation is the word in the Miwok language
     * */
    public Word(String defaultTranslation, String miwokTranslation){
        default_translation = defaultTranslation;
        miwok_translation = miwokTranslation;

    }

    /** Get default translation of the word */
    public String getDefault_word() {
        return default_translation;
    }

    /** Get Miwok translation of the word */
    public String getMiwok_word() {
        return miwok_translation;
    }
}
