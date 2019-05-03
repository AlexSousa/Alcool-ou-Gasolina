package com.example.alcoolougasolina;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView Resultado;
    private EditText etAlcool;
    private EditText etGasolina;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etAlcool = findViewById(R.id.etAlcool);
        etGasolina = findViewById(R.id.etGasolina);
        Resultado = findViewById(R.id.Resultado);
    }
    public void calcularPreco (View view){
        String Gasolina = etGasolina.getText().toString();
        String Alcool = etAlcool.getText().toString();
        Boolean Verificar = this.Verificar(Alcool,Gasolina);
        if (Verificar){
            Double pGasolina = Double.parseDouble(Gasolina);
            Double pAlcool = Double.parseDouble(Alcool);
            Double divisao = pAlcool/pGasolina;
            if (divisao >=0.7){
                Resultado.setText("É melhor utilizar Gasolina");
            }else {
                Resultado.setText("É melhor utilizar Alccol");
            }

        }else {
            Resultado.setText("Preencha os campos");
        }

    }
    Boolean Verificar(String pAlcool,String pGasolina){
        Boolean camposValidades = true;

        if ((pAlcool==null)||(pAlcool.equals(""))){
            camposValidades = false;
        }else if ((pGasolina==null)||(pGasolina.equals(""))){
            camposValidades = false;
        }
        return camposValidades;
    }
}
