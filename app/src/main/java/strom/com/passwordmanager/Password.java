package strom.com.passwordmanager;

import com.orm.SugarRecord;

/**
 * Created by DravitLochan on 23-09-2017.
 */

public class Password extends SugarRecord {

    String password;

    public Password(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
