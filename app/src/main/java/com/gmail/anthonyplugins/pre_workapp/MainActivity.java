package com.gmail.anthonyplugins.pre_workapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int current_color = 0;
    private int current_background = 0;
    private int[] colors = {0xFF000000, 0xFF808080, 0xFFFF0000, 0xFF800000, 0xFFFFFF00, 0xFF808000, 0xFF00FF00,
            0xFF008000, 0xFF00FFFF, 0xFF008080, 0xFF0000FF, 0xFF000080, 0xFFFF00FF, 0xFF800080};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((EditText) findViewById(R.id.text_input)).setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    EditText et = findViewById(R.id.text_input);
                    ((TextView) findViewById(R.id.welcome_text)).setText(et.getText().toString().trim().length() == 0 ?
                            getResources().getText(R.string.android_is_awesome) : et.getText().toString());
                    return true;
                }
                return false;
            }
        });
    }

    public void color_button_click(android.view.View view) {
        current_color++;
        ((TextView) findViewById(R.id.welcome_text)).setTextColor(colors[current_color % colors.length]);
    }

    public void background_button_click(android.view.View view) {
        current_background++;
        findViewById(R.id.background).setBackgroundColor(colors[current_background % colors.length] / 2 + 0x7FC04040);
    }

    public void string_button_click(android.view.View view) {
        EditText et = findViewById(R.id.text_input);
        ((TextView) findViewById(R.id.welcome_text)).setText(et.getText().toString().trim().length() == 0 ?
                getResources().getText(R.string.android_is_awesome) : et.getText().toString());
    }

    public void background_click(android.view.View view) {
        findViewById(R.id.background).setBackgroundColor(0xFFFFFFFF);
        TextView tv = findViewById(R.id.welcome_text);
        tv.setText(getResources().getText(R.string.hello_from_anthony));
        tv.setTextColor(0xFF000000);
        ((EditText) findViewById(R.id.text_input)).setText("");
    }
}
