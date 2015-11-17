package in.ideal.user.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import java.util.ArrayList;

public class MainActivity extends ActionBarActivity {
    private Toolbar mToolbar;

    GridView gv;
    Context context;
    ArrayList prgmName;
    Typeface typeface;
    public static String [] prgmNameList = {"Blood Request","Blood Donors Signup","Team","About","Blood Donation Facts"};
    public static int [] prgmImages={R.drawable.blood_req,R.drawable.ic_donors,R.drawable.ic_team,R.drawable.ic_about,R.drawable.blood_donors};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        gv=(GridView) findViewById(R.id.gridview);
        gv.setAdapter(new CustomAdapter(this, prgmNameList,prgmImages));
        typeface = Typeface.createFromAsset(this.getAssets(), "fonts/ProximaNova-Reg.ttf");
        TextView textView =(TextView) findViewById(R.id.label);
        TextView textView1 =(TextView) findViewById(R.id.label1);
        textView1.setTypeface(typeface);
        textView.setTypeface(typeface,Typeface.BOLD);
    }
    public void goNext(View view){
        Intent intent = new Intent(MainActivity.this,DonorsActivity.class);
        startActivity(intent);
    }
}