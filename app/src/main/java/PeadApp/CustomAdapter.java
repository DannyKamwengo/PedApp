package PeadApp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import PeadApp.R;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private  Context context;
    Activity activity;
    private ArrayList child_id, child_date, child_age, child_weight, child_height;

    CustomAdapter(Activity activity, Context context, ArrayList child_id, ArrayList child_date, ArrayList child_age, ArrayList child_weight, ArrayList child_height){
        this.activity = activity;
        this.context = context;
        this.child_id = child_id;
        this.child_date = child_date;
        this.child_age = child_age;
        this.child_weight = child_weight;
        this.child_height = child_height;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, @SuppressLint("RecyclerView") final int position) {
        myViewHolder.child_id_txt.setText(String.valueOf(child_id.get(position)));
        myViewHolder.child_date_txt.setText(String.valueOf(child_date.get(position)));
        myViewHolder.child_age_txt.setText(String.valueOf(child_age.get(position)));
        myViewHolder.child_weight_txt.setText(String.valueOf(child_weight.get(position)));
        myViewHolder.child_height_txt.setText(String.valueOf(child_height.get(position)));
        myViewHolder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, UpdateActivity.class);
                intent.putExtra("id", String.valueOf(child_id.get(position)));
                intent.putExtra("date", String.valueOf(child_date.get(position)));
                intent.putExtra("age", String.valueOf(child_age.get(position)));
                intent.putExtra("weight", String.valueOf(child_weight.get(position)));
                intent.putExtra("height", String.valueOf(child_height.get(position)));
                activity.startActivityForResult(intent,1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return child_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView child_id_txt, child_date_txt, child_age_txt, child_weight_txt, child_height_txt;
        LinearLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            child_id_txt = itemView.findViewById(R.id.child_id_txt);
            child_date_txt = itemView.findViewById(R.id.child_date_txt);
            child_age_txt = itemView.findViewById(R.id.child_age_txt);
            child_weight_txt = itemView.findViewById(R.id.child_weight_txt);
            child_height_txt = itemView.findViewById(R.id.child_height_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
