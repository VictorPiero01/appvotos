package com.desarrollo.aplicacionvotos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageButton scobby,hombreara;

    int primervoto=0, segundovoto=0;

    FragmentTransaction transaction;
    Fragment fragmeninicio,fragmenthombreara,peliculascooby;
    String ganador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scobby =  findViewById(R.id.btn_pelicula1);
        hombreara =  findViewById(R.id.btn_pelicula2);

        fragmeninicio = new contenedor();
        fragmenthombreara =new hombrearania();
        peliculascooby =new scoobydoo();

        getSupportFragmentManager().beginTransaction().add(R.id.contenedor,fragmeninicio).commit();

        scobby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                primervoto = primervoto + 1;
                Toast.makeText(getApplicationContext(),"TOTAL "+primervoto+" VOTOS PARA HOMBRE ARAÑA", Toast.LENGTH_SHORT).show();
            }
        });
        hombreara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                segundovoto = segundovoto + 1;
                Toast.makeText(getApplicationContext(),"TOTAL "+segundovoto+" VOTOS PARA SCOOBY DOO"  , Toast.LENGTH_SHORT).show();
            }
        });

        Button resultado = (Button)findViewById(R.id.btn_contarvotos);
        resultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transaction=getSupportFragmentManager().beginTransaction();


                int A = primervoto;
                int B = segundovoto;

                if (B>A){
                    transaction.replace(R.id.contenedor,peliculascooby);
                    transaction.addToBackStack(null);
                }
                else if(A>B){
                    transaction.replace(R.id.contenedor,fragmenthombreara);
                    transaction.addToBackStack(null);
                }
                else {
                    Toast.makeText(getApplicationContext()," EMPATE "  , Toast.LENGTH_SHORT).show();
                }
                transaction.commit();

            }
        });

    }
}