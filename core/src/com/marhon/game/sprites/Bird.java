package com.marhon.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by mhonis on 2.11.2016.
 */

public class Bird {

    private static final int GRAVITY = -15;
    private static final int MOVEMENT = 100;
    private static final int BIRD_ANIM_FRAMES = 3;
    private static final float BIRD_FRAME_TIME = 0.5F;

    private Vector3 position;
    private Vector3 velocity;

    private Rectangle bounds;
    Texture birdTexture;
    private Animation birdAnimation;

    public Bird(int x, int y) {
        position = new Vector3(x, y, 0);
        velocity = new Vector3(0, 0, 0);
        birdTexture = new Texture("birdanimation.png");
        birdAnimation = new Animation(birdTexture, BIRD_ANIM_FRAMES, BIRD_FRAME_TIME);
        bounds = new Rectangle(x, y, birdTexture.getWidth() / BIRD_ANIM_FRAMES, birdTexture.getHeight());
    }

    public void update(float dt) {
        birdAnimation.update(dt);
        velocity.add(0, GRAVITY, 0);
        velocity.scl(dt);
        position.add(MOVEMENT * dt, velocity.y, 0);
        if (position.y < 0)
            position.y = 0;

        velocity.scl(1 / dt);
        bounds.setPosition(position.x, position.y);
    }

    public Vector3 getPosition() {
        return position;
    }

    public TextureRegion getTexture() {
        return birdAnimation.getFrame();
    }

    public void flap() {
        velocity.y = 250;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void dispose() {
        birdTexture.dispose();
    }
}
