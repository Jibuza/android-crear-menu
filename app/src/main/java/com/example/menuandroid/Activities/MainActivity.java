package com.example.menuandroid.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;

import com.example.menuandroid.Fragments.Biblioteca;
import com.example.menuandroid.Fragments.Leyendo;
import com.example.menuandroid.Fragments.Papelera;
import com.example.menuandroid.R;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    //menu
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;


    //declaracion de fragmentos y transacion
    //despues se definiran con su respectiva clase para la navegacion
    //fragmentLeyendo == Fragmento inicial
    FragmentTransaction transactioni;
    Fragment fragmentLeyendo, fragmentBiblioteca, fragmentPapelera;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Instancia de diseño de cajón para alternar el icono de menú para abrir
        //Cajón y botón de retroceso para cerrar el cajón
        drawerLayout = findViewById(R.id.my_drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);

        //Pase el botón de alternancia Abrir y Cerrar para el detector de diseño de cajón
        //Para alternar el botón
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        // para que el icono del cajón de navegación aparezca siempre en la barra de acciones
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView=(NavigationView) findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);

        //Creacion de objetos fragment y transaction
        //esto despues se carga en el metedo onNavigationItemSelect para el cambio de dicho fragmento
        fragmentLeyendo = new Leyendo();
        fragmentBiblioteca = new Biblioteca();
        fragmentPapelera = new Papelera();

        // de esta forma al iniciar el programa entrara en el fragmen leyendo
         getSupportFragmentManager().beginTransaction().add(R.id.frame_layout,fragmentLeyendo).commit();

    }

    // Cierra el menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // se ejecuta cuando el usuario selecciona un item del menu
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        gestorTransiciones(item.getItemId());
        return false;
    }

    //realiza la transicion entre fragmentos
    public void gestorTransiciones(int id){
        transactioni = getSupportFragmentManager().beginTransaction();
        switch (id){
            case R.id.nav_leyendo:
                transactioni.replace(R.id.frame_layout,fragmentLeyendo).commit();
                break;
            case R.id.nav_biblioteca:
                transactioni.replace(R.id.frame_layout,fragmentBiblioteca).commit();;
                break;
            case R.id.nav_papelera:
                transactioni.replace(R.id.frame_layout,fragmentPapelera).commit();
                break;
        }
        // cierra el menu despues de la transicion
        this.drawerLayout.closeDrawer(Gravity.LEFT);
    }
}