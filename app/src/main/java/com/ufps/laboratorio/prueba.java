package com.ufps.laboratorio;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.ufps.laboratorio.vista.InicioActivity;

public class prueba extends AppCompatActivity {
     GoogleSignInOptions gso;
     GoogleSignInClient gsc;
     Button signOutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signOutBtn = findViewById(R.id.sesion);

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(this, gso);

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if (acct!=null){
            String nombrePersona = acct.getDisplayName();
            String emailPersona = acct.getEmail();

        }

        signOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cerrarSesion();
            }
        });
    }

     void cerrarSesion() {
         gsc.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
             @Override
             public void onComplete( Task<Void> task) {
                 finish();
                // startActivity(new Intent(InicioActivity.this, MainActivity.class));
             }
         });
      }

}
