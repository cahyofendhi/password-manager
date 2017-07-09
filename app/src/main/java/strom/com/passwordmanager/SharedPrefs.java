package strom.com.passwordmanager;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by DravitLochan on 09-07-2017.
 */

public class SharedPrefs {

    private static final String PREF_NAME = "managePass";
    private static final String APPS = "apps";

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Context context;
    Set<String> a = new HashSet<String>(Arrays.asList("Facebook", "Twitter", "ATM card", "WiFi-router", "Gmail"));

    public SharedPrefs(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(PREF_NAME, 0);
        editor = sharedPreferences.edit();
    }

    public void setApps(Set<String> apps) {
        editor.putStringSet(APPS, apps);
        editor.commit();
    }

    public Set<String> getApps() {
        return sharedPreferences.getStringSet(APPS, a);
    }
}
