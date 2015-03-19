package com.kilomobi.ballsgame;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by Fabrice on 19/03/2015.
 */
public class Terrain extends View {

    private ArrayList<Balle> lesBalles;

    public Terrain(Context context) {
        super(context);
    }

    public Terrain(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Terrain(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Ajout d'une boucle pour dessiner les balles
        for (int i = 0; i < lesBalles.size(); i++) {
            lesBalles.get(i).draw(canvas);
        }
    }

    private void init() {
        // Initialisation de l'ArrayList
        lesBalles = new ArrayList<Balle>();

        //Création de 4 balles
        // ASTUCE : CTRL + D sur la ligne pour la dupliquer automatiquement en bas
        lesBalles.add(new Balle(100.0,100.0, Balle.TypeBalle.Bleu));
        lesBalles.add(new Balle(100.0,100.0, Balle.TypeBalle.Vert));
        lesBalles.add(new Balle(100.0,100.0, Balle.TypeBalle.Rouge));
        lesBalles.add(new Balle(100.0,100.0, Balle.TypeBalle.Noir));

    }

    private void mouvement() {

    }

}
