package com.example.enquete.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.enquete.R;
import com.example.enquete.model.Terra;

import java.util.Random;

public class ResultadoActivity extends AppCompatActivity {

    private TextView textDino;
    private TextView textPlana;
    private TextView textGlobo;
    private TextView textModelo;
    private TextView textDescricao;
    private ImageView imgResultado;

    private Random gerador = new Random();
    private int resDino;
    private int resPlana;
    private int resGlobo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        Intent i = getIntent();
        Terra terra = (Terra) i.getSerializableExtra("a");

        textDino = findViewById(R.id.textTerraDino);
        textPlana = findViewById(R.id.textTerraPlana);
        textGlobo = findViewById(R.id.textTerraGlobo);
        textModelo = findViewById(R.id.textVotos);
        textDescricao = findViewById(R.id.textDescricao);
        imgResultado = findViewById(R.id.imgResultado);

        resDino = gerador.nextInt(100) + 1;
        resPlana = gerador.nextInt((100 - resDino)) + 1;
        resGlobo = 100 - (resDino + resPlana);

        textDino.setText("Terra Dinossauro: " + resDino + "%");
        textPlana.setText("Terra Plana: " + resPlana + "%");
        textGlobo.setText("Terra Globo: " + resGlobo + "%");

        textModelo.setText("Seu voto: " + terra.getNome());
        textDescricao.setText(terra.getDescricao());
        imgResultado.setImageResource(terra.getCaminho());

    }
}