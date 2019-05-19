package pwapps.anytimehoroscope;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;


public class OfflineFragment extends ListFragment {

    String[] listviewTitle = new String[]{
            "Health","Wealth","Society","Children","Career","Travel","Religious deed",
    };


    int[] listviewImage = new int[]{
            R.drawable.health,R.drawable.wealth,R.drawable.society,R.drawable.children,R.drawable.career,R.drawable.travel,R.drawable.ic_religious,
    };

    String[] listviewShortDescription = new String[]{
            "know about your health", "know about your wealth", "know about society", "know about your children",
            "know about your career", "know about your travel",  "some religious deed",
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View fragmentView =inflater.inflate(R.layout.fragment_offline,container,false);
        //just change the fragment_dashboard
        //with the fragment you want to inflate
        /*

       List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

      for (int i = 0; i < 7; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("listview_title", listviewTitle[i]);
            hm.put("listview_discription", listviewShortDescription[i]);
            hm.put("listview_image", Integer.toString(listviewImage[i]));
            aList.add(hm);
        }

        String[] from = {"listview_image", "listview_title", "listview_discription"};
        int[] to = {R.id.listview_image, R.id.listview_item_title, R.id.listview_item_short_description};

        SimpleAdapter simpleAdapter;
        simpleAdapter = new SimpleAdapter(getBaseContext(), aList, R.layout.customlistview, from, to);
        androidListView.setAdapter(simpleAdapter); */

      /*  SimpleAdapter adapter=new SimpleAdapter(getActivity().getBaseContext(),aList,R.layout.customlistview,from,to);
        //ListView androidListView =getActivity().findViewById(R.id.list_view);
        setListAdapter(adapter);*/
        return fragmentView;
    }
}
