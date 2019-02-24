package com.game;

import com.badlogic.gdx.Gdx;
import com.game.gameobjects.GameObject;

public class Background extends GameObject {


    public Background() {
        setRegion(AssetManager.atlas.findRegion("background"));
        setHeight(getRegion().getRegionHeight());
        setWidth(getRegion().getRegionWidth());

    }

    @Override
    public void draw() {
        int numberColumns = (int) (Gdx.graphics.getWidth() / getWidth());
        int numberRows = (int) (Gdx.graphics.getHeight() / getHeight());
        for (int x = 0; x < numberColumns; x++) {
            for (int y = 0; y < numberRows; y++) {
                MyGdxGame.batch.draw(getRegion(), getWidth() * x, getHeight() * y, getWidth(), getHeight());
            }
        }
    }
}
