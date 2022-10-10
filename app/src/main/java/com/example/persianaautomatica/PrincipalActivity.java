package com.example.persianaautomatica;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class PrincipalActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        //Fragmento Pantalla Principal
        ControlFragment CF = new ControlFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,CF).commit();

        //Referencia al Toolbar
        Toolbar tb = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(tb);

        /*Incorporacion SideBar*/
        NavigationView nav = (NavigationView) findViewById(R.id.nav);
        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //Recuperar opcion del menu seleccionado
                int id = item.getItemId();
                if (id==R.id.op1){
                    Toast.makeText(getApplicationContext(),"vas al control",Toast.LENGTH_SHORT).show();
                    ControlFragment CF = new ControlFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,CF).commit();
                }
                else if (id==R.id.op2){
                    Toast.makeText(getApplicationContext(),"vas a configuracion",Toast.LENGTH_SHORT).show();
                    ConfiguracionFragment ConF = new ConfiguracionFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,ConF).commit();
                }
                else if (id==R.id.op3){
                    Toast.makeText(getApplicationContext(),"vas a registro",Toast.LENGTH_SHORT).show();
                    RegistroFragment RF = new RegistroFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,RF).commit();
                }
                return false;
            }
        });
        DrawerLayout dl = (DrawerLayout) findViewById(R.id.principal);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Que se muestre boton que permite desplegar DL
        getSupportActionBar().setHomeButtonEnabled(true); //Indica que el btn btnenabled exista

        //toggle permite que sidebar se oculte y se muestre a raiz del boton
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,
                dl,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
        ); //toggle declarado
        dl.addDrawerListener(toggle); //indicamos que drawer esta asociado a toggle
        toggle.syncState();

        tb.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(dl.isDrawerOpen(GravityCompat.START)){
                    dl.closeDrawer(GravityCompat.START);
                }
                else{
                    dl.openDrawer((int) Gravity.START);
                }
            }
        });

    }

}