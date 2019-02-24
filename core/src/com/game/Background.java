package com.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.game.gameobjects.GameObject;

public class Background extends GameObject {

    private final TextureRegion textureRegion;

    public Background() {
        setHeight(Gdx.graphics.getHeight());
        setWidth(Gdx.graphics.getWidth());
        setTexture(AssetManager.texture_background);
        getTexture().setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat);

        textureRegion = new TextureRegion(
                getTexture(),
                (int) getWidth(),
                (int) getHeight()
        );
    }

    @Override
    public void draw() {
        MyGdxGame.batch.draw(textureRegion, getX(), getY(), getWidth(), getHeight());
    }
}
