package pwapps.anytimehoroscope.Fragments;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import pwapps.anytimehoroscope.OnlineResults;
import pwapps.anytimehoroscope.R;
import pwapps.anytimehoroscope.RegistrationForm;

import static android.content.Context.MODE_PRIVATE;


public class OnlineFragment extends Fragment  implements View.OnClickListener {
    Button btn;
    TextView txt;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View fragmentView = inflater.inflate(R.layout.fragment_online, container, false);

        btn = (Button) fragmentView.findViewById(R.id.onlinebtn);
        // txt=(TextView)fragmentView.findViewById(R.id.resultText);
        btn.setOnClickListener(this);
        //txt.setText(getresult());

        return fragmentView;
    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.onlinebtn:
                Intent i = new Intent(getActivity(), OnlineResults.class);
                startActivity(i);
                break;
        }
    }


}

   /* private String getresult() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("horoscope", MODE_PRIVATE);
        String result = sharedPreferences.getString("Result", "");
        return result;
    }
}*/
