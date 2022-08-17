package com.example.myapplication;

import android.app.ActivityManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.SwitchPreferenceCompat;

import com.zackratos.ultimatebarx.ultimatebarx.java.UltimateBarX;

public class SettingsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);
        if(this.getApplication().getResources().getConfiguration().uiMode == 0x21) {
            UltimateBarX.statusBar(this).transparent().light(false).apply();
            UltimateBarX.navigationBar(this).transparent().light(false).apply();
        } else {
            UltimateBarX.statusBar(this).transparent().light(true).apply();
            UltimateBarX.navigationBar(this).transparent().light(true).apply();
        }
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.settings, new SettingsFragment())
                    .commit();
        }
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }
    public static class SettingsFragment extends com.example.myapplication.SettingsFragment implements Preference.OnPreferenceChangeListener,Preference.OnPreferenceClickListener{
       ListPreference listPreference;
        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            SettingsFragment context = this;
            SharedPreferences sharedPreferences = getActivity().getSharedPreferences("com.example.myapplication_preferences", Context.MODE_PRIVATE);
            boolean st = sharedPreferences.getBoolean("translate", Boolean.parseBoolean(""));
            setPreferencesFromResource(R.xml.root_preferences, rootKey);
            Preference trancelate = findPreference("translate");
            Preference about = findPreference("about_sss");
            Preference dcolor = findPreference("dcolor");
            listPreference = findPreference("translate_list");
           if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.S_V2) {
               dcolor.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                   @Override
                   public boolean onPreferenceClick(Preference preference) {
                       AlertDialog.Builder alertDialog = new AlertDialog.Builder(getContext());
                       alertDialog.setMessage(R.string.dcolor_message);
                       alertDialog.setTitle(R.string.dcolor_title);
                       alertDialog.setPositiveButton(R.string.dcolor_ok, new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialogInterface, int i) {
                                   final Intent intent = getActivity().getPackageManager().getLaunchIntentForPackage(getActivity().getPackageName());
                                   intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                   startActivity(intent);
                           }
                       });
                       alertDialog.show();
                       return true;
                   }
               });
           } else {
               SwitchPreferenceCompat switchPreferenceCompat = findPreference("dcolor");
               switchPreferenceCompat.setSummaryOn(switchPreferenceCompat.getSummaryOn()+ (String)getText(R.string.dcolor_alert_ver));
               switchPreferenceCompat.setSummaryOff(switchPreferenceCompat.getSummaryOff()+ (String)getText(R.string.dcolor_alert_ver));
               dcolor.setEnabled(false);
           }
            listPreference.setOnPreferenceChangeListener(this);
            listPreference.setSummary(listPreference.getEntry());
            if(String.valueOf(st) == "false") {
                listPreference.setEnabled(false);
            } else {
                listPreference.setEnabled(true);
                CharSequence[] values = listPreference.getEntries();
                listPreference.setDefaultValue(values[0]);
            }
            trancelate.setDefaultValue(false);
            if(trancelate != null) {
                trancelate.setOnPreferenceChangeListener(this);
            }
            about.setOnPreferenceClickListener(this);
        }
        @Override
        public boolean onPreferenceChange(Preference preference, Object newValue) {
            ListPreference listPreference;
            if(preference instanceof ListPreference) {
                ListPreference listPreference1 = (ListPreference) preference;
                CharSequence[] entries = listPreference1.getEntries();
                int index =  listPreference1.findIndexOfValue((String) newValue);
                listPreference1.setSummary(entries[index]);
                return true;
            }
            String key = preference.getKey();
            boolean ss = (boolean) newValue;
            listPreference = findPreference("translate_list");
            if(key.equals("translate") && ss == true ) {
                CharSequence[] values = listPreference.getEntries();
                listPreference.setDefaultValue(values[0]);
                listPreference.setEnabled(true);

            } else {
                listPreference.setEnabled(false);
            }
            return true;
        }
        @Override
        public boolean onPreferenceClick(Preference preference) {
            AlertDialog.Builder dialog=new AlertDialog.Builder(getContext());
            dialog.setTitle(R.string.about);
            dialog.setMessage(R.string.useless_msg);
            dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            dialog.show();
           return true;
        }
    }
}