package com.kilomobi.ballsgame;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.Random;

/**
 * Created by Fabrice on 19/03/2015.
 */
public class Balle {

    private static Paint paintRouge = null;
    private static Paint paintVert = null;
    private static Paint paintNoir = null;
    private static Paint paintBleu = null;

    private Double x, y, vx, vy, rayon;
    private TypeBalle type;
    private Paint paint;

    // ALT + ENTREE pour avoir la génération du constructeur / getter / setter ou CODE -> Generate

    public Balle(Double x, Double y, TypeBalle type) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.rayon = 20.0;
        this.vx = Math.random()*10.0-5.0;
        this.vy = Math.random()*10.0-5.0;

        if (paintBleu == null)
        {
            paintBleu = new Paint();
            paintBleu.setColor(Color.BLUE);
            paintRouge = new Paint();
            paintRouge.setColor(Color.RED);
            paintVert = new Paint();
            paintVert.setColor(Color.GREEN);
            paintNoir = new Paint();
            paintNoir.setColor(Color.BLACK);
        }

        paint = new Paint();
        switch (getType())
        {
            case Bleu:
                paint = paintBleu;
                break;
            case Rouge:
                paint = paintRouge;
                break;
            case Vert:
                paint = paintVert;
                break;
            case Noir:
                paint = paintNoir;
                break;
        }
    }

    void draw (Canvas c){
        c.drawCircle(getX().floatValue(),getY().floatValue(),getRayon().floatValue(),paint);
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Double getVx() {
        return vx;
    }

    public void setVx(Double vx) {
        this.vx = vx;
    }

    public Double getVy() {
        return vy;
    }

    public void setVy(Double vy) {
        this.vy = vy;
    }

    public Double getRayon() {
        return rayon;
    }

    public void setRayon(Double rayon) {
        this.rayon = rayon;
    }

    public TypeBalle getType() {
        return type;
    }

    void mouvement(Terrain terrain) {
        // Rebord contre les bords de la fenêtre
        if (getX() - getRayon() < 0)
            setVx( -getVx()); // bord gauche
        if (getX() - getRayon() > terrain.getWidth())
            setVx( -getVx()); // bord droite
        if (getY() - getRayon() < 0)
            setVy( -getVy()); // bord haut
        if (getY() - getRayon() >terrain.getHeight())
            setVy( -getVy()); // bord bas

        // Cinétique du mouvement
        setX(getX() + getVx() );
        setY(getY() + getVy() );
    }

    // Méthode qui permet de savoir si il y a collision
    boolean isCollisioning (Balle b) {
        Double dx = b.getX() - this.getX();
        Double dy = b.getY() - this.getY();
        Double d = Math.sqrt(dx*dx+dy*dy);
        if (d < this.getRayon() + b.getRayon())
            return true;
        return false;
    }

    public static enum TypeBalle {
        Bleu,
        Rouge,
        Vert,
        Noir
    }
}

