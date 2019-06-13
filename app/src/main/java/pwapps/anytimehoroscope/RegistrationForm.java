package pwapps.anytimehoroscope;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import pwapps.anytimehoroscope.Fragments.OfflineFragment;

import static android.webkit.ConsoleMessage.MessageLevel.LOG;

public class RegistrationForm extends AppCompatActivity {




    final Calendar myCalendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_form);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        final EditText kFirstName = (EditText) findViewById(R.id.fisrtnameedittext);
        final EditText kLastName = (EditText) findViewById(R.id.lastnameedittext);
        EditText kBirthDate = findViewById(R.id.birthdateedittext);
        Button kRegisterButton = findViewById(R.id.registerbutton);


        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                int bDateArray[]={dayOfMonth,monthOfYear,year};
                storeBirthdate(bDateArray);
                storeZodiac(bDateArray);
                updateEdittext();

            }

        };

        kBirthDate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(RegistrationForm.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });


        kRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                storeFirstName(String.valueOf(kFirstName.getText()));

                if(getFirstName().equalsIgnoreCase(kFirstName.getText().toString()) && getZodiac()!="")
                {
                    Toast.makeText(RegistrationForm.this, "Success!", Toast.LENGTH_SHORT).show();

                }
            }


        });


//        Intent sendSign = new Intent(RegistrationForm.this, OfflineFragment.class);
//        sendSign.putExtra("zodiac",getZodiac());
//        startActivity(sendSign);


      //  onBackPressed();
    }
    @Override
    public void onBackPressed()
    {
        finish();
        Intent intent=new Intent(RegistrationForm.this,FirstScreen.class);
        startActivity(intent);
    }

    private void updateEdittext() {
        EditText editText = findViewById(R.id.birthdateedittext);
        String myFormat = "dd/MM/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        editText.setText(sdf.format(myCalendar.getTime()));
    }


    public void storeFirstName(String fname) {
        SharedPreferences userdata = getSharedPreferences("FirstName", MODE_PRIVATE);
        SharedPreferences.Editor mEditor = userdata.edit();
        mEditor.putString("FirstName", fname);
        mEditor.apply();
    }

    public void storeBirthdate(int bday[]) {                //Storing date in sharedpreffs
        SharedPreferences birthdate=getSharedPreferences("birthdate",MODE_PRIVATE);
        SharedPreferences.Editor kEditor=birthdate.edit();
        kEditor.putInt("birthdate",bday[0]);
        kEditor.apply();
        Log.d("bdate",String.valueOf(bday[0]));


        SharedPreferences birthmonth=getSharedPreferences("birthmonth",MODE_PRIVATE);   //Storing month in Sharedpreffs
        SharedPreferences.Editor lEditor=birthmonth.edit();
        lEditor.putInt("birthmonth",bday[1]+1);
        lEditor.apply();
        Log.d("bmonth",String.valueOf(bday[1]+1));
        }
    private String getFirstName() {
        SharedPreferences userdata = getSharedPreferences("FirstName", MODE_PRIVATE);
        String firstname = userdata.getString("FirstName", "");
        return firstname;
    }

    public void storeZodiac(int bday[])
    {
        int date=bday[0];
        int month=bday[1]+1;

        String zodiac="";

        if((month == 12 && date >= 22 && date <= 31) || (month ==  1 && date >= 1 && date <= 19))
        {
            zodiac="Capricorn";
        }
        else if ((month ==  1 && date >= 20 && date <= 31) || (month ==  2 && date >= 1 && date <= 17))
        {
            zodiac="Aquarius";

        }
        else if ((month ==  2 && date >= 18 && date <= 29) || (month ==  3 && date >= 1 && date <= 19))
        {
            zodiac="Pisces";

        }
        else if ((month ==  3 && date >= 20 && date <= 31) || (month ==  4 && date >= 1 && date <= 19))
        {
            zodiac="Aries";

        }
        else if ((month ==  4 && date >= 20 && date <= 30) || (month ==  5 && date >= 1 && date <= 20))
        {
            zodiac="Taurus";

        }
        else if ((month ==  5 && date >= 21 && date <= 31) || (month ==  6 && date >= 1 && date <= 20))
        {
            zodiac="Gemini";

        }
        else if ((month ==  6 && date >= 21 && date <= 30) || (month ==  7 && date >= 1 && date <= 22))
        {
            zodiac="Cancer";

        }
        else if ((month ==  7 && date >= 23 && date <= 31) || (month ==  8 && date >= 1 && date <= 22))
        {
            zodiac="Leo";

        }
        else if ((month ==  8 && date >= 23 && date <= 31) || (month ==  9 && date >= 1 && date <= 22))
        {
            zodiac="Virgo";

        }
        else if ((month ==  9 && date >= 23 && date <= 30) || (month == 10 && date >= 1 && date <= 22))
        {
            zodiac="Libra";

        }
        else if ((month == 10 && date >= 23 && date <= 31) || (month == 11 && date >= 1 && date <= 21))
        {
            zodiac="Scorpio";

        }
        else if ((month == 11 && date >= 22 && date <= 30) || (month == 12 && date >= 1 && date <= 21))
        {
            zodiac="Sagittarius";

        }

        if (zodiac != "")
        {
            SharedPreferences userdata = getSharedPreferences("Sign", MODE_PRIVATE);
            SharedPreferences.Editor mEditor = userdata.edit();
            mEditor.putString("Sign", zodiac);
            mEditor.apply();
        }

        Log.d("ABRA",zodiac);
        }
        public String getZodiac()
        {
            SharedPreferences userdata = getSharedPreferences("Sign", MODE_PRIVATE);
            String zodiac = userdata.getString("Sign", "");
            return zodiac;
        }
}


