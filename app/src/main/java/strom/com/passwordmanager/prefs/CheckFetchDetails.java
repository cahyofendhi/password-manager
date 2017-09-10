package strom.com.passwordmanager.prefs;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by DravitLochan on 10-09-2017.
 */

public class CheckFetchDetails {

    String PREF_NAME = "password-checkfetchdetails";
    String FIRST_TIME = "first-time";

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Context context;

    public CheckFetchDetails(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(PREF_NAME, 0);
        editor = sharedPreferences.edit();
    }

    public boolean getFirstTime() {
        return sharedPreferences.getBoolean(FIRST_TIME, true);
    }

    public void setFirstTime(boolean firstTime) {
        editor.putBoolean(FIRST_TIME, firstTime);
        editor.commit();
    }
}
