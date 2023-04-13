package com.example.grosskart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
   NavigationView navigationView;
    Toolbar toolbarOption;
    TextView txtViewEmail;
   BottomNavigationView bnView;
   FirebaseAuth auth;
   FirebaseUser user;

   ImageSlider imageSlider;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Finding IDS
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        drawerLayout = findViewById(R.id.drawableLayout);
        navigationView = findViewById(R.id.navigation_drawer);
        toolbarOption = findViewById(R.id.toolbar_option);
        View drawerHead = navigationView.getHeaderView(0);
        txtViewEmail = drawerHead.findViewById(R.id.txtViewProfileEmail);
        bnView = findViewById(R.id.bottom_navigation);


        txtViewEmail.setText(user.getEmail());

        setTitle(" ");

        setSupportActionBar(toolbarOption);

        ActionBarDrawerToggle toggle = new
                ActionBarDrawerToggle(this, drawerLayout, toolbarOption, R.string.openDrawer, R.string.closeDrawer);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id= item.getItemId();

                if(id==R.id.home_menu){
                    loadFrag(new Home_frag(), false);
                }else if(id==R.id.cart_menu){
                    loadFrag(new CartFrag(), false);
                }else if(id==R.id.support_menu){
                    loadFrag(new SupportFrag(), false);

                }else if(id==R.id.help_menu){
                    loadFrag(new HelpFrag(), false);
                }else if(id==R.id.profile_menu){
                    loadFrag(new profile_fragment(), false);
                }else{
                    FirebaseAuth.getInstance().signOut();
                    Intent intent = new Intent(MainActivity.this, login.class);
                    startActivity(intent);
                    finish();
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
        bnView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if(id==R.id.bn_home){
                    loadFrag(new Home_frag(), false);
                }else if(id==R.id.bn_cart){
                    loadFrag(new CartFrag(), false);
                }else if(id==R.id.bn_profile){
                    loadFrag(new profile_fragment(), false);
                }else{
                    loadFrag(new SupportFrag(), false);
                }
                return true;
            }
        });
        bnView.setSelectedItemId(R.id.bn_home);

    }

    @Override
    public void onBackPressed() {
       if(drawerLayout.isDrawerOpen(GravityCompat.START)){
           drawerLayout.closeDrawer(GravityCompat.START);
       }else{
           super.onBackPressed();
       }
    }

    private  void loadFrag(Fragment fragment, boolean flag){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        if(flag){
            ft.add(R.id.containerFrameLayout, fragment);
        }else{
            ft.replace(R.id.containerFrameLayout, fragment);
        }

        ft.commit();
    }
}