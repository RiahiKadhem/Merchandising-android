package com.example.merchandising2;


import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.merchandising2.entities.Magasin;
import com.example.merchandising2.entities.Produit;
import com.example.merchandising2.entities.Visite;
import com.example.merchandising2.managers.MagasinManager;
import com.example.merchandising2.managers.ProduitManager;
import com.example.merchandising2.managers.VisiteManager;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;


public class ListeVisite extends AppCompatActivity {
    Context ctx;
    View vp;
    LinearLayout llmain;
    ImageView img;
    ScrollView scrollView;
    TextView text,titre;
    String idEmployee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_visite);
        ctx=this;
        llmain=new LinearLayout(ctx);
        llmain.setOrientation(LinearLayout.VERTICAL);
        titre=new TextView(ctx);
        titre.setText("Liste des visites");
        titre.setGravity(Gravity.CENTER);
        titre.setTextSize(24);
        llmain.addView(titre);
        scrollView=findViewById(R.id.scrollView);
        idEmployee=getIntent().getStringExtra("idEmployee");
        ArrayList<Visite> visites = VisiteManager.getAll(ctx,idEmployee);
        for(Visite v:visites) {
            vp = LayoutInflater.from(ctx).inflate(R.layout.vue_produit, null);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(900, 300);
            lp.setMargins(80, 100, 0, 0);
            img = vp.findViewById(R.id.img);
            text=vp.findViewById(R.id.text);
            InputStream ims = null;
            AssetManager am = ctx.getResources().getAssets();
            Magasin m = MagasinManager.getById(ctx,v.getId_succursale());
            try {
                ims = am.open("images/logos/"+m.getLibelle_magasin()+".png");
                Bitmap bitmap = BitmapFactory.decodeStream(ims);
                img.setImageBitmap(bitmap);
                ims.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            text.setText("nom magasin :"+m.getLibelle_succursale());
            vp.setLayoutParams(lp);
            vp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(ctx,DetailVisite.class);
                    intent.putExtra("libelle_succursale", ""+m.getLibelle_succursale());
                    String idString=""+v.getId_visite();
                    intent.putExtra("id_visite",idString);
                    intent.putExtra("libelle_magasin",m.getLibelle_magasin());
                    intent.putExtra("adresse",m.getAdresse());
                    startActivity(intent);
                }
            });

            llmain.addView(vp);
        }
        scrollView.addView(llmain);


    }
}