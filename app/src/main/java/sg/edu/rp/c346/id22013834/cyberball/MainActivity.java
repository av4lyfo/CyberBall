package sg.edu.rp.c346.id22013834.cyberball;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    EditText etUserName;
    ToggleButton toggleMode;
    Button btnLoad, btnSave;

    final String SOLO_MODE = "SoloMode";
    final String MULTI_MODE = "MultiMode";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUserName = findViewById(R.id.etUserName);
        toggleMode = findViewById(R.id.toggleMode);
        btnLoad = findViewById(R.id.btnLoad);
        btnSave = findViewById(R.id.btnSave);

        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences prefs = getPreferences(MODE_PRIVATE);
                String msg;

                if (toggleMode.isChecked()) {
                    msg = prefs.getString(MULTI_MODE, "Player X");
                } else {
                    msg = prefs.getString(SOLO_MODE, "Solo Player X");
                }

                etUserName.setText(msg);
            }
        });


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = getPreferences(MODE_PRIVATE).edit();
                String name = etUserName.getText().toString();

                if (toggleMode.isChecked()) {
                    editor.putString(MULTI_MODE, name);
                } else {
                    editor.putString(SOLO_MODE, name);
                }

                editor.apply();
            }
        });

    }
}