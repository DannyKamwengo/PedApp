package PeadApp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import PeadApp.R;


public class CustomListview extends ArrayAdapter<String> {

    private String[] organ_name;
    private String[] desc;
    private Integer[] imgid;
    private Activity context;
    public CustomListview(Activity context, String[] organ_name, String[] desc, Integer[] imgid) {
        super(context, R.layout.carelayout, organ_name);

        this.context = context;
        this.organ_name = organ_name;
        this.desc = desc;
        this.imgid = imgid;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View r = convertView;
        ViewHolder viewHolder = null;
        if (r == null)
        {
            LayoutInflater layoutInflater = context.getLayoutInflater();
            r = layoutInflater.inflate(R.layout.carelayout,null,true);
            viewHolder = new ViewHolder(r);
            r.setTag(viewHolder);
        }

        else {
            viewHolder = (ViewHolder) r.getTag();
        }

        viewHolder.ivw.setImageResource(imgid[position]);
        viewHolder.tvw1.setText(organ_name[position]);
        viewHolder.tvw2.setText(desc[position]);
        return r;



    }
    static class  ViewHolder{
        TextView tvw1;
        TextView tvw2;
        ImageView ivw;
        ViewHolder (View v)
        {
            tvw1 = (TextView) v.findViewById(R.id.organname);
            tvw2 = (TextView) v.findViewById(R.id.reliefdescription);
            ivw =  (ImageView) v.findViewById(R.id.imageView);
        }
    }
}
