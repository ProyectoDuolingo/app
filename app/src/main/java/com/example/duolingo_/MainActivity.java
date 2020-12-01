package com.example.duolingo_;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Spinner;

import com.example.duolingo_.fragments.BotigaFragment;
import com.example.duolingo_.fragments.CursFragment;
import com.example.duolingo_.fragments.LligaFragment;
import com.example.duolingo_.fragments.PerfilFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView mBottomNavigation;
    Spinner spinner;
    CursFragment cursFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //spinner = findViewById(R.id.spinner);

        cursFragment = new CursFragment();



        mBottomNavigation = (BottomNavigationView) findViewById(R.id.bottomNAvigation);

        mBottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                if(menuItem.getItemId() == R.id.menu_curs){
                    showSelectedFragment(new CursFragment());
                }
                if(menuItem.getItemId() == R.id.menu_perfil){
                    showSelectedFragment(new PerfilFragment());
                }
                if(menuItem.getItemId() == R.id.menu_lliga){
                    showSelectedFragment(new LligaFragment());
                }
                if(menuItem.getItemId() == R.id.menu_botiga){
                    showSelectedFragment(new BotigaFragment());
                }



                return true;
            }
        });

    }

     private void showSelectedFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).commit();
     }

}