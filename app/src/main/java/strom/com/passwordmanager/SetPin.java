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
        this.activity   = this;
        this.state  = new AppState(this);
        if (state.isOpened()){
            gotoNextPage();
        } else {
            setContentView(R.layout.activity_set_pin);

            pinOne = (EditText) findViewById(R.id.pin_first);
            pinTwo = (EditText) findViewById(R.id.pin_second);
            setPin = (Button) findViewById(R.id.set_pin);
            setPin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    state.setHaveOpened(); // have opened
                    gotoNextPage();
                }
            });
        }
    }

    public void gotoNextPage(){
        startActivity(FingerPrint.instance(activity));
        finish();
    }

}
