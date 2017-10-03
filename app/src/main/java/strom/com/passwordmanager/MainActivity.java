package strom.com.passwordmanager;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import strom.com.passwordmanager.prefs.AppState;
import strom.com.passwordmanager.prefs.CheckFetchDetails;

public class MainActivity extends AppCompatActivity {

    public static Intent instance(Context context){
        return new Intent(context, MainActivity.class);
    }

    RecyclerView recyclerView;
    ApplistAdapter applistAdapter;
    ArrayList<App> apps;
    CheckFetchDetails checkFetchDetails;
    AppState appState;

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

    @Override
    protected void onResume(){
        super.onResume();
        appState = new AppState(this);

        if(!appState.isVerified()) {
            Intent intent = new Intent(this, FingerPrint.class);
            startActivity(intent);
        }
    }

    @Override
    protected void onPause(){
        super.onPause();
        appState = new AppState(this);
        appState.setVerified(false);
        Log.i("status", appState.isVerified() + "");
    }

    @Override
    protected void onStop(){
        super.onStop();
        appState = new AppState(this);
        appState.setVerified(false);
        Log.i("status", appState.isVerified() + "");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        appState = new AppState(this);
        appState.setVerified(false);
        Log.i("status", appState.isVerified() + "");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        appState = new AppState(this);
        appState.setVerified(false);
        Log.i("status", appState.isVerified() + "");
    }
}
