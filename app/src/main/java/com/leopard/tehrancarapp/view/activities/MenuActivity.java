package com.leopard.tehrancarapp.view.activities;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.widget.Toolbar;

import com.leopard.tehrancarapp.Fragments.AdminFragment;
import com.leopard.tehrancarapp.Fragments.SignInFragment;
import com.leopard.tehrancarapp.Fragments.SignUpFragment;
import com.leopard.tehrancarapp.R;

public class MenuActivity extends AppCompatActivity {

    //Defining Variables
    private android.support.v7.widget.Toolbar toolbar;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavigationView navigationView = (NavigationView)
                findViewById(R.id.navigation_view);

        SignInFragment signInFragment = new SignInFragment();
        android.support.v4.app.FragmentTransaction homeFragmentTransaction
                = getSupportFragmentManager().beginTransaction();
        homeFragmentTransaction.replace(R.id.frame, signInFragment);
        homeFragmentTransaction.commit();

        navigationView.setNavigationItemSelectedListener
                (new NavigationView.OnNavigationItemSelectedListener() {

                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        if (menuItem.isChecked()) menuItem.setChecked(false);
                        else menuItem.setChecked(true);


                        drawerLayout.closeDrawers();


                        switch (menuItem.getItemId()) {

                            case R.id.home:
                                SignInFragment signInFragment = new SignInFragment();
                                android.support.v4.app.FragmentTransaction homeFragmentTransaction
                                        = getSupportFragmentManager().beginTransaction();
                                homeFragmentTransaction.replace(R.id.frame, signInFragment);
                                homeFragmentTransaction.commit();
                                return true;

                            case R.id.a1:

                                SignUpFragment signUpFragment = new SignUpFragment();
                                android.support.v4.app.FragmentTransaction a1FragmentTransaction
                                        = getSupportFragmentManager().beginTransaction();
                                a1FragmentTransaction.replace(R.id.frame, signUpFragment);
                                a1FragmentTransaction.commit();
                                return true;

                            case R.id.a2:
                                AdminFragment adminFragment = new AdminFragment();
                                android.support.v4.app.FragmentTransaction a2FragmentTransaction
                                        = getSupportFragmentManager().beginTransaction();
                                a2FragmentTransaction.replace(R.id.frame, adminFragment);
                                a2FragmentTransaction.commit();
                                return true;

                            default:
                                Toast.makeText(getApplicationContext(), "Somethings Wrong", Toast.LENGTH_SHORT).show();
                                return true;

                        }
                    }
                });

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        ActionBarDrawerToggle actionBarDrawerToggle
                = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.openDrawer, R.string.closeDrawer) {

            @Override
            public void onDrawerClosed(View drawerView) {

                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };

        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        actionBarDrawerToggle.syncState();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        return id == R.id.action_settings || super.onOptionsItemSelected(item);

    }
}