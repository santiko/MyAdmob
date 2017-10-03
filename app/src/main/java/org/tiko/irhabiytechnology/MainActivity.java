package org.tiko.irhabiytechnology;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class MainActivity extends AppCompatActivity {
    TextView tvTimer;
    private InterstitialAd iaIklan1, iaIklan2, iaIklan3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.irhabiy_layout);
        tvTimer = (TextView) findViewById(R.id.labelTimer);
        // --------------- COUNTDOWN TIMER ---------------
        new CountDownTimer(60000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tvTimer.setText("Waktu: " + millisUntilFinished / 1000 + " detik.");
            }

            @Override
            public void onFinish() {
                Toast.makeText(getApplicationContext(), "Waktu habis!", Toast.LENGTH_LONG).show();
            }
        }.start();
        // ------------------- BAGIAN 1 ----------------------
        final AdView advIklan1 = (AdView) findViewById(R.id.iklan1);
        AdRequest adrIklan1 = new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build();
        advIklan1.loadAd(adrIklan1);
        tvTimer = (TextView) findViewById(R.id.labelTimer);
        iaIklan1 = new InterstitialAd(this);
        iaIklan1.setAdUnitId("ca-app-pub-1135045960343514/6427289433");
        iaIklan1.loadAd(new AdRequest.Builder().build());

        Button btnInters1 = (Button) findViewById(R.id.tombolInters1);
        btnInters1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (iaIklan1.isLoaded()) {
                    iaIklan1.show();
                }
            }
        });
        // ------------------- BAGIAN 2 ----------------------
        final AdView advIklan2 = (AdView) findViewById(R.id.iklan2);
        AdRequest adrIklan2 = new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build();
        advIklan2.loadAd(adrIklan2);

        iaIklan2 = new InterstitialAd(this);
        iaIklan2.setAdUnitId("ca-app-pub-1135045960343514/5064787058");
        iaIklan2.loadAd(new AdRequest.Builder().build());

        Button btnInters2 = (Button) findViewById(R.id.tombolInters2);
        btnInters2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (iaIklan2.isLoaded()) {
                    iaIklan2.show();
                }
            }
        });

        // ------------------- BAGIAN 3 ----------------------
        final AdView advIklan3 = (AdView) findViewById(R.id.iklan3);
        AdRequest adrIklan3 = new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build();
        advIklan3.loadAd(adrIklan3);

        iaIklan3 = new InterstitialAd(this);
        iaIklan3.setAdUnitId("ca-app-pub-1135045960343514/2184963533");
        iaIklan3.loadAd(new AdRequest.Builder().build());

        Button btnInters3 = (Button) findViewById(R.id.tombolInters3);
        btnInters3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (iaIklan3.isLoaded()) {
                    iaIklan3.show();
                }
            }
        });

        // ----------------- LISTENER -----------------
        advIklan1.setAdListener(new AdListener() {
            @Override
            public void onAdOpened() {
                super.onAdOpened();
                advIklan1.destroy();
            }
        });

        advIklan2.setAdListener(new AdListener() {
            @Override
            public void onAdOpened() {
                super.onAdOpened();
                advIklan2.destroy();
            }
        });

        advIklan3.setAdListener(new AdListener() {
            @Override
            public void onAdOpened() {
                super.onAdOpened();
                advIklan3.destroy();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu idMenu) {
        getMenuInflater().inflate(R.menu.menu, idMenu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem items) {
        int iMenu = items.getItemId();
        switch (iMenu) {
            case R.id.mnExit:
                finish();
                System.exit(0);
            case R.id.mnSegarkan:
                Intent intentSegarkan = new Intent(getIntent());
                finish();
                startActivity(intentSegarkan);
        }
        return super.onOptionsItemSelected(items);
    }
}
