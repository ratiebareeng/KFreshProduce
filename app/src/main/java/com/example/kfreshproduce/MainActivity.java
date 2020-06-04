package com.example.kfreshproduce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavController navController;
    private AppBarConfiguration appBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initLayoutViews();
        initToolbar();
        initNavController();
    }

    private void initLayoutViews() {
        drawerLayout = findViewById(R.id.drawer_layout);
    }

    private void initToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void initNavController() {
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph())
                .setOpenableLayout(drawerLayout)
                .build();

        NavigationView navigationView = findViewById(R.id.navigation_view);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        // setup nav controller and nav view
        NavigationUI.setupWithNavController(navigationView, navController);
        

    }

    @Override
    public boolean onSupportNavigateUp() {
        // IMPLEMENT TOOLBAR UP BUTTON
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}