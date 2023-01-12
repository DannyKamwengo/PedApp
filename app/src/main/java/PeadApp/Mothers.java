package PeadApp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ListView;

import PeadApp.R;

public class Mothers extends AppCompatActivity {

    ListView lst2;
    String[] m_name = {"Nutrition for Pregnant and Breastfeeding Mothers.",
                       "Exclusive Breastfeeding for the First Six months of Life.",
                       "Advantages of Exclusive Breastfeeding during the first Six months.",
                       "Disadvantages of not Exclusively Breastfeeding during the first Six months.",
                       "Breastfeeding infant at least 8 to 12 times in 24 hours."};
    String[] desc2 = {"Good Nutrition is important during pregnancy. During your pregnancy, eat one extra meal each day. During breastfeeding, eat two extra meals each day.",
                      "Breastfeed your baby whenever he or she wants during the day and night. Your breasts make as much milk as your baby takes. If your baby takes more, your breasts make more. If you do not breastfeed as often, your brests make less.",
                      "Breast milk is perfect food for babies because it has everything a baby needs. Babies who only take breast milk grow well, fall sick less often, and perform better in school. Breast milk protects against illnesses. Breast milk is free, clean, safe and always readily available.",
                      "Babies can become sick with diarrhoea or other illnesses. Babies may lose weight and not grow in a healthy way. Babies may become malnourished.",
                      "Breastfeed your baby often, at least 8 to 12 times, day and night to make lots of breast milk. Let your baby suckle as long as he or she wants. Finish feeding your baby from one breast before giving milk from the other brest. Begin breast feeding before the baby starts cying."};
    Integer[] imgid2 = {R.drawable.p1_2, R.drawable.p2_1, R.drawable.p3_1, R.drawable.p3_2, R.drawable.p4_1};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_mothers);

        lst2 = findViewById(R.id.listview2);
        CustomListview customListview = new CustomListview(this
                ,m_name, desc2, imgid2);
        lst2.setAdapter(customListview);
    }
}