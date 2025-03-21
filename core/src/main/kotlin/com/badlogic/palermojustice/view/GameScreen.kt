package com.badlogic.palermojustice.view

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch

class MainScreen : Screen {

    private lateinit var batch: SpriteBatch
    private lateinit var img: Texture

    override fun show() {
        batch = SpriteBatch()
        img = Texture("resources/images/sample.png") // Assicurati che l'immagine esista
    }

    override fun render(delta: Float) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT) // Pulizia dello schermo
        batch.begin()
        batch.draw(img, 100f, 100f) // Disegna l'immagine a (100,100)
        batch.end()
    }

    override fun resize(width: Int, height: Int) {}
    override fun pause() {}
    override fun resume() {}
    override fun hide() {}
    override fun dispose() {
        batch.dispose()
        img.dispose()
    }
}
