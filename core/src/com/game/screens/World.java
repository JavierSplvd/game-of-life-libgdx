package com.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.game.Background;
import com.game.CellSystem;
import com.game.MyGdxGame;

public class World implements Screen {

    //  Game objects
    private CellSystem cellSystem;
    private Background background;

    private float clock = 0;

    @Override
    public void show() {
        cellSystem = new CellSystem(38, 13);
        background = new Background();
        background.start();
        cellSystem.start();

    }

    @Override
    public void render(float delta) {
        // update()
        background.update(Gdx.graphics.getDeltaTime());
        clock += delta;
        if (clock > 0.05) {
            clock -= 0.05;
            cellSystem.update(delta);
        }
        // draw()
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // This cryptic line clears the screen.
        MyGdxGame.batch.begin();
        background.draw();
        cellSystem.draw();
        MyGdxGame.batch.end();
        // lateUpdate()
        background.lateUpdate(Gdx.graphics.getDeltaTime());
        cellSystem.lateUpdate(Gdx.graphics.getDeltaTime());
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
