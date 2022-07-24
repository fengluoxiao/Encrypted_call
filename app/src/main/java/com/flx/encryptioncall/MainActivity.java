package com.flx.encryptioncall;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceFragmentCompat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import com.google.android.material.color.DynamicColors;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sp = getSharedPreferences("com.example.myapplication_preferences", Context.MODE_PRIVATE);
        boolean dcolor = sp.getBoolean("dcolor", Boolean.parseBoolean(""));
        if(dcolor == true) {
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                DynamicColors.applyToActivitiesIfAvailable(this.getApplication());
            }
        } else {
            DynamicColors.applyToActivitiesIfAvailable(getApplication(),R.style.Theme_EncryptionCall);
        }
        Intent intent = new Intent(getApplicationContext(),FragmentActivity.class);
        startActivity(intent);
        finish();
    }


}