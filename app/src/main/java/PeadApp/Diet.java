package PeadApp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ListView;

import PeadApp.R;

public class Diet extends AppCompatActivity {

    ListView lst1;
    String[] diet_name = {"ANIMAL PROTEIN", "PLANT PROTEIN", "VEGETABLES", "FRUITS, CARBOHYDRATES", "Head and Teeth"};
    String[] desc1 = {"BODY BUILDING FOODS Like: Meats, Fish, Eggs, Silver Fish, Poultry, Milk, White Ants, Grass Hoppers etc.",
            "BODY BUILDING FOODS Like: Beans, Ground Nuts, Peas, Soya Beans etc.",
            "Dodo, Carrots, Yam leaves, Pumpkin leaves, Cassava leaves, Tomatoes, Onions, Bean leaves etc.",
            "PROTECTIVE FOODS Like: Mangoes, Avocado, Pawpaws, Oranges, Jack Fruits, Passion fruits, Apples, Water Melons, Pineapples, Guavas etc.",
            "ENERGY GIVING FOODS Like: Cereals; Rice, Sorghum, Millet, Wheat, Maize. Plaintains and Tubers; Matooke, Sweet Potatoes, Yams, Irish Potatoes, Cassava, Sugar Canes."};
    Integer[] imgid1 = {R.drawable.d1, R.drawable.d2, R.drawable.d3, R.drawable.d4, R.drawable.d5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_diet);

        lst1 = findViewById(R.id.listview1);
        CustomListview customListview = new CustomListview(this
                ,diet_name, desc1, imgid1);
        lst1.setAdapter(customListview);
    }
}