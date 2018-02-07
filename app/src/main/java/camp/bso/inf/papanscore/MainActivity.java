package camp.bso.inf.papanscore;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.net.URL;

public class MainActivity extends AppCompatActivity {

    Button pluspersib, minpersib;
    Button pluspersija,minpersija;
    Button reset,berita,map;
    TextView skorpersibb,skorpersijaa;
    int skorValPersib,skorValPersija;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnDetails1;
        Button btnDetails2;
        btnDetails1= (Button) findViewById(R.id.btn_details1);
        btnDetails2= (Button) findViewById(R.id.btn_details2);
        pluspersib = (Button) findViewById(R.id.btn_persib1);
        minpersib = (Button) findViewById(R.id.btn_persib2);
        pluspersija = (Button) findViewById(R.id.btn_plus);
        minpersija = (Button) findViewById(R.id.btn_min);
        skorpersibb = (TextView) findViewById(R.id.btnskorpersib);
        skorpersijaa = (TextView) findViewById(R.id.btnskorpersija);
        reset = (Button) findViewById(R.id.btnreset);
        berita = (Button) findViewById(R.id.btnberita);
        map= (Button) findViewById(R.id.btnmaps);
        skorValPersib = 0;
        skorValPersija = 0;

            btnDetails1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),DetaiActivity1 .class);
                startActivity(i);
            }
        });
        btnDetails2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),DetaiActivity2.class);
                startActivity(i);
            }
        });
        pluspersib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                skorValPersib = skorValPersib+1;
                skorpersibb.setText(String.valueOf(skorValPersib));
            }
        });
        minpersib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (skorValPersib > 0) {
                    skorValPersib = skorValPersib - 1;
                    skorpersibb.setText(String.valueOf(skorValPersib));
                }
            }
        });
        pluspersija.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                skorValPersija= skorValPersija+1;
                skorpersijaa.setText(String.valueOf(skorValPersija));
            }
        });
        minpersija.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (skorValPersija > 0) {
                    skorValPersija = skorValPersija - 1;
                    skorpersijaa.setText(String.valueOf(skorValPersija));
                }
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                skorValPersib = 0;
                skorValPersija = 0;
                skorpersibb.setText(String.valueOf(skorValPersib));
                skorpersijaa.setText(String.valueOf(skorValPersija));
            }
        });

        berita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                String urllink ="http://www.persib.co.id/beranda.aspx#popup";
                browserIntent.setData(Uri.parse(urllink));
                startActivity(browserIntent);
            }
        });
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Uri gmmIntentUri=Uri.parse("geo:-6.957496, 107.711438");
                Intent mapsIntent=new Intent(Intent.ACTION_VIEW,gmmIntentUri);
                mapsIntent.setPackage("com.google.android.apps.maps");
                if (mapsIntent.resolveActivity(getPackageManager())!=null){
                    startActivity(mapsIntent);
                }
            }
        });
    }
}
