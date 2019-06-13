package pwapps.anytimehoroscope;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import pwapps.anytimehoroscope.Fragments.DetailsFragment;
import pwapps.anytimehoroscope.Fragments.OfflineFragment;

public class SignDescriptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_description);

        loadFragment(new DetailsFragment());


    }

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.nested_container, fragment)
                    .commit();

            return true;
        }
        return false;
    }

}
