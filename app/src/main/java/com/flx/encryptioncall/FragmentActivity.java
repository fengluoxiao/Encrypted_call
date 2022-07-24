package com.flx.encryptioncall;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.preference.PreferenceFragmentCompat;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.mosect.lib.immersive.ImmersiveLayout;
import com.mosect.lib.immersive.LayoutAdapter;

public class FragmentActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        ImmersiveLayout immersiveLayout = new ImmersiveLayout(this);
        immersiveLayout.addAdapter(new LayoutAdapter() {
            @Override
            public void onAdjustLayoutPadding(ImmersiveLayout layout) {
                bottomNavigationView.setPadding(0,0,0,layout.getPaddingBottom());
            }
        });
        immersiveLayout.requestLayout();
        if(getApplication().getResources().getConfiguration().uiMode == 0x21) {

            ImmersiveLayout.darkNavigationBar(this);
            ImmersiveLayout.darkStatusBar(this);

        } else {
            ImmersiveLayout.lightNavigationBar(this);
            ImmersiveLayout.lightStatusBar(this);

        }

        NavHostController navHostController = (NavHostController) Navigation.findNavController(this,R.id.fragment);
        NavigationUI.setupWithNavController(bottomNavigationView,navHostController);
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment, new SettingFragment())
                    .commit();
        }

    }
    public static class SettingFragment extends PreferenceFragmentCompat {
        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            NavController navController = Navigation.findNavController(getActivity(),R.id.fragment);
            navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
                @Override
                public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
                    Log.e("oshds", String.valueOf(destination.getId()));
                    switch(destination.getId()) {
                        case R.id.navigation_setting:
                           addPreferencesFromResource(R.xml.root_preferences);
                            break;
                        default:
                            setPreferencesFromResource(R.xml.blank, rootKey);
                            break;
                    }
                }
            });
        }

    }
}