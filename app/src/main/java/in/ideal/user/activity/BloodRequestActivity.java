package in.ideal.user.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import in.ideal.user.models.UserNames;
import in.ideal.user.xml.XMLPullParserHandler;

/**
 * Created by Siva on 9/13/2015.
 */
public class BloodRequestActivity extends ActionBarActivity {
    ListView listView;
    private Toolbar mToolbar;
    Typeface typeface;
    String myjsonstring;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bloodrequest);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        typeface = Typeface.createFromAsset(this.getAssets(), "fonts/ProximaNova-Reg.ttf");
       // TextView tvResult = (TextView) findViewById(R.id.tvResult);
        typeface = Typeface.createFromAsset(this.getAssets(), "fonts/ProximaNova-Reg.ttf");
       // tvResult.setTypeface(typeface);
        listView = (ListView) findViewById(R.id.list);

        List<UserNames> userNames = null;
        try {
            XMLPullParserHandler parser = new XMLPullParserHandler();
            userNames = parser.parse(getAssets().open("bloodrequest.xml"));
            ArrayAdapter<UserNames> adapter =
                    new ArrayAdapter<UserNames>(this,R.layout.list_item, userNames);
            listView.setAdapter(adapter);
        } catch (IOException e) {
            e.printStackTrace();
        }
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