package pwapps.anytimehoroscope.Fragments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import pwapps.anytimehoroscope.Adapters.OfflineSignAdapter;
import pwapps.anytimehoroscope.R;
import pwapps.anytimehoroscope.Sign;
import pwapps.anytimehoroscope.SignDescriptionActivity;

import static android.content.Context.MODE_PRIVATE;


public class OfflineFragment extends Fragment {

    ArrayList<Sign> signs;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View fragmentView =inflater.inflate(R.layout.fragment_offline,container,false);

        String sd = "Short Description";
        String bd = "Mia Khalifa was born on February 10, 1993, in Beirut, Lebanon and moved with her family to the United States in January 2001, leaving their home in the wake of the South Lebanon conflict.";


        signs = new ArrayList<Sign>();


        createListUsingZodiacSign(getZodiac());

        final OfflineSignAdapter offlineSignAdapterArrayAdapter = new OfflineSignAdapter(getActivity(),signs);

        ListView listView = fragmentView.findViewById(R.id.listView);
        listView.setAdapter(offlineSignAdapterArrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String titleToast = String.valueOf(offlineSignAdapterArrayAdapter.getItem(position).getTitle());
                String signDetails = String.valueOf(offlineSignAdapterArrayAdapter.getItem(position).getmBriefDescription());
                Integer logo = offlineSignAdapterArrayAdapter.getItem(position).getLogo();

                Toast.makeText(getActivity(), titleToast, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getActivity(), SignDescriptionActivity.class);

                intent.putExtra("signDetails",signDetails);
                intent.putExtra("logo",logo);

                startActivity(intent);
            }
        });


        return fragmentView;


    }

    public OfflineFragment() {}

    public void populateSignArrayList(String title, String shortDescription, String briefDescription, Integer logo){

        signs.add(new Sign(title,shortDescription,briefDescription,logo));
    }

    public void createListUsingZodiacSign(String zodiac){

        if (zodiac == "Capricorn"){

            populateSignArrayList("Health","Health", getActivity().getResources().getString(R.string.Capricorn_Health),R.drawable.health);
            populateSignArrayList("Wealth","Wealth",getActivity().getResources().getString(R.string.Capricorn_Wealth),R.drawable.wealth);
            populateSignArrayList("Family","Family",getActivity().getResources().getString(R.string.Capricorn_Family),R.drawable.society);
            populateSignArrayList("Career","Career",getActivity().getResources().getString(R.string.Capricorn_Career),R.drawable.career);
            populateSignArrayList("Children","Children",getActivity().getResources().getString(R.string.Capricorn_Children),R.drawable.children);
            populateSignArrayList("Travel","Travel",getActivity().getResources().getString(R.string.Capricorn_Travel),R.drawable.travel);

        }

        else if (zodiac == "Aries"){

            populateSignArrayList("Health","Health", getActivity().getResources().getString(R.string.Aries_Health),R.drawable.health);
            populateSignArrayList("Wealth","Wealth",getActivity().getResources().getString(R.string.Aries_Wealth),R.drawable.wealth);
            populateSignArrayList("Family","Family",getActivity().getResources().getString(R.string.Aries_Family),R.drawable.society);
            populateSignArrayList("Career","Career",getActivity().getResources().getString(R.string.Aries_Career),R.drawable.career);
            populateSignArrayList("Children","Children",getActivity().getResources().getString(R.string.Aries_Children),R.drawable.children);
            populateSignArrayList("Travel","Travel",getActivity().getResources().getString(R.string.Aries_Travel),R.drawable.travel);
        }

        else if (zodiac == "Taurus"){

            populateSignArrayList("Health","Health", getActivity().getResources().getString(R.string.Taurus_Health),R.drawable.health);
            populateSignArrayList("Wealth","Wealth",getActivity().getResources().getString(R.string.Taurus_Wealth),R.drawable.wealth);
            populateSignArrayList("Family","Family",getActivity().getResources().getString(R.string.Taurus_Family),R.drawable.society);
            populateSignArrayList("Career","Career",getActivity().getResources().getString(R.string.Taurus_Career),R.drawable.career);
            populateSignArrayList("Children","Children",getActivity().getResources().getString(R.string.Taurus_Children),R.drawable.children);
            populateSignArrayList("Travel","Travel",getActivity().getResources().getString(R.string.Taurus_Tarvel),R.drawable.travel);
        }

        else if (zodiac == "Gemini"){


            populateSignArrayList("Health","Health", getActivity().getResources().getString(R.string.Gemini_Health),R.drawable.health);
            populateSignArrayList("Wealth","Wealth",getActivity().getResources().getString(R.string.Gemini_Wealth),R.drawable.wealth);
            populateSignArrayList("Family","Family",getActivity().getResources().getString(R.string.Gemini_Family),R.drawable.society);
            populateSignArrayList("Career","Career",getActivity().getResources().getString(R.string.Gemini_Career),R.drawable.career);
            populateSignArrayList("Children","Children",getActivity().getResources().getString(R.string.Gemini_Children),R.drawable.children);
            populateSignArrayList("Travel","Travel",getActivity().getResources().getString(R.string.Gemini_Travel),R.drawable.travel);

        }

        else if (zodiac == "Cancer") {

            populateSignArrayList("Health","Health", getActivity().getResources().getString(R.string.Cancer_Health),R.drawable.health);
            populateSignArrayList("Wealth","Wealth",getActivity().getResources().getString(R.string.Cancer_Wealth),R.drawable.wealth);
            populateSignArrayList("Family","Family",getActivity().getResources().getString(R.string.Cancer_Family),R.drawable.society);
            populateSignArrayList("Career","Career",getActivity().getResources().getString(R.string.Cancer_Career),R.drawable.career);
            populateSignArrayList("Children","Children",getActivity().getResources().getString(R.string.Cancer_Children),R.drawable.children);
            populateSignArrayList("Travel","Travel",getActivity().getResources().getString(R.string.Cancer_Travel),R.drawable.travel);

        }

        else if (zodiac == "Leo"){

            populateSignArrayList("Health","Health", getActivity().getResources().getString(R.string.Leo_health),R.drawable.health);
            populateSignArrayList("Wealth","Wealth",getActivity().getResources().getString(R.string.Leo_Wealth),R.drawable.wealth);
            populateSignArrayList("Family","Family",getActivity().getResources().getString(R.string.Leo_family),R.drawable.society);
            populateSignArrayList("Career","Career",getActivity().getResources().getString(R.string.Leo_Career),R.drawable.career);
            populateSignArrayList("Children","Children",getActivity().getResources().getString(R.string.Leo_Children),R.drawable.children);
            populateSignArrayList("Travel","Travel",getActivity().getResources().getString(R.string.Leo_Travel),R.drawable.travel);

        }

        else if (zodiac == "Virgo"){

            populateSignArrayList("Health","Health", getActivity().getResources().getString(R.string.Virgo_health),R.drawable.health);
            populateSignArrayList("Wealth","Wealth",getActivity().getResources().getString(R.string.Virgo_wealth),R.drawable.wealth);
            populateSignArrayList("Family","Family",getActivity().getResources().getString(R.string.Virgo_family),R.drawable.society);
            populateSignArrayList("Career","Career",getActivity().getResources().getString(R.string.Virgo_career),R.drawable.career);
            populateSignArrayList("Children","Children",getActivity().getResources().getString(R.string.Virgo_children),R.drawable.children);
            populateSignArrayList("Travel","Travel",getActivity().getResources().getString(R.string.Virgo_travel),R.drawable.travel);

        }

        else if (zodiac == "Scorpio"){

            populateSignArrayList("Health","Health", getActivity().getResources().getString(R.string.Scorpio_health),R.drawable.health);
            populateSignArrayList("Wealth","Wealth",getActivity().getResources().getString(R.string.Scorpio_wealth),R.drawable.wealth);
            populateSignArrayList("Family","Family",getActivity().getResources().getString(R.string.Scorpio_family),R.drawable.society);
            populateSignArrayList("Career","Career",getActivity().getResources().getString(R.string.Scorpio_career),R.drawable.career);
            populateSignArrayList("Children","Children",getActivity().getResources().getString(R.string.Scorpio_children),R.drawable.children);
            populateSignArrayList("Travel","Travel",getActivity().getResources().getString(R.string.Scorpio_travel),R.drawable.travel);

        }

        else if (zodiac == "Libra"){

            populateSignArrayList("Health","Health", getActivity().getResources().getString(R.string.Libra_health),R.drawable.health);
            populateSignArrayList("Wealth","Wealth",getActivity().getResources().getString(R.string.Libra_wealth),R.drawable.wealth);
            populateSignArrayList("Family","Family",getActivity().getResources().getString(R.string.Libra_family),R.drawable.society);
            populateSignArrayList("Career","Career",getActivity().getResources().getString(R.string.Libra_career),R.drawable.career);
            populateSignArrayList("Children","Children",getActivity().getResources().getString(R.string.Libra_children),R.drawable.children);
            populateSignArrayList("Travel","Travel",getActivity().getResources().getString(R.string.Libra_travel),R.drawable.travel);

        }

        else if (zodiac == "Sagittarius"){

            populateSignArrayList("Health","Health", getActivity().getResources().getString(R.string.Sagittarius_health),R.drawable.health);
            populateSignArrayList("Wealth","Wealth",getActivity().getResources().getString(R.string.Sagittarius_wealth),R.drawable.wealth);
            populateSignArrayList("Family","Family",getActivity().getResources().getString(R.string.Sagittarius_family),R.drawable.society);
            populateSignArrayList("Career","Career",getActivity().getResources().getString(R.string.Sagittarius_career),R.drawable.career);
            populateSignArrayList("Children","Children",getActivity().getResources().getString(R.string.Sagittarius_children),R.drawable.children);
            populateSignArrayList("Travel","Travel",getActivity().getResources().getString(R.string.Sagittarius_travel),R.drawable.travel);

        }

        else if (zodiac == "Pisces"){

            populateSignArrayList("Health","Health", getActivity().getResources().getString(R.string.Pisces_health),R.drawable.health);
            populateSignArrayList("Wealth","Wealth",getActivity().getResources().getString(R.string.Pisces_wealth),R.drawable.wealth);
            populateSignArrayList("Family","Family",getActivity().getResources().getString(R.string.Pisces_family),R.drawable.society);
            populateSignArrayList("Career","Career",getActivity().getResources().getString(R.string.Pisces_career),R.drawable.career);
            populateSignArrayList("Children","Children",getActivity().getResources().getString(R.string.Pisces_children),R.drawable.children);
            populateSignArrayList("Travel","Travel",getActivity().getResources().getString(R.string.Pisces_travel),R.drawable.travel);

        }

        else if (zodiac == "Aquaris"){

            populateSignArrayList("Health","Health", getActivity().getResources().getString(R.string.Aquaris_health),R.drawable.health);
            populateSignArrayList("Wealth","Wealth",getActivity().getResources().getString(R.string.Aquaris_wealth),R.drawable.wealth);
            populateSignArrayList("Family","Family",getActivity().getResources().getString(R.string.Aquaris_family),R.drawable.society);
            populateSignArrayList("Career","Career",getActivity().getResources().getString(R.string.Aquaris_career),R.drawable.career);
            populateSignArrayList("Children","Children",getActivity().getResources().getString(R.string.Aquaris_children),R.drawable.children);
            populateSignArrayList("Travel","Travel",getActivity().getResources().getString(R.string.Aquaris_travel),R.drawable.travel);
        }

        else {

            populateSignArrayList("Health","Health", "Something not right!",R.drawable.health);
            populateSignArrayList("Wealth","Wealth","Something not right!",R.drawable.wealth);
            populateSignArrayList("Family","Family","Something not right!",R.drawable.society);
            populateSignArrayList("Career","Career","Something not right!",R.drawable.career);
            populateSignArrayList("Children","Children","Something not right!",R.drawable.children);
            populateSignArrayList("Travel","Travel","Something not right!",R.drawable.travel);
        }
    }

    public String getZodiac(){

        SharedPreferences userdate = getActivity().getSharedPreferences("Sign",MODE_PRIVATE);
        String zodiac = userdate.getString("Sign","");
        return zodiac;

    }

}
