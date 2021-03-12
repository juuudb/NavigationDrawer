package com.example.navigationdrawer;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;

import java.net.URI;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //FAB
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviarEmail();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_principal, R.id.nav_servicos, R.id.nav_clientes,
                R.id.nav_contato,R.id.nav_sobre
                )
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    public void enviarEmail(){
        String celular = "tel: 11996352864";
        String imagem = "https://www.melhoresdestinos.com.br/wp-content/uploads/2020/06/praias-brasil-sancho.jpg";
        String endereco = "https://www.google.com/maps/place/Parque+Ibirapuera/@-23.5874162,-46.6598223,17z/data=!3m1!4b1!4m5!3m4!1s0x94ce59f1069d11d1:0xcb936109af9ce541!8m2!3d-23.5874162!4d-46.6576336?hl=pt-BR";
//      Intent intent = new Intent( Intent.ACTION_DIAL, Uri.parse(celular)); faz uma ligação
      //Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse(imagem)); mostra a imagem no browser//Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse(endereco)); mostra o endereço no app google maps
        Intent intent = new Intent( Intent.ACTION_SEND);

        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"atendimento@atmconsultoria.com.br"}); //email
        intent.putExtra(Intent.EXTRA_SUBJECT, "Contato pelo App"); //
        intent.putExtra(Intent.EXTRA_TEXT, "Mensagem Automática"); //corpo do email

        intent.setType("message/rfc822"); //tipo para envio de email
        //intent.setType("text/plain"); // aparecem varios outros app, como facebook, whats etc
       // intent.setType("image/*");//abre qualquer tipo de imagem, abrem apps de imagens

        startActivity(Intent.createChooser( intent, "Escolha um app de email"));
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
