package com.example.merchandising2;


import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.InputStream;

public class DetailVisite extends AppCompatActivity {
    Context ctx;
    View vp;
    LinearLayout llmain;
    ImageView img;
    TextView text,text1,text2;
    Button terminer, retour;
    LinearLayout buttonGroup;
    String libelleSuccursale="";
    String libelleMagasin="";
    String adresse="";
    String nomImage="";
    String idString="";
    int id=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ctx = this;
        llmain= new LinearLayout(ctx);
        llmain.setOrientation(LinearLayout.VERTICAL);

        libelleSuccursale=getIntent().getStringExtra("libelle_succursale");
        idString=getIntent().getStringExtra("id_visite");
        libelleMagasin = getIntent().getStringExtra("libelle_magasin");
        adresse=getIntent().getStringExtra("adresse");
        img = new ImageView(ctx);
        InputStream ims = null;
        AssetManager am = ctx.getResources().getAssets();
        try {
            ims = am.open("images/magasins/"+libelleMagasin+".jpg");
            Bitmap bitmap = BitmapFactory.decodeStream(ims);
            img.setImageBitmap(bitmap);
            ims.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        llmain.addView(img);
        text1= new TextView(ctx);
        text1.setText("Nom  Magasin : \n"+libelleSuccursale);
        text1.setTextSize(25);
        llmain.addView(text1);

        text2= new TextView(ctx);
        text2.setText("Adresse : \n"+adresse);
        text2.setTextSize(20);
        llmain.addView(text2);

        buttonGroup = new LinearLayout(ctx);
        buttonGroup.setOrientation(LinearLayout.HORIZONTAL);
        terminer = new Button(ctx);
        terminer.setText("COMMENCER");
        terminer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ctx,ListeProduit.class);
                intent.putExtra("id_visite",idString);
                startActivity(intent);
            }
        });
        retour = new Button(ctx);
        retour.setText("RETOUR");
        buttonGroup.addView(retour);
        buttonGroup.addView(terminer);



        llmain.addView(buttonGroup);
        ScrollView scrollView = new ScrollView(ctx);
        scrollView.addView(llmain);


        setContentView(scrollView);


    }
}
