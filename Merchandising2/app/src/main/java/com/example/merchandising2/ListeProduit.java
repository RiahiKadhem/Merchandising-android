package com.example.merchandising2;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
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

import com.example.merchandising2.entities.Produit;
import com.example.merchandising2.managers.ProduitManager;
import com.example.merchandising2.managers.TacheManager;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;


public class ListeProduit extends AppCompatActivity {
    Context ctx;
    View vp;
    LinearLayout llmain;
    ImageView img;
    ScrollView scrollView;
    TextView text,titre;
    String idSuccursale="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_produit);
        ctx=this;
        llmain=new LinearLayout(ctx);
        llmain.setOrientation(LinearLayout.VERTICAL);
        titre=new TextView(ctx);
        titre.setText("Liste des produits");
        titre.setGravity(Gravity.CENTER);
        titre.setTextSize(24);
        llmain.addView(titre);
        scrollView=findViewById(R.id.scrollView);
        idSuccursale=getIntent().getStringExtra("id_visite");
        ArrayList<Produit> produits = ProduitManager.getById(ctx,Integer.parseInt(idSuccursale));
//adding vue_produit component
        for(Produit p:produits) {
            vp = LayoutInflater.from(ctx).inflate(R.layout.vue_produit, null);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(900, 300);
            lp.setMargins(80, 100, 0, 0);
            img = vp.findViewById(R.id.img);
            text=vp.findViewById(R.id.text);
            InputStream ims = null;
            AssetManager am = ctx.getResources().getAssets();
            try {
                ims = am.open("images/produits/"+p.getImage()+".jfif");
                Bitmap bitmap = BitmapFactory.decodeStream(ims);
                img.setImageBitmap(bitmap);
                ims.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            text.setText("nom article :"+p.getLibelle_produit());
            vp.setLayoutParams(lp);
            vp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(ctx,DetailProduit.class);
                    intent.putExtra("libelle", ""+p.getLibelle_produit());
                    String idString=""+p.getId_produit();
                    intent.putExtra("id",idString);
                    intent.putExtra("nomImage",p.getImage());
                    intent.putExtra("id_visite",idSuccursale);
                    startActivity(intent);
                }
            });
            int test = TacheManager.getById(ctx,p.getId_produit(),Integer.parseInt(idSuccursale));
            if (test==1){
                vp.setBackgroundColor(Color.argb(200,0,200,0));
            }
            llmain.addView(vp);
        }
        scrollView.addView(llmain);


    }
}