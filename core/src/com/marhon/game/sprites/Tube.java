package com.marhon.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

/**
 * Created by mhonis on 2.11.2016.
 */

public class Tube {

    private static final int FLUCTUATION = 130;
    private static final int TUBEGAP = 100;
    private static final int LOWEST_OPENING = 120;
    public static final int TUBE_WIDTH = 50;

    private Texture topTube, bottomTube;
    private Vector2 posTopTube, posBottomTube;
    private Random rand;

    public Tube(float x) {
        topTube = new Texture("toptube.png");
        bottomTube = new Texture("bottomtube.png");
        rand = new Random();
        posTopTube = new Vector2(x, rand.nextInt(FLUCTUATION) + TUBEGAP + LOWEST_OPENING);
        posBottomTube = new Vector2(x, posTopTube.y - TUBEGAP - bottomTube.getHeight());
    }

    public Texture getTopTube() {
        return topTube;
    }

    public Texture getBottomTube() {
        return bottomTube;
    }

    public Vector2 getPosTopTube() {
        return posTopTube;
    }

    public Vector2 getPosBottomTube() {
        return posBottomTube;
    }

    public void reposition(float x) {
        posTopTube.set(x, rand.nextInt(FLUCTUATION) + TUBEGAP + LOWEST_OPENING);
        posBottomTube.set(x, posTopTube.y - TUBEGAP - bottomTube.getHeight());
    }
}
