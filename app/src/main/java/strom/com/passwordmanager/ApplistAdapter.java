package strom.com.passwordmanager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Set;

/**
 * Created by DravitLochan on 08-07-2017.
 */

public class ApplistAdapter extends RecyclerView.Adapter<ApplistAdapter.ViewHolder> {

    ArrayList<App> apps;
    Context context;
    SharedPrefs sharedPrefs;
    Set<String> appNames;
    TypedArray ids;

    public ApplistAdapter(ArrayList<App> apps, Context context) {
        this.apps = apps;
        this.context = context;
        sharedPrefs = new SharedPrefs(context);
        appNames = sharedPrefs.getApps();
        int i = 0;
        for (String name : appNames
                ) {
            apps.get(i).setAppName(name);
            ++i;
        }
        ids = context.getResources().obtainTypedArray(R.array.logos);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_applist_adapter, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.logo.setImageResource(ids.getResourceId(position, 0));
        holder.name.setText(apps.get(position).appName);

        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, AppProfile.class);
                intent.putExtra("position", position);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return apps.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageButton favourite;
        ImageView logo;
        TextView name;

        public ViewHolder(View itemView) {
            super(itemView);
            favourite = (ImageButton) itemView.findViewById(R.id.ib_favourite_app);
            logo = (ImageView) itemView.findViewById(R.id.iv_app_logo);
            name = (TextView) itemView.findViewById(R.id.tv_app_name);
        }
    }
}
