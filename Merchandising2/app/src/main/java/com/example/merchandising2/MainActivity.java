package com.example.merchandising2;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
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

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.merchandising2.entities.Produit;
import com.example.merchandising2.managers.ProduitManager;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    Context ctx;
    View vp;
    LinearLayout llmain;
    ImageView img;
    ScrollView scrollView;
    TextView text,text1,text2,text3,text4,text5;
    Button produitExistant, emplacement, typePromo;
    EditText prix;
    EditText commentaire;
    Button terminer, retour;
    LinearLayout buttonGroup;
    String produitExistantValue,emplacementValue,typePromoValue,prixValue,cmntValue;
    RadioGroup produitExistantRg,emplacementRg,typePromoRg;
    RadioButton radioButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ctx = this;
        llmain= new LinearLayout(ctx);
        llmain.setOrientation(LinearLayout.VERTICAL);
        LayoutInflater layoutInflater = LayoutInflater.from(MainActivity.this);
        View produitExistantAlert = layoutInflater.inflate(R.layout.produit_existant_rg, null);
        View emplacementAlert = layoutInflater.inflate(R.layout.vue_emplacement, null);
        View typePromoAlert = layoutInflater.inflate(R.layout.vue_type_promo, null);


        img = new ImageView(ctx);
        llmain.addView(img);
        text1= new TextView(ctx);
        text1.setText("Produit existant");
        text1.setTextSize(20);
        llmain.addView(text1);
        produitExistant = new Button(ctx);
        produitExistant.setText("choisir");
        produitExistant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
                builder.setView(produitExistantAlert);
                builder.show();
                produitExistantRg=produitExistantAlert.findViewById(R.id.produitExistant);
                produitExistantRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        {
                            int selectedId=produitExistantRg.getCheckedRadioButtonId();
                            radioButton=produitExistantAlert.findViewById(selectedId);
                            produitExistantValue=radioButton.getText().toString();
                            produitExistant.setText(produitExistantValue);

                        }
                    }
                });

            }
        });
        llmain.addView(produitExistant);
        text2= new TextView(ctx);
        text2.setText("Emplacement");
        text2.setTextSize(20);
        llmain.addView(text2);
        emplacement = new Button(ctx);
        emplacement.setText("choisir");
        emplacement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder2 = new AlertDialog.Builder(ctx);
                builder2.setView(emplacementAlert);
                builder2.show();
                emplacementRg=emplacementAlert.findViewById(R.id.emplacement);
                emplacementRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        {
                            int selectedId=emplacementRg.getCheckedRadioButtonId();
                            radioButton=emplacementAlert.findViewById(selectedId);
                            emplacementValue=radioButton.getText().toString();
                            emplacement.setText(emplacementValue);
                        }
                    }
                });
            }
        });
        llmain.addView(emplacement);
        text3= new TextView(ctx);
        text3.setText("Type promotion");
        text3.setTextSize(20);
        llmain.addView(text3);
        typePromo = new Button(ctx);
        typePromo.setText("choisir");
        typePromo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder3 = new AlertDialog.Builder(ctx);
                builder3.setView(typePromoAlert);
                builder3.show();
                typePromoRg=typePromoAlert.findViewById(R.id.type_promo);
                typePromoRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        {
                            int selectedId=typePromoRg.getCheckedRadioButtonId();
                            radioButton=typePromoAlert.findViewById(selectedId);
                            typePromoValue=radioButton.getText().toString();
                            typePromo.setText(typePromoValue);
                        }
                    }
                });
            }
        });
        llmain.addView(typePromo);
        text4= new TextView(ctx);
        text4.setText("Prix");
        text4.setTextSize(20);
        llmain.addView(text4);
        prix = new EditText(ctx);
        llmain.addView(prix);
        prixValue=prix.getText().toString();
        text5= new TextView(ctx);
        text5.setText("Commentaire");
        text5.setTextSize(20);
        llmain.addView(text5);
        commentaire=new EditText(ctx);
        llmain.addView(commentaire);
        cmntValue=commentaire.getText().toString();
        buttonGroup = new LinearLayout(ctx);
        buttonGroup.setOrientation(LinearLayout.HORIZONTAL);
        terminer = new Button(ctx);
        terminer.setText("terminer");
        retour = new Button(ctx);
        retour.setText("retour");
        buttonGroup.addView(retour);
        buttonGroup.addView(terminer);

        llmain.addView(buttonGroup);



        setContentView(llmain);


    }
}