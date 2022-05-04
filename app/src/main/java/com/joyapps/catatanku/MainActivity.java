package com.joyapps.catatanku;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.mainActivity_bottomNavView);

        this.setupBottomNavigationView();
    }

    public void setupBottomNavigationView() {
        NavController navController = Navigation.findNavController(findViewById(R.id.mainActivity_navFragment));
        NavigationUI.setupWithNavController(bottomNavigationView, navController);

        navController.addOnDestinationChangedListener((controller, destination, arguments) -> {
            if (destination.getId() == R.id.loginFragment ||
            destination.getId() == R.id.signUpFragment) {
                bottomNavigationView.setVisibility(View.GONE);
            }
            else {
                bottomNavigationView.setVisibility(View.VISIBLE);
            }
        });
    }
//    public Fragment getForegroundFragment(){
//        Fragment navHostFragment = getSupportFragmentManager().findFragmentById(R.id.mainActivity_navFragment);
//        return navHostFragment == null ? null : navHostFragment.getChildFragmentManager().getFragments().get(0);
//    }

//    @Override
//    public void onBackPressed() {
//        Fragment currentFragment = getForegroundFragment();
//        if (bottomNavigationView.getSelectedItemId() == R.id.salesFragment ||
//                currentFragment.getClass() == loginFragment.class) {
//            this.finishAffinity();
//        } else {
//            bottomNavigationView.setSelectedItemId(R.id.salesFragment);
//        }
//    }
}
