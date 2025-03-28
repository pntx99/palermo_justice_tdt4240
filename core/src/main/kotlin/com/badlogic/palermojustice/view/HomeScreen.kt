package com.badlogic.palermojustice.view

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.*
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener
import com.badlogic.gdx.utils.Align
import com.badlogic.gdx.utils.viewport.ScreenViewport
import com.badlogic.palermojustice.Main

class HomeScreen : Screen {
    private lateinit var stage: Stage
    private lateinit var skin: Skin

    override fun show() {

        stage = Stage(ScreenViewport())
        Gdx.input.inputProcessor = stage

        skin = Skin(Gdx.files.internal("comic-ui.json"))

        createUI()
    }

    private fun createUI() {
        // main table for the entire screen
        val mainTable = Table()
        mainTable.setFillParent(true)
        stage.addActor(mainTable)

        // title table
        val headerTable = Table()
        val titleLabel = Label("Palermo Justice", skin, "title")
        titleLabel.setAlignment(Align.left)

        headerTable.add(titleLabel).expandX().align(Align.left)

        // try-catch to handle assets errors
        try {
            val fileHandle = Gdx.files.internal("godfather.jpg")
            Gdx.app.log("DEBUG", "File exists: " + fileHandle.exists())
            Gdx.app.log("DEBUG", "File path: " + fileHandle.file().absolutePath)

            val godfatherTexture = Texture(fileHandle)
            val godfatherImage = Image(godfatherTexture)
        } catch (e: Exception) {
            Gdx.app.error("ERROR", "Exception loading image", e)
            val placeholder = Label("Il Padrino", skin)


            // main buttons
            val createGameButton = TextButton("Create Game", skin)
            createGameButton.addListener(object : ChangeListener() {
                override fun changed(event: ChangeEvent, actor: Actor) {
                    Main.instance.setScreen(CreateGameScreen())
                }
            })

            val joinGameButton = TextButton("Join Game", skin)
            joinGameButton.addListener(object : ChangeListener() {
                override fun changed(event: ChangeEvent, actor: Actor) {
                    Main.instance.setScreen(JoinGameScreen())
                }
            })

            //bottom table for roles and settings
            val bottomTable = Table()
            val rolesButton = TextButton("Roles", skin)
            rolesButton.addListener(object : ChangeListener() {
                override fun changed(event: ChangeEvent, actor: Actor) {
                    //Main.instance.setScreen(add here)
                }
            })

            val settingsButtonBottom = TextButton("Settings", skin)
            settingsButtonBottom.addListener(object : ChangeListener() {
                override fun changed(event: ChangeEvent, actor: Actor) {
                    Main.instance.setScreen(SettingsScreen())
                }
            })

            bottomTable.add(rolesButton).padRight(20f)
            bottomTable.add(settingsButtonBottom)

            //put all elements in the main table
            mainTable.add(headerTable).fillX().padTop(10f).row()
            mainTable.add(placeholder).size(200f, 200f).padTop(20f).row()
            mainTable.add(createGameButton).width(250f).height(60f).padTop(30f).row()
            mainTable.add(joinGameButton).width(250f).height(60f).padTop(20f).row()
            mainTable.add(bottomTable).padTop(40f).padBottom(20f).row()

            //style and aspect
            createGameButton.pad(20f)
            joinGameButton.pad(20f)
            rolesButton.pad(20f)
            settingsButtonBottom.pad(20f)
        }
    }

    override fun render(delta: Float) {
        Gdx.gl.glClearColor(0.9f, 0.9f, 0.9f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        stage.act(delta)
        stage.draw()
    }

    override fun resize(width: Int, height: Int) {
        stage.viewport.update(width, height, true)
    }

    override fun pause() {}
    override fun resume() {}
    override fun hide() {}

    override fun dispose() {
        stage.dispose()
        skin.dispose()
    }
}
