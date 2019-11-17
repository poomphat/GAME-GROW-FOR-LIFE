package com.mygdx.game;

import java.util.Iterator;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.*;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileSet;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

import com.badlogic.gdx.assets.AssetManager;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.graphics.OrthographicCamera;

/**
 * Simple example about how to render a tiled map with libGDX.
 *
 * @author pixnbgames
 */
public class MyGdxGame extends ApplicationAdapter {

    // Map
    private TiledMap map;
    private TmxMapLoader manager;

    // Map properties
    private int tileWidth, tileHeight,
            mapWidthInTiles, mapHeightInTiles,
            mapWidthInPixels, mapHeightInPixels;

    // Camera and render
    private OrthographicCamera camera;
    private OrthogonalTiledMapRenderer renderer;

    Texture dropImage;
    Texture spriteimage;
    Sound dropSound;
    Music rainMusic;
    SpriteBatch batch;
    Rectangle sprite;
    Array<Rectangle> raindrops;
    long lastDropTime;

    @Override
    public void create() {
        // Map loading
        map = new TmxMapLoader().load("map..tmx");

        // Read properties
        MapProperties properties = map.getProperties();
        tileWidth = properties.get("tilewidth", Integer.class);
        tileHeight = properties.get("tileheight", Integer.class);
        mapWidthInTiles = properties.get("width", Integer.class);
        mapHeightInTiles = properties.get("height", Integer.class);
        mapWidthInPixels = mapWidthInTiles * tileWidth;
        mapHeightInPixels = mapHeightInTiles * tileHeight;
        spriteimage = new Texture(Gdx.files.internal("char1.png"));
        batch = new SpriteBatch();
        sprite = new Rectangle();
        sprite.x = 800 / 2 - 64 / 2; 
        sprite.y = 20;
        sprite.width = 30;
        sprite.height = 25;
        // Set up the camera
        camera = new OrthographicCamera(600.f, 300.f);
        camera.position.x = mapWidthInPixels * .5f;
        camera.position.y = mapHeightInPixels * .35f;
        renderer = new OrthogonalTiledMapRenderer(map);

    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(.5f, .7f, .9f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.position.set(sprite.getX(), sprite.getY(), 0);
        camera.update();
        renderer.setView(camera);
	renderer.render();
        batch.begin();
        batch.draw(spriteimage, sprite.x, sprite.y,sprite.width,sprite.height);
        batch.end();
        batch.setProjectionMatrix(camera.combined);
        
        if (Gdx.input.isKeyPressed(Keys.LEFT)) {
            sprite.x -= 200 * Gdx.graphics.getDeltaTime();
        }
        if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
            sprite.x += 200 * Gdx.graphics.getDeltaTime();
        }
        if (Gdx.input.isKeyPressed(Keys.DOWN)) {
            sprite.y -= 200 * Gdx.graphics.getDeltaTime();
        }
        if (Gdx.input.isKeyPressed(Keys.UP)) {
            sprite.y += 200 * Gdx.graphics.getDeltaTime();
        }
    
    }

    @Override
    public void dispose() {
        // Free resources
        spriteimage.dispose();
    }
}
