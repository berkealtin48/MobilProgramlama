package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtIslem, txtSonuc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtIslem = findViewById(R.id.txtIslem);
        txtSonuc = findViewById(R.id.txtSonuc);


        View.OnClickListener sayiClick = v -> {
            Button b = (Button) v;
            txtIslem.append(b.getText().toString());
        };

        findViewById(R.id.btn0).setOnClickListener(sayiClick);
        findViewById(R.id.btn1).setOnClickListener(sayiClick);
        findViewById(R.id.btn2).setOnClickListener(sayiClick);
        findViewById(R.id.btn3).setOnClickListener(sayiClick);
        findViewById(R.id.btn4).setOnClickListener(sayiClick);
        findViewById(R.id.btn5).setOnClickListener(sayiClick);
        findViewById(R.id.btn6).setOnClickListener(sayiClick);
        findViewById(R.id.btn7).setOnClickListener(sayiClick);
        findViewById(R.id.btn8).setOnClickListener(sayiClick);
        findViewById(R.id.btn9).setOnClickListener(sayiClick);


        View.OnClickListener opClick = v -> {
            Button b = (Button) v;
            txtIslem.append(b.getText().toString());
        };

        findViewById(R.id.btnTopla).setOnClickListener(opClick);
        findViewById(R.id.btnCikar).setOnClickListener(opClick);
        findViewById(R.id.btnCarp).setOnClickListener(opClick);
        findViewById(R.id.btnBol).setOnClickListener(opClick);
        findViewById(R.id.btnUs).setOnClickListener(v ->
                txtIslem.append("^")
        );


        findViewById(R.id.btnYuzde).setOnClickListener(v ->
                txtIslem.append("%")
        );


        findViewById(R.id.btnTers).setOnClickListener(v ->
                txtIslem.append("1/")
        );


        findViewById(R.id.btnKok).setOnClickListener(v ->
                txtIslem.append("√")
        );


        findViewById(R.id.btnTemizle).setOnClickListener(v -> {
            txtIslem.setText("");
            txtSonuc.setText("0");
        });


        findViewById(R.id.btnEsittir).setOnClickListener(v -> hesapla());
    }

    void hesapla() {

        String ifade = txtIslem.getText().toString();

        try {
            double sonuc = evaluateExpression(ifade);
            txtSonuc.setText(String.valueOf(sonuc));
            txtIslem.setText("");
        } catch (Exception e) {
            txtSonuc.setText("Hata");
        }
    }


    double evaluateExpression(String expr) {

        if(expr.contains("+")){
            String[] p = expr.split("\\+");
            return Double.parseDouble(p[0]) + Double.parseDouble(p[1]);
        }
        else if(expr.contains("-")){
            String[] p = expr.split("-");
            return Double.parseDouble(p[0]) - Double.parseDouble(p[1]);
        }
        else if(expr.contains("*")){
            String[] p = expr.split("\\*");
            return Double.parseDouble(p[0]) * Double.parseDouble(p[1]);
        }
        else if(expr.contains("/")){
            String[] p = expr.split("/");
            return Double.parseDouble(p[0]) / Double.parseDouble(p[1]);
        }
        else if(expr.contains("^")){
            String[] p = expr.split("\\^");
            return Math.pow(Double.parseDouble(p[0]), Double.parseDouble(p[1]));
        }
        else if(expr.contains("%")){
            String number = expr.replace("%", "");
            return Double.parseDouble(number) / 100;
        }
        else if(expr.contains("√")){
            String number = expr.replace("√", "");
            return Math.sqrt(Double.parseDouble(number));
        }

        return 0;
    }
}