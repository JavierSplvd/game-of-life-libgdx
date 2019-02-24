package com.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.game.screens.World;

public class MyGdxGame extends Game {
    private Screen world;
    public static SpriteBatch batch;

    @Override
    public void create() {
        world = new World();
        batch = new SpriteBatch();
        setScreen(world);
    }

    @Override
    public void render() {
        float delta = Gdx.graphics.getDeltaTime();
        getScreen().render(delta);
    }

    @Override
    public void dispose() {
        getScreen().dispose();
    }
}
