package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.color.DynamicColors;
import com.zackratos.ultimatebarx.ultimatebarx.java.UltimateBarX;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(getApplication().getResources().getConfiguration().uiMode == 0x21) {
            UltimateBarX.statusBar(this).transparent().light(false).apply();
            UltimateBarX.navigationBar(this).transparent().light(false).apply();
        } else {
            UltimateBarX.statusBar(this).transparent().light(true).apply();
            UltimateBarX.navigationBar(this).transparent().light(true).apply();
        }
        SharedPreferences sp = getSharedPreferences("com.example.myapplication_preferences", Context.MODE_PRIVATE);
        boolean dcolor = sp.getBoolean("dcolor", Boolean.parseBoolean(""));
        if(dcolor == true) {
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                DynamicColors.applyToActivitiesIfAvailable(this.getApplication());
            }
            } else {
                DynamicColors.applyToActivitiesIfAvailable(getApplication(),R.style.Theme_MyApplication);
            }
        Log.e("boadshi", String.valueOf(dcolor));
        Intent intent = new Intent(getApplicationContext(),encoding.class);
        startActivity(intent);
        finish();

    }


}