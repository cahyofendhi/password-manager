package strom.com.passwordmanager;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import strom.com.passwordmanager.prefs.AppState;

public class SetPin extends AppCompatActivity {

    Activity activity;

    EditText pinOne;
    EditText pinTwo;
    Button setPin;

    AppState state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        //start
        // check open in the first time or not
        this.activity   = this;
        this.state  = new AppState(this);
        if (state.isOpened()){
            gotoNextPage(); // go to next page when app have been opened
        } else {
            setContentView(R.layout.activity_set_pin); // set layout of set pin activity

            pinOne = (EditText) findViewById(R.id.pin_first);
            pinTwo = (EditText) findViewById(R.id.pin_second);
            setPin = (Button) findViewById(R.id.set_pin);
            setPin.setOnClickListener(new View.OnClickListener() { // action click button set pin
                @Override
                public void onClick(View v) {
                    state.setHaveOpened(); // have opened
                    gotoNextPage(); // go to next page
                }
            });
        }
    }

    public void gotoNextPage(){ // go to next page
        startActivity(FingerPrint.instance(activity)); // go to fingerPrint activity
        finish(); // finish setPin activity
    }
    // end
}
