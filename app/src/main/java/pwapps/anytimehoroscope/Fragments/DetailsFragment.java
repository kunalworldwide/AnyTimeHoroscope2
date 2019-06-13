package pwapps.anytimehoroscope.Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import pwapps.anytimehoroscope.Fragments.OfflineFragment;
import pwapps.anytimehoroscope.R;


public class DetailsFragment extends Fragment {

    public DetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View fragmentview = inflater.inflate(R.layout.fragment_details,container,false);

        ImageView logoView = fragmentview.findViewById(R.id.logoImageView);
        TextView details = fragmentview.findViewById(R.id.detailsTextView);

        String signDetails = getActivity().getIntent().getStringExtra("signDetails");
        Integer logo = getActivity().getIntent().getIntExtra("logo",0);

        logoView.setImageResource(logo);
        details.setText(signDetails);

//        Button backButton = findViewById(R.id.button);
//
//        backButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent intent = new Intent(SignDescriptionActivity.this, OfflineFragment.class);
//                startActivity(intent);
//            }
//        });

        return fragmentview;
    }





}
