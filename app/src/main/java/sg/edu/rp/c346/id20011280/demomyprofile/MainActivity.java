package sg.edu.rp.c346.id20011280.demomyprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etGPA;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextName);
        etGPA = findViewById(R.id.editTextGPA);
    }
    @Override
    protected void onPause(){
        super.onPause();

        String strName = etName.getText().toString();

        SharedPreferences prefs = getPreferences(MODE_PRIVATE);

        SharedPreferences.Editor prefEdit = prefs.edit();

        prefEdit.putString("name", strName);
        prefEdit.putFloat("GPA",Float.parseFloat(etGPA.getText().toString()));

        prefEdit.commit();
    }
    @Override
    protected void onResume(){
        super.onResume();

        SharedPreferences prefs = getPreferences(MODE_PRIVATE);

        String StrName = prefs.getString("name","No Name found");

        float gpa = prefs.getFloat("GPA",0.0f);

        etName.setText(StrName);
        etGPA.setText(String.valueOf(gpa));






    }
}