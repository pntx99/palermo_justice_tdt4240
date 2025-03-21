package com.badlogic.palermojustice
//import com.badlogic.palermojustice.Player

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.GlyphLayout
import com.badlogic.gdx.graphics.g2d.SpriteBatch

class Main : ApplicationAdapter() {

    private lateinit var batch: SpriteBatch
    private lateinit var font: BitmapFont
    private lateinit var layout: GlyphLayout

    override fun create() {
        batch = SpriteBatch()
        font = BitmapFont() // Usa il font predefinito
        layout = GlyphLayout()
    }
    //private lateinit var player: Player

    /*override fun create() {
        player = Player("ISPETTORE", 100)
        println("Gioco avviato! Il giocatore è ${player.name} con ${player.health} HP.")
    }*/

    override fun render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT) // Clear

        batch.begin()

        val text = "Hello, Mafia Game!"
        layout.setText(font, text)

        val textWidth = layout.width
        val textHeight = layout.height

        val x = (Gdx.graphics.width - textWidth) / 2
        val y = (Gdx.graphics.height + textHeight) / 2

        font.draw(batch, layout, x, y)

        batch.end()
    }

    override fun dispose() {
        println("Game Over!")
        batch.dispose()
        font.dispose()
    }
}
