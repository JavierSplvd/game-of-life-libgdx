package com.game.gameobjects;

import com.badlogic.gdx.graphics.Texture;
import com.game.MyGdxGame;
import com.game.screens.World;

public class GameObject {

    private float x = 0;
    private float y = 0;
    private float width = 0;
    private float height = 0;

    private Texture texture;

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void draw() {
        MyGdxGame.batch.draw(texture, x, y, width, height);
    }

    public void act(float delta) {

    }

}
