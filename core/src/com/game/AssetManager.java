package com.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class AssetManager {

    public final static TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("world.atlas"));
}
