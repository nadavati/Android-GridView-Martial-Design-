package in.ideal.user.activity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;


/**
 * Created by Siva on 9/6/2015.
 */
public class TeamActivity extends ActionBarActivity {
    private Toolbar mToolbar;
    Typeface typeface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        typeface = Typeface.createFromAsset(this.getAssets(), "fonts/ProximaNova-Reg.ttf");
        TextView textView0 = (TextView) findViewById(R.id.textView0);
        textView0.setTypeface(typeface);
        TextView textView1 = (TextView) findViewById(R.id.textView1);
        textView1.setTypeface(typeface);
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        textView2.setTypeface(typeface);
        TextView textView3 = (TextView) findViewById(R.id.textView3);
        textView3.setTypeface(typeface);
        TextView textView4 = (TextView) findViewById(R.id.textView4);
        textView4.setTypeface(typeface);
        TextView textView5 = (TextView) findViewById(R.id.textView5);
        textView5.setTypeface(typeface);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}