package PeadApp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ListView;

import PeadApp.R;

public class Care extends AppCompatActivity {

    ListView lst;
    String[] organ_name = {"Spine", "Solar Plexus", "Lungs", "Nose, Sinuses", "Head and Teeth"};
    String[] desc = {"Massage to help the baby relax before going to bed",
            "Massage if the child has a stomachache",
            "Massage if the child is coughing",
            "Massage to get rid of nasal stuffiness and runny nose",
            "If the child has a headache or toothache, gently massage these areas"};
    Integer[] imgid = {R.drawable.c, R.drawable.c1, R.drawable.c2, R.drawable.c3, R.drawable.c4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_care);

        lst = findViewById(R.id.listview);
        CustomListview customListview = new CustomListview(this
                ,organ_name, desc, imgid);
        lst.setAdapter(customListview);
    }
}