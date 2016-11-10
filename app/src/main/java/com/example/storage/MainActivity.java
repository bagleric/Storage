package com.example.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int count = 0;
    public static final String PREFS_NAME = "MyPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        count = sharedPreferences.getInt(PREFS_NAME, 0);
        TextView textView = (TextView) findViewById(R.id.number);
        textView.setText(Integer.toString(count));


        Button buttonSave = (Button) findViewById(R.id.advance);
        buttonSave.setOnClickListener(advance);

        Button buttonAdvance = (Button) findViewById(R.id.save);
        buttonAdvance.setOnClickListener(save);
    }

    private View.OnClickListener advance = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            count = count + 1;
            TextView textView = (TextView) findViewById(R.id.number);
            textView.setText(Integer.toString(count));
            Toast.makeText(MainActivity.this, "Advance Count", Toast.LENGTH_SHORT).show();
        }
    };
            private View.OnClickListener save = new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    SharedPreferences.Editor editor = getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit();
                    editor.putInt(PREFS_NAME, count);
                    editor.commit();
                    Toast.makeText(MainActivity.this, "Advanced Saved", Toast.LENGTH_SHORT).show();
                }
            };

}


