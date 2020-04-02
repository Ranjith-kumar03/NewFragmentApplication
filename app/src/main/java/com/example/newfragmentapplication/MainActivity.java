package com.example.newfragmentapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, MainFragment.ButtonOnClick {
    private static final String TAG ="MainActivity";
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;
    NavigationView navigationView;
    FragmentManager manager;
    FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout=findViewById(R.id.drawerLayout);
        navigationView=findViewById(R.id.navigationView);
       navigationView.setNavigationItemSelectedListener(this);
        actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.OpenDrawer,R.string.CloseDrawer);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();
        manager=this.getSupportFragmentManager();
        transaction=manager.beginTransaction();
        transaction.add(R.id.fragmentContainer, new MainFragment()).commit();
    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawer(GravityCompat.START);
        switch(item.getItemId())
        {
            case R.id.home:
                transaction=manager.beginTransaction();
                transaction.replace(R.id.fragmentContainer, new MainFragment()).commit();
                break;
            case R.id.login:
                transaction=manager.beginTransaction();
                transaction.replace(R.id.fragmentContainer, new HomeFragment()).commit();
                break;
            case R.id.logout:
               Intent intent=new Intent(this,SenderActivity.class);
               startActivity(intent);
                break;
            case R.id.home1:
                Toast.makeText(this, "Home1 Clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.login1:
                Toast.makeText(this, "Login1 Clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.logout1:
                Toast.makeText(this, "Logout1  Clicked", Toast.LENGTH_SHORT).show();
                break;
            default:
                Log.d(TAG, "onClick: Nothing Clicked ");
        }
        return true;
    }

    @Override
    public void ButtionClickToMain() {
        Toast.makeText(this, "Iam clicked from Main Activity ", Toast.LENGTH_SHORT).show();
    }
}
