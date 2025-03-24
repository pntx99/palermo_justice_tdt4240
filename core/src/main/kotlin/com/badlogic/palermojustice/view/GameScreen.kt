package com.badlogic.palermojustice.view

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.GL20
//import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.*
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener
import com.badlogic.gdx.utils.Align
import com.badlogic.gdx.utils.viewport.ScreenViewport

class GameScreen : Screen {
    private val stage = Stage(ScreenViewport())
    private val batch = SpriteBatch()
    private val font = BitmapFont()
    //private val background = Texture("background.png")
    private lateinit var titleLabel: Label
    private lateinit var createButton: TextButton
    private lateinit var joinButton: TextButton
    private lateinit var inputField: TextField

    override fun show() { //
        Gdx.input.inputProcessor = stage

        // Font style
        val labelStyle = Label.LabelStyle()
        labelStyle.font = font

        // Title
        titleLabel = Label("Palermo Justice", labelStyle)
        titleLabel.setFontScale(6f)
        titleLabel.setAlignment(Align.center)

        // Input fields
        val textFieldStyle = TextField.TextFieldStyle()
        textFieldStyle.font = font
        textFieldStyle.fontColor = com.badlogic.gdx.graphics.Color.WHITE
        inputField = TextField("", textFieldStyle)

        // Buttons
        val buttonStyle = TextButton.TextButtonStyle()
        buttonStyle.font = font

        createButton = TextButton("Create Game", buttonStyle)
        joinButton = TextButton("Join", buttonStyle)

        // Listener for buttons
        createButton.addListener(object : ClickListener() {
            override fun clicked(event: com.badlogic.gdx.scenes.scene2d.InputEvent?, x: Float, y: Float) {
                println("Create Game clicked")
            }
        })

        joinButton.addListener(object : ClickListener() {
            override fun clicked(event: com.badlogic.gdx.scenes.scene2d.InputEvent?, x: Float, y: Float) {
                println("Join Game with code: ${inputField.text}")
            }
        })

        // Layout with Table
        val table = Table()
        table.setFillParent(true)
        table.add(titleLabel).padBottom(20f).row()
        //table.add(Image(background)).size(200f, 120f).padBottom(20f).row()
        table.add(createButton).padBottom(10f).row()
        table.add(inputField).size(150f, 40f).padBottom(10f).row()
        table.add(joinButton)

        stage.addActor(table)
    }

    override fun render(delta: Float) {
        Gdx.gl.glClearColor(1f, 1f, 1f, 1f)
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
        batch.dispose()
        font.dispose()
        //background.dispose()
    }
}
