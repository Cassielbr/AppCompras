package br.ulbra.appcompras;

import android.app.AlertDialog;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class MainActivity extends Activity {
    CheckBox chkarroz, chkleite, chkcarne, chkfeijao, chkrefri;
    Button btntotal;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Certifique-se de que o layout esteja correto

        chkarroz = findViewById(R.id.chkarroz);
        chkleite = findViewById(R.id.chkleite);
        chkcarne = findViewById(R.id.chkcarne);
        chkfeijao = findViewById(R.id.chkfeijao);
        chkrefri = findViewById(R.id.chkrefri);
        btntotal = findViewById(R.id.btntotal);

        btntotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                double total = 0;
                if (chkarroz.isChecked()) { total += 2.69; }
                if (chkleite.isChecked()) { total += 5.00; }
                if (chkcarne.isChecked()) { total += 10.00; }
                if (chkfeijao.isChecked()) { total += 2.30; }
                if (chkrefri.isChecked()) { total += 2.00; }

                AlertDialog.Builder dialogo = new AlertDialog.Builder(MainActivity.this);
                dialogo.setTitle("Aviso");
                dialogo.setMessage("Valor total da compra: R$ " + String.format("%.2f", total));
                dialogo.setNeutralButton("OK", null);
                dialogo.show();
            }
        });
    }
}
