package strom.com.passwordmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ApplistAdapter applistAdapter;
    ArrayList<App> apps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apps = new ArrayList<App>();

        App a = new App("we","wef","wefwe","ttrhr","htr");
        apps.add(a);
        a = new App("erge","ger","ge","ger","ger");
        apps.add(a);
        a = new App("vere","egre","ergerge","egegev","gege");
        apps.add(a);
        a = new App("we","wef","wefwe","ttrhr","htr");
        apps.add(a);
        a = new App("erge","ger","ge","ger","ger");
        apps.add(a);

        //apps.add("","","","","");
        recyclerView = (RecyclerView) findViewById(R.id.rv_apps);

        applistAdapter = new ApplistAdapter(apps, getApplicationContext());

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(applistAdapter);
        applistAdapter.notifyDataSetChanged();
    }
}
