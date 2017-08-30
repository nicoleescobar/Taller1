package com.example.wawandco.taller1;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText cajaCantidad;
    private Spinner comboDije;
    private Spinner comboTipo;
    private Spinner comboMaterial;
    private RadioButton radio_pesos, radio_dolar;
    private TextView view;
    private Resources resources;


    private ArrayAdapter<String> adapter;
    private String[] opc;

    private ArrayAdapter<String> adapter2;
    private String[] opc2;

    private ArrayAdapter<String> adapter3;
    private String[] opc3;

    boolean usaPesos = false;
    int total = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resources = this.getResources();


        view = (TextView)findViewById(R.id.totalValor);
        cajaCantidad = (EditText)findViewById(R.id.txtCantidad);
        comboDije = (Spinner)findViewById(R.id.cmdDije);
        comboTipo = (Spinner)findViewById(R.id.cmdTipo);
        comboMaterial = (Spinner)findViewById(R.id.cmdMaterial);
        radio_dolar = (RadioButton)findViewById(R.id.radio_dolar);
        radio_pesos = (RadioButton)findViewById(R.id.radio_pesos);

        opc = this.getResources().getStringArray(R.array.dijes);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,opc);
        comboDije.setAdapter(adapter);

        opc2 = this.getResources().getStringArray(R.array.materiales);
        adapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,opc2);
        comboMaterial.setAdapter(adapter2);

        opc3 = this.getResources().getStringArray(R.array.tipos);
        adapter3 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,opc3);
        comboTipo.setAdapter(adapter3);
    }


    public void total(View v){
        String dije, tipo, material, str="";
        int c;

        if (validar()) {
            c = Integer.parseInt(cajaCantidad.getText().toString());
            total = 0;

            dije = comboDije.getSelectedItem().toString();
            material = comboMaterial.getSelectedItem().toString();
            tipo = comboTipo.getSelectedItem().toString();

            String strMartillo = resources.getString(R.string.martillo);
            String strAncla = resources.getString(R.string.ancla);

            String strOro = resources.getString(R.string.oro);
            String strOroRosa = resources.getString(R.string.ororosado);
            String strNiquel = resources.getString(R.string.niquel);
            String strPlata = resources.getString(R.string.plata);

            String strCuerda = resources.getString(R.string.cuerda);
            String strCuero = resources.getString(R.string.cuero);


            if (dije.equals(strMartillo) && material.equals(strCuero) && (tipo.equals(strOro) || tipo.equals(strOroRosa))) {
                total = c * 100;
            }

            if (dije.equals(strMartillo) && material.equals(strCuero) && tipo.equals(strPlata)) {
                total = c * 80;
            }

            if (dije.equals(strMartillo) && material.equals(strCuero) && tipo.equals(strNiquel)) {
                total = c * 80;
            }


            if (dije.equals(strAncla) && material.equals(strCuero) && (tipo.equals(strOro) || tipo.equals(strOroRosa))) {
                total = c * 120;
            }

            if (dije.equals(strAncla) && material.equals(strCuero) && tipo.equals(strPlata)) {
                total = c * 100;
            }

            if (dije.equals(strAncla) && material.equals(strCuero) && tipo.equals(strNiquel)) {
                total = c * 90;
            }

            if (dije.equals(strMartillo) && material.equals(strCuerda) && (tipo.equals(strOro) || tipo.equals(strOroRosa))) {
                total = c * 90;
            }

            if (dije.equals(strMartillo) && material.equals(strCuerda) && tipo.equals(strPlata)) {
                total = c * 70;
            }

            if (dije.equals(strMartillo) && material.equals(strCuerda) && tipo.equals(strNiquel)) {
                total = c * 50;
            }


            if (dije.equals(strAncla) && material.equals(strCuerda) && (tipo.equals(strOro) || tipo.equals(strOroRosa))) {
                total = c * 110;
            }

            if (dije.equals(strAncla) && material.equals(strCuerda) && tipo.equals(strPlata)) {
                total = c * 90;
            }

            if (dije.equals(strAncla) && material.equals(strCuerda) && tipo.equals(strNiquel)) {
                total = c * 80;
            }

            if (usaPesos) {
                total = total * 3200;
            }

            str = resources.getString(R.string.retorno_1) + " $" + total;
            view.setText(str);

        }

    }


    public void cambiaModoDePago(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.radio_pesos:
                if (checked)
                    usaPesos = true;
                    break;
            case R.id.radio_dolar:
                if (checked)
                    usaPesos = false;
                    break;
        }
    }

    public boolean validar(){

        if(cajaCantidad.getText().toString().isEmpty() || (Integer.parseInt(cajaCantidad.getText().toString()) == 0 )){
            cajaCantidad.setError(resources.getString(R.string.error_1));
            return false;
        }

        return true;
    }
}
