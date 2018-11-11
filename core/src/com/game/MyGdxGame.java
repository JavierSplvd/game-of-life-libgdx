package com.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

public class MyGdxGame extends Game {
    Screen world;

    @Override
    public void create() {
        world = new World();
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
