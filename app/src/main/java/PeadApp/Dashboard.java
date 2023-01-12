package PeadApp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.WindowManager;

public class Dashboard extends AppCompatActivity implements View.OnClickListener {

    public CardView register, remind, food, monitor, record_growth, care;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_dashboard);


        register = (CardView) findViewById(R.id.register);
        remind = (CardView) findViewById(R.id.remind);
        food = (CardView) findViewById(R.id.food);
        monitor = (CardView) findViewById(R.id.monitor);
        record_growth = (CardView) findViewById(R.id.record_growth);
        care = (CardView) findViewById(R.id.care);
        register.setOnClickListener(this);
        remind.setOnClickListener(this);
        food.setOnClickListener(this);
        monitor.setOnClickListener(this);
        record_growth.setOnClickListener(this);
        care.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent i;

        switch (view.getId()) {
            case R.id.register:
                i = new Intent(this, Registration.class);
                startActivity(i);
                break;

            case R.id.remind:
                i = new Intent(this, SetReminder.class);
                startActivity(i);
                break;

            case R.id.food:
                i = new Intent(this, Diet.class);
                startActivity(i);
                break;

            case R.id.monitor:
                i = new Intent(this, Mothers.class);
                startActivity(i);
                break;

            case R.id.record_growth:
                i = new Intent(this, Record.class);
                startActivity(i);
                break;

            case R.id.care:
                i = new Intent(this, Care.class);
                startActivity(i);
                break;
        }




    }
}