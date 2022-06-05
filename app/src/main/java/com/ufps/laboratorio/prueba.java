package com.ufps.laboratorio;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

public class prueba extends AppCompatActivity {
     GoogleSignInOptions gso;
     GoogleSignInClient gsc;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(this, gso);

        GoogleSignInAccount acct =  GoogleSignIn.getLastSignedInAccount(this);
        //Iniciar sesion
        if(acct != null){
            String nombrePersona = acct.getDisplayName();
            String correoPersona = acct.getEmail();

        }

    }



}
