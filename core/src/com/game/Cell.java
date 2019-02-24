package com.game;

import com.game.gameobjects.GameObject;

public class Cell extends GameObject {


    private enum State {ALIVE, DEAD;}

    private State currentState;

    public Cell(float x, float y, float width, float height) {
        setX(x);
        setY(y);
        setWidth(width);
        setHeight(height);
        kill();
    }

    public boolean isAlive() {
        return currentState == State.ALIVE;
    }

    public void revive() {
        currentState = State.ALIVE;
    }

    public void kill() {
        currentState = State.DEAD;
    }

    @Override
    public void draw() {
        if (currentState == State.ALIVE) {
            setTexture(AssetManager.texture_alive);
        } else {
            setTexture(AssetManager.texture_dead);
        }
        MyGdxGame.batch.draw(
                getTexture(),
                getX(),
                getY(),
                getWidth(),
                getHeight()
        );
    }
}
