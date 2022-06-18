package com.example.imcteccart;

import static java.lang.Math.round;

import androidx.appcompat.app.AppCompatActivity;


import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {
    //    Declarations des variables
    private EditText poidsEditText;
    private EditText tailleEditText;

    private RadioGroup uniteMesureRadioGroup;
    private RadioButton metreRadioButton;
    private RadioButton centimetreRadioButton;


    private Button calculerButton;
    private Button effacerButton;

    private TextView resultatTextView;

    private TextView indicateurResultatTextView;


    // Definition d'une fonction effacer
    private void Effacer(){
        poidsEditText.setText("");
        tailleEditText.setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referencement des variables
        poidsEditText = findViewById(R.id.idPoids);
        tailleEditText = findViewById(R.id.idTaille);

        uniteMesureRadioGroup = findViewById(R.id.idUniteMesure);
        metreRadioButton = findViewById(R.id.idMetre);
        centimetreRadioButton = findViewById(R.id.idCentimetre);

        calculerButton = findViewById(R.id.idCalculer);
        effacerButton = findViewById(R.id.idEffacer);

        resultatTextView = findViewById(R.id.idResultat);

        indicateurResultatTextView = findViewById(R.id.idIndicateurResultat);

            // Programmation du bouton Calculer

        calculerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Recuperation du poids
                String inputPoids = poidsEditText.getText().toString();
                double poids = Double.parseDouble(inputPoids);

                //Recuperation de la taille
                String inputTaille = tailleEditText.getText().toString();
                double taille = Double.parseDouble(inputTaille);

                // Calcul de l'IMC, ( qui depend de l'unité choisie)

                if (uniteMesureRadioGroup.getCheckedRadioButtonId()==R.id.idCentimetre){
                    taille = taille/100;}

                double imc =(poids/Math.pow(taille,2));

                // Affichage du resultat

                DecimalFormat df = new DecimalFormat("###.##");
                resultatTextView.setText("IMC : "+df.format(imc));



                // Coloriage du banner
                if(imc<18.5){
                    indicateurResultatTextView.setText("Insuffisance Pondérale");
                    indicateurResultatTextView.setBackgroundColor(Color.parseColor("#9dd2fc"));
                }else if (imc<24.9){
                    indicateurResultatTextView.setText("Poids normal");
                    indicateurResultatTextView.setBackgroundColor(Color.parseColor("#05871B"));
                }else if (imc<29.9){
                    indicateurResultatTextView.setText("Surpoids");
                    indicateurResultatTextView.setBackgroundColor(Color.parseColor("#F79A14"));
                }else if(imc>30){
                    indicateurResultatTextView.setText("Obesité");
                    indicateurResultatTextView.setBackgroundColor(Color.parseColor("#F71B14"));
                }

            }
        });

        // Programmation du bouton Effacer -- Appel de la fonction effacer si click sur le bouton "effacer"
        effacerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Effacer();
            }
        });




    }








}