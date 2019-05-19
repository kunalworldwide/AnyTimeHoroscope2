package pwapps.anytimehoroscope;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class FirstScreen extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstscreen);


        //loading the default fragment
        loadFragment(new HomeFragment());

        //getting bottom navigation view and attaching the listener
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
       // TextView mtext = findViewById(R.id.textView2);

       FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                     .setAction("Action", null).show();
                Intent intent = new Intent(FirstScreen.this, RegistrationForm.class);
                startActivity(intent);
                finish();

                  }
        });
            if (getFirstName().isEmpty()) {
                    Toast.makeText(FirstScreen.this, "please register", Toast.LENGTH_SHORT).show();
                } else {

                   navigation.setItemBackgroundResource(R.color.HomeNavBar);

               //    String tester=getZodiac();
             //   Toast.makeText(this, tester, Toast.LENGTH_SHORT).show();


                }



    }

    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        BottomNavigationView navigation=findViewById(R.id.navigation);
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.navigation_home:
                fragment = new HomeFragment();
                navigation.setItemBackgroundResource(R.color.HomeNavBar);
                break;

            case R.id.navigation_offline:
                fragment = new OfflineFragment();
                navigation.setItemBackgroundResource(R.color.OfflineNavBar);
                break;

            case R.id.navigation_online:
                fragment = new OnlineFragment();
                navigation.setItemBackgroundResource(R.color.OnlineNavBar);
                break;

            case R.id.navigation_settings:
                fragment = new SettingsFragment();
                navigation.setItemBackgroundResource(R.color.SettingsNavBar);
                break;
        }

        return loadFragment(fragment);
    }

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_first_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private String getFirstName() {
        SharedPreferences userdata = getSharedPreferences("FirstName", MODE_PRIVATE);
        String firstname = userdata.getString("FirstName", "");
        return firstname;
    }






    public void onRestart()         //Everytime this activity is restarted when back etc button is pressed
    {
        super.onRestart();
        finish();
        startActivity(getIntent());
    }

}

