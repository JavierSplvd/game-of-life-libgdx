package com.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class AssetManager {

    public final static Texture texture_alive = new Texture(Gdx.files.internal("cell-alive.png"));
    public final static Texture texture_dead = new Texture(Gdx.files.internal("cell-dead.png"));
    public static Texture texture_background = new Texture(Gdx.files.internal("background.png"));
}
