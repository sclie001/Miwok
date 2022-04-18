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
    /*image resource id for the word*/
    private int image_resource_id = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;
    /*audio resource id for the word*/
    private final int audio_resource_id;

    /**
     * Create a new Word object
     * @param defaultTranslation is the word in a language that the user is familiar with
     *                          (such as English)
     * @param miwokTranslation is the word in the Miwok language
     * @param audioResourceId is the resource id for the audio file associated with this word
     * */
    public Word(String defaultTranslation, String miwokTranslation, int audioResourceId){
        default_translation = defaultTranslation;
        miwok_translation = miwokTranslation;
        audio_resource_id = audioResourceId;

    }

    /**
     * Create a new Word object
     * @param defaultTranslation is the word in a language that the user is familiar with
     *                            (such as English)
     * @param miwokTranslation is the word in the Miwok language
     * @param imageResourceId is the drawable resource Id for the image associated with the word
     * @param audioResourceId is the resource id for the audio file associated with this word
     */
    public Word(String defaultTranslation, String miwokTranslation, int imageResourceId, int audioResourceId){
        default_translation = defaultTranslation;
        miwok_translation = miwokTranslation;
        image_resource_id = imageResourceId;
        audio_resource_id = audioResourceId;
    }

    /**
     * Get default translation of the word
     * @return default translation
     */
    public String getDefault_word() {
        return default_translation;
    }

    /**
     * Get miwok translation of the word
     * @return the miwok translation
     */
    public String getMiwok_word() {
        return miwok_translation;
    }

    /**
     * Get image resource id
     * @return the image resource id of the word
     */
    public int getImageResourceId(){
        return image_resource_id;
    }

    /**
     * Returns whether or not there is an image for this word
     * @return true if there is an image for a word, false otherwise
     */
    public boolean hasImage(){
        return image_resource_id != NO_IMAGE_PROVIDED;
    }

    /**
     * Get audio resource id
     * @return the audio resource id of the word
     */
    public int getAudio_resource_id(){
        return audio_resource_id;
    }
}
