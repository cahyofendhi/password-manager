package strom.com.passwordmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

public class SetPin extends AppCompatActivity {

    EditText pinOne;
    EditText pinTwo;
    Button setPin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_pin);

        pinOne = (EditText) findViewById(R.id.pin_first);
        pinTwo = (EditText) findViewById(R.id.pin_second);
        setPin = (Button) findViewById(R.id.set_pin);

        pinTwo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}
