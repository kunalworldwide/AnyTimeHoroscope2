package pwapps.anytimehoroscope.Fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import pwapps.anytimehoroscope.R;

import static android.content.Context.MODE_PRIVATE;


public class HomeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View fragmentView =inflater.inflate(R.layout.fragment_home,container,false);
        //just change the fragment_dashboard
        //with the fragment you want to inflate
        //like if the class is HomeFragment it should have R.layout.home_fragment
        //if it is DashboardFragment it should have R.layout.fragment_dashboard

        TextView mtext=fragmentView.findViewById(R.id.texth);

        if(getFirstName().isEmpty() || getZodiac().isEmpty())
        {
            mtext.setText("Register FIRST");
        }
        else
        {

        String hello="HELLO"+"\n"+getFirstName();//.substring(0,1).toUpperCase()+getFirstName().substring(1);
        String sign="\n"+"YOUR SIGN IS"+"\n"+getZodiac();
        mtext.setText(hello+sign);
        }
        return fragmentView;
    }

    private String getFirstName() {
        SharedPreferences userdata = getActivity().getSharedPreferences("FirstName", MODE_PRIVATE);
        String firstname = userdata.getString("FirstName", "");
        return firstname;
    }

    public String getZodiac() {
        SharedPreferences userdata = getActivity().getSharedPreferences("Sign", MODE_PRIVATE);
        String zodiac = userdata.getString("Sign", "");
        return zodiac;
    }
}

