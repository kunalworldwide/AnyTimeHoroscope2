package pwapps.anytimehoroscope;

import android.content.Intent;

public class Sign {

    //Declaring private variables to work within class

    private String mTitle;
    private String mShortDescription;
    private String mBriefDescription;
    private Integer mlogo;

    //constructing Sign Class

    public Sign(String Title, String Description,String Details, Integer logo){

        mTitle = Title;
        mShortDescription = Description;
        mBriefDescription = Details;
        mlogo = logo;
    }

    //Defining Class methods which will be called to fetch data

    public String getTitle(){

        return mTitle;
    }

    public String getShortDescription() {

        return mShortDescription;
    }

    public String getmBriefDescription(){

        return mBriefDescription;
    }

    public Integer getLogo() {

        return mlogo;
    }

}
