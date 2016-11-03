package com.marhon.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.marhon.game.FlappyDemo;

/**
 * Created by mhonis on 3.11.2016.
 */

public class GameOverState extends State {

    private Texture background;
    private Texture gameOverSprite;

    BitmapFont font;
    private GlyphLayout layout;

    protected GameOverState(GameStateManager gsm, int score) {
        super(gsm);
        background = new Texture("bg.png");
        gameOverSprite = new Texture("gameover.png");
        font = new BitmapFont();
        font.getData().setScale(2F);
        font.setColor(Color.WHITE);
        layout = new GlyphLayout(font, String.valueOf(score));
        cam.setToOrtho(false, FlappyDemo.WIDTH / 2, FlappyDemo.HEIGHT / 2);
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched())
            gsm.set(new PlayState(gsm));
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(background, 0, 0);
        sb.draw(gameOverSprite, cam.position.x - (gameOverSprite.getWidth() / 2), cam.position.y - (gameOverSprite.getHeight() / 2));
        font.draw(sb, layout, cam.position.x - layout.width / 2, cam.position.y + 120);
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        gameOverSprite.dispose();
        font.dispose();
    }
}
