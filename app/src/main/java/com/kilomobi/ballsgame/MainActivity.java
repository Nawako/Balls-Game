package com.kilomobi.ballsgame;

import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends ActionBarActivity {

    Timer timer;
    TimerTask timerTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Terrain t = (Terrain)this.findViewById(R.id.view);

        int w = getResources().getDisplayMetrics().widthPixels;
        int h = getResources().getDisplayMetrics().heightPixels;

        t.init();

        t.genereBalle(20, w, h, Balle.TypeBalle.Rouge);
        t.genereBalle(10, w, h, Balle.TypeBalle.Bleu);
        t.genereBalle(15, w, h, Balle.TypeBalle.Vert);
        t.genereBalle(1, w, h, Balle.TypeBalle.Noir);

        startTimer();
    }

    void startTimer()
    {
        //Bricollage à connaître - astuce de prof
        final MainActivity self = this;

        timer = new Timer();
        timerTask = new TimerTask() {
            @Override
            public void run() {
                final Terrain t = (Terrain)self.findViewById(R.id.view);
                t.mouvementDeToutesLesBalles();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        t.invalidate();
                    }
                });

            }
        };
        timer.schedule(timerTask, 500, 10);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
