package strom.com.passwordmanager.prefs;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by DravitLochan on 23-09-2017.
 */

public class AppState {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Context context;

    String PREF_NAME = "password-checkfetchdetails";
    String STATE = "state";
    String IS_FIRST = "CHECK_OPEN_FIRST";

    public AppState(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(PREF_NAME, 0);
        editor = sharedPreferences.edit();
    }

    public boolean isVerified() {
        return sharedPreferences.getBoolean(STATE, false);
    }

    public void setVerified(boolean state) {
        editor.putBoolean(STATE, state);
        editor.commit();
    }

    /**
     * set when have open in first time
     */
    public void setHaveOpened(){
        editor.putBoolean(IS_FIRST, true);
        editor.commit();
    }

    /**
     * get status app opened
     * @return
     */
    public boolean isOpened(){
        return sharedPreferences.getBoolean(IS_FIRST, false);
    }

}
