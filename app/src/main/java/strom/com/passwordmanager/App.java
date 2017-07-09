package strom.com.passwordmanager;

import com.orm.SugarRecord;

/**
 * Created by DravitLochan on 08-07-2017.
 */

public class App extends SugarRecord {
    String appName;
    String password;
    String userName;
    String emailId;
    String webSite;

    public App(String appName, String password, String userName, String emailId, String webSite) {

        this.appName = appName;
        this.password = password;
        this.userName = userName;
        this.emailId = emailId;
        this.webSite = webSite;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }
}
