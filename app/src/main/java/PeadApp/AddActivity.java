package PeadApp;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import PeadApp.R;

public class AddActivity extends AppCompatActivity {

    EditText date_input, age_input, weight_input, height_input;
    Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_add);

        date_input = findViewById(R.id.date_input);
        age_input = findViewById(R.id.age_input);
        weight_input = findViewById(R.id.weight_input);
        height_input = findViewById(R.id.height_input);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(AddActivity.this);
                myDB.addBook(date_input.getText().toString().trim(),
                        age_input.getText().toString().trim(),
                        weight_input.getText().toString().trim(),
                        height_input.getText().toString().trim());
            }
        });
    }
}




