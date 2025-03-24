package com.badlogic.palermojustice.view

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.*
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener
import com.badlogic.gdx.utils.viewport.ScreenViewport
import com.badlogic.gdx.scenes.scene2d.InputEvent

class GameScreen : Screen {
    private val stage = Stage(ScreenViewport())
    private lateinit var font: BitmapFont
    private lateinit var labelStyle: Label.LabelStyle
    private lateinit var buttonStyle: TextButton.TextButtonStyle

    override fun show() {
        Gdx.input.inputProcessor = stage
//
        font = BitmapFont()
        font.data.setScale(3f)

        labelStyle = Label.LabelStyle().apply {
            font = this@GameScreen.font
            fontColor = Color.WHITE
        }

        buttonStyle = TextButton.TextButtonStyle().apply {
            font = this@GameScreen.font
            fontColor = Color.WHITE
        }

        val titleLabel = Label("Palermo Justice", labelStyle)
        val createGameButton = TextButton("Create Game", buttonStyle)
        val joinGameButton = TextButton("Join Game", buttonStyle)

        createGameButton.addListener(object : ClickListener() {
            override fun clicked(event: InputEvent?, x: Float, y: Float) {
                println("Create Game Clicked!")
            }
        })

        joinGameButton.addListener(object : ClickListener() {
            override fun clicked(event: InputEvent?, x: Float, y: Float) {
                println("Join Game Clicked!")
            }
        })

        val table = Table()
        table.setFillParent(true)
        table.add(titleLabel).padBottom(80f).row()
        table.add(createGameButton).width(350f).height(120f).padBottom(40f).row()
        table.add(joinGameButton).width(350f).height(120f)

        stage.addActor(table)
    }

    override fun render(delta: Float) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        stage.act(delta)
        stage.draw()
    }

    override fun resize(width: Int, height: Int) {
        stage.viewport.update(width, height, true)
    }

    override fun hide() {}
    override fun pause() {}
    override fun resume() {}

    override fun dispose() {
        stage.dispose()
        font.dispose()
    }
}
