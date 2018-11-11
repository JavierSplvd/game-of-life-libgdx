package com.game;

public class Cell {

    private enum State {ALIVE, DEAD}

    private State currentState;

    public Cell() {
        currentState = State.DEAD;
    }

    public boolean isAlive() {
        return currentState == State.ALIVE;
    }

    public void revive() {
        currentState = State.ALIVE;
    }
}
