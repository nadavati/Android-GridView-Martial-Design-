package in.ideal.user.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;



/**
 * Created by Siva on 9/11/2015.
 */
public class CustomAdapter extends BaseAdapter {
    Typeface typeface;
    String [] result;
    Context context;
    int [] imageId;
    private static LayoutInflater inflater=null;
    public CustomAdapter(MainActivity mainActivity, String[] prgmNameList, int[] prgmImages) {
        // TODO Auto-generated constructor stub
        result=prgmNameList;
        context=mainActivity;
        imageId=prgmImages;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder
    {
        TextView tv;
        ImageView img;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder=new Holder();
        View rowView;

        rowView = inflater.inflate(R.layout.grid_view, null);
        holder.tv=(TextView) rowView.findViewById(R.id.textView1);
        holder.img=(ImageView) rowView.findViewById(R.id.imageView1);
        typeface = Typeface.createFromAsset(context.getAssets(), "fonts/ProximaNova-Reg.ttf");
        holder.tv.setTypeface(typeface);
        holder.tv.setText(result[position]);
        holder.img.setImageResource(imageId[position]);
        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int bloodRequest = 0;
                int bloodDonors = 1;
                int ourTeam = 2;
               int weSupport = 4;
                int aboutUS = 3;
                if (position == bloodRequest) {
                    Intent intent = new Intent(context, BloodRequestActivity.class);
                    context.startActivity(intent);
                } else if(position==bloodDonors){
                    Intent intent = new Intent(context, DonorsActivity.class);
                    context.startActivity(intent);
                }
                else if (position == aboutUS) {
                    Intent intent = new Intent(context, AboutActivity.class);
                    context.startActivity(intent);
                }
                else if (position == ourTeam) {
                    Intent intent = new Intent(context, TeamActivity.class);
                    context.startActivity(intent);
                }
                else if (position == weSupport) {
                    Intent intent = new Intent(context, BloodDonationFactsActivity.class);
                    context.startActivity(intent);
                }
            }
        });

        return rowView;
    }

}
