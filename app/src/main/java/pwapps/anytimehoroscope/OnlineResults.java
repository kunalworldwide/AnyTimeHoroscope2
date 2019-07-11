package pwapps.anytimehoroscope;


import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.app.ProgressDialog;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static android.webkit.ConsoleMessage.MessageLevel.LOG;

public class OnlineResults extends AppCompatActivity {
    ProgressDialog dialog;
    TextView mresult;
    ListView fruitsList;
    String horoscoperesult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_results);
        mresult=findViewById(R.id.res);
        String url = "https://horoscope-api.herokuapp.com/horoscope/today/"+getZodiac();

        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading....");
        dialog.show();

        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String string) {
                Log.d("AAA","ASKED");
               horoscoperesult=parseJsonData(string);
             //Toast.makeText(OnlineResults.this, horoscoperesult, Toast.LENGTH_SHORT).show();
                mresult.setText(horoscoperesult);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(getApplicationContext(), "Some error occurred!!", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        RequestQueue rQueue = Volley.newRequestQueue(this);
        rQueue.add(request);
    }

    String parseJsonData(String jsonString) {
        String a="";
        try {
            JSONObject object = new JSONObject(jsonString);
             Log.d("AAA",object.getString("horoscope"));
             a=object.getString("horoscope");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        dialog.dismiss();
        return a;
    }
    public String getZodiac() {
        SharedPreferences userdata = getSharedPreferences("Sign", MODE_PRIVATE);
        String zodiac = userdata.getString("Sign", "");
        return zodiac;
    }

}