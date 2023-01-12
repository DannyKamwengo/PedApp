package PeadApp;

import android.content.DialogInterface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import PeadApp.R;

public class UpdateActivity extends AppCompatActivity {

    EditText date_input, age_input, weight_input, height_input;
    Button update_button, delete_button;
    String id, date, age, weight, height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_update);

        date_input = findViewById(R.id.date_input2);
        age_input = findViewById(R.id.age_input2);
        weight_input = findViewById(R.id.weight_input2);
        height_input = findViewById(R.id.height_input2);
        update_button = findViewById(R.id.update_button);
        delete_button = findViewById(R.id.delete_button);

        //First we call this
        getAndSetIntentData();

        //Set actionbar title after getAndSetIntent data method
        ActionBar ab = getSupportActionBar();
        if(ab != null){
            ab.setTitle(id);
        }


        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //And then we call this
                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateActivity.this);
                date = date_input.getText().toString();
                age = age_input.getText().toString();
                weight = weight_input.getText().toString();
                height = height_input.getText().toString();
                myDB.updateData(id, date, age, weight, height);
            }
        });

        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmDialog();
            }
        });
    }

    void getAndSetIntentData(){
        if(getIntent().hasExtra("id") && getIntent().hasExtra("date") &&
        getIntent().hasExtra("age") && getIntent().hasExtra("weight") &&
                getIntent().hasExtra("height")){
            //Getting data from Intent
            id = getIntent().getStringExtra("id");
            date = getIntent().getStringExtra("date");
            age = getIntent().getStringExtra("age");
            weight = getIntent().getStringExtra("weight");
            height = getIntent().getStringExtra("height");
            //Setting Intent data
            date_input.setText(date);
            age_input.setText(age);
            weight_input.setText(weight);
            height_input.setText(height);
        }else {
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }
    }

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + id + " ?");
        builder.setMessage("Are you sure you want to delete Record " + id + " ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateActivity.this);
                myDB.deleteOneRow(id);
                finish();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        builder.create().show();
    }
}