package com.example.merchandising2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.merchandising2.managers.EmployeeManager;

public class Login extends AppCompatActivity {
    Context ctx;
    private Button submit;
    private EditText username;
    private EditText password;
    TextView erreur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ctx=this;
        submit=findViewById(R.id.submit);
        username=findViewById(R.id.username);
        password=findViewById(R.id.mdp);
        erreur=findViewById(R.id.erreur);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = username.getText().toString();
                String mdp = password.getText().toString();
                int id= EmployeeManager.getId(ctx,userName,mdp);
                if(id!=0){
                    Intent intent = new Intent(ctx, ListeVisite.class);
                    intent.putExtra("idEmployee", ""+id);
                    startActivity(intent);
                }
                else {
                    erreur.setText("nom d'usager ou mot de passe incorrect");
                }

            }
        });

    }
}
