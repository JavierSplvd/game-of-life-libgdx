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
        cellSystem.getCell(13, 2).revive();
        cellSystem.getCell(14, 2).revive();

        cellSystem.getCell(12, 3).revive();
        cellSystem.getCell(16, 3).revive();

        cellSystem.getCell(11, 4).revive();
        cellSystem.getCell(17, 4).revive();
        cellSystem.getCell(25, 4).revive();

        cellSystem.getCell(1, 5).revive();
        cellSystem.getCell(2, 5).revive();
        cellSystem.getCell(11, 5).revive();
        cellSystem.getCell(15, 5).revive();
        cellSystem.getCell(17, 5).revive();
        cellSystem.getCell(18, 5).revive();
        cellSystem.getCell(23, 5).revive();
        cellSystem.getCell(25, 5).revive();

        cellSystem.getCell(1, 6).revive();
        cellSystem.getCell(2, 6).revive();
        cellSystem.getCell(11, 6).revive();
        cellSystem.getCell(17, 6).revive();
        cellSystem.getCell(21, 6).revive();
        cellSystem.getCell(22, 6).revive();

        cellSystem.getCell(12, 7).revive();
        cellSystem.getCell(16, 7).revive();
        cellSystem.getCell(21, 7).revive();
        cellSystem.getCell(22, 7).revive();
        cellSystem.getCell(35, 7).revive();
        cellSystem.getCell(36, 7).revive();

        cellSystem.getCell(13, 8).revive();
        cellSystem.getCell(14, 8).revive();
        cellSystem.getCell(21, 8).revive();
        cellSystem.getCell(22, 8).revive();
        cellSystem.getCell(35, 8).revive();
        cellSystem.getCell(36, 8).revive();

        cellSystem.getCell(23, 9).revive();
        cellSystem.getCell(25, 9).revive();

        cellSystem.getCell(25, 10).revive();


        cellSystem.addOffsetToTheCells();

        background = new Background();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // This cryptic line clears the screen.
        MyGdxGame.batch.begin();
        background.draw();
        cellSystem.draw();
        MyGdxGame.batch.end();

        clock += delta;
        if (clock > 0.05) {
            clock -= 0.05;
            cellSystem.act(delta);
        }
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
