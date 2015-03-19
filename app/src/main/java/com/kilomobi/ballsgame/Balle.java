package com.kilomobi.ballsgame;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.Random;

/**
 * Created by Fabrice on 19/03/2015.
 */
public class Balle {
    private Double x, y, vx, vy, rayon;
    private TypeBalle type;

    // ALT + ENTREE pour avoir la génération du constructeur / getter / setter ou CODE -> Generate

    public Balle(Double x, Double y, TypeBalle type) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.rayon = 20.0;
        this.vx = Math.random()*10.0-5.0;
        this.vy = Math.random()*10.0-5.0;
    }

    void draw (Canvas c){
        Paint p = new Paint();
        switch (getType())
        {
            case Bleu:
                p.setColor(Color.BLUE);
                break;
            case Rouge:
                p.setColor(Color.RED);
                break;
            case Vert:
                p.setColor(Color.GREEN);
                break;
            case Noir:
                p.setColor(Color.BLACK);
                break;
        }
        c.drawCircle(getX().floatValue(),getY().floatValue(),getRayon().floatValue(),p);
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

    public enum TypeBalle {
        Bleu,
        Rouge,
        Vert,
        Noir
    }
}

