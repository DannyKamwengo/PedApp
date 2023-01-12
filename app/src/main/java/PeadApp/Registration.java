package PeadApp;

import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import PeadApp.R;

public class Registration extends AppCompatActivity {
    EditText fathers_name, mothers_name, childs_name, dob, placeofBirth;
    RadioGroup gender;
    Button register, cancel;
    DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_registration);

        fathers_name = findViewById(R.id.fathers_name);
        mothers_name = findViewById(R.id.mothers_name);
        childs_name = findViewById(R.id.child_name);
        dob = findViewById(R.id.dob);
        placeofBirth = findViewById(R.id.placeofBirth);
        gender = findViewById(R.id.gender);
        register = findViewById(R.id.register);
        cancel = findViewById(R.id.cancel);

        databaseHelper = new DatabaseHelper(this);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Registration.this,Dashboard.class);
                finish();
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fathers_nameValue = fathers_name.getText().toString();
                String mothers_nameValue = mothers_name.getText().toString();
                String childs_nameValue = childs_name.getText().toString();
                String dobValue = dob.getText().toString();
                String placeofBirthValue = placeofBirth.getText().toString();
                RadioButton checkedBtn = findViewById(gender.getCheckedRadioButtonId());
                String genderValue = checkedBtn.getText().toString();

                if (fathers_nameValue.length() > 1) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("fathers_name",fathers_nameValue);
                    contentValues.put("mothers_name",mothers_nameValue);
                    contentValues.put("childs_name",childs_nameValue);
                    contentValues.put("dob",dobValue);
                    contentValues.put("placeofBirth",placeofBirthValue);
                    contentValues.put("gender",genderValue);

                    databaseHelper.insertUser(contentValues);
                    Toast.makeText(Registration.this, "User Registered", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(Registration.this, "Some fields missing", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}
