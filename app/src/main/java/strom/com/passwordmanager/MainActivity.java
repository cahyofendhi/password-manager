package strom.com.passwordmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import strom.com.passwordmanager.prefs.CheckFetchDetails;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ApplistAdapter applistAdapter;
    ArrayList<App> apps;
    CheckFetchDetails checkFetchDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkFetchDetails = new CheckFetchDetails(this);
        if (checkFetchDetails.getFirstTime()) {
            apps = new ArrayList<App>();
            App a = new App("facebook", "", "", "", "https://www.facebook.com/");
            a.save();
            apps.add(a);
            a = new App("twitter", "", "", "", "https://twitter.com/");
            a.save();
            apps.add(a);
            a = new App("card", "", "", "", "");
            a.save();
            apps.add(a);
            a = new App("WiFi Router", "", "", "", "");
            a.save();
            apps.add(a);
            a = new App("gmail", "", "", "", "https://mail.google.com");
            a.save();
            apps.add(a);
        } else {
            apps = new ArrayList<App>();
            List<App> appList = App.listAll(App.class);
            // apps = appList.toArray();
            apps = new ArrayList<App>(appList);
        }
        //apps.add("","","","","");
        recyclerView = (RecyclerView) findViewById(R.id.rv_apps);

        applistAdapter = new ApplistAdapter(apps, getApplicationContext());

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(applistAdapter);
        applistAdapter.notifyDataSetChanged();
    }

    public void appCardClicked() {

    }
}
