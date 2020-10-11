package com.example.enquete.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.enquete.R;
import com.example.enquete.model.Terra;

import java.io.Serializable;

import static java.sql.DriverManager.println;

public class MainActivity extends AppCompatActivity {

    private Button enviar;
    private RadioGroup radioGroup;
    private ImageView imgTerraDino;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enviar = findViewById(R.id.btEnviar);
        radioGroup = findViewById(R.id.radioGroup);
        imgTerraDino = findViewById(R.id.imageTerraDino);

            enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), ResultadoActivity.class);
                Terra terra = new Terra();

                int selectedId = radioGroup.getCheckedRadioButtonId();
                switch (selectedId){
                    case R.id.radioDino:
                        //enviar.setText("Dino");
                        terra.setCaminho(R.drawable.terra_dinossauro);
                        terra.setNome("Terra Dinossauro");
                        terra.setDescricao("A teoria da terra dinossauro apareceu em meados de 2015 como um meme, no auge das discuções sobre terra plana");
                        break;
                    case R.id.radioPlana:
                        //enviar.setText("Plana");
                        terra.setCaminho(R.drawable.terra_plana);
                        terra.setNome("Terra Plana");
                        terra.setDescricao("A teoria da terra plana retornou a pauta em meados de 2015, em 2020 ganhou um novo gas com o surgimento do fenomeno SUPER XANDAO");
                        break;
                    case R.id.radioGlobo:
                       // enviar.setText("Globo");
                        terra.setCaminho(R.drawable.terra_globo2);
                        terra.setNome("Terra Globo");
                        terra.setDescricao("A teoria da terra globo é hoje a mais aceita entre os cietistas e pessoas em geral, mesmo o ultimo grupo nao sabendo explica-la");
                        break;
                    default:
                        Toast toast = Toast.makeText(getApplicationContext(), "Selecione uma opção!", Toast.LENGTH_LONG);
                        toast.show();
                }
                if (terra.getNome() != null){
                    intent.putExtra("a", (Serializable) terra);
                    startActivity(intent);
                }

            }
        });
    }


}