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
        // Crea lo stage per gestire elementi UI
        stage = Stage(ScreenViewport())
        Gdx.input.inputProcessor = stage

        // Carica lo skin (assicurati che "comic-ui.json" sia disponibile o usa un altro skin)
        skin = Skin(Gdx.files.internal("comic-ui.json"))

        // Crea l'interfaccia utente
        createUI()
    }

    private fun createUI() {
        // Tabella principale che occuperà tutto lo schermo
        val mainTable = Table()
        mainTable.setFillParent(true)
        stage.addActor(mainTable)

        // Tabella per il titolo e icona impostazioni
        val headerTable = Table()
        val titleLabel = Label("Palermo Justice", skin, "title")
        titleLabel.setAlignment(Align.left)

        // Pulsante impostazioni in alto a destra
        val settingsButton = TextButton("⚙", skin)
        settingsButton.addListener(object : ChangeListener() {
            override fun changed(event: ChangeEvent, actor: Actor) {
                // Naviga alla schermata delle impostazioni
                // game.setScreen(SettingsScreen())
            }
        })

        headerTable.add(titleLabel).expandX().align(Align.left)
        headerTable.add(settingsButton).padRight(10f)

        try {
            val fileHandle = Gdx.files.internal("godfather.jpg")
            Gdx.app.log("DEBUG", "File exists: " + fileHandle.exists())
            Gdx.app.log("DEBUG", "File path: " + fileHandle.file().absolutePath)

            val godfatherTexture = Texture(fileHandle)
            val godfatherImage = Image(godfatherTexture)
            // resto del codice...
        } catch (e: Exception) {
            Gdx.app.error("ERROR", "Exception loading image", e)
            // Usa un placeholder invece dell'immagine
            val placeholder = Label("Il Padrino", skin)
            // resto del codice sostituendo godfatherImage con placeholder...


            // Pulsanti principali
            val createGameButton = TextButton("Create Game", skin)
            createGameButton.addListener(object : ChangeListener() {
                override fun changed(event: ChangeEvent, actor: Actor) {
                    // Gestisci la creazione del gioco
                }
            })

            val joinGameButton = TextButton("Join Game", skin)
            joinGameButton.addListener(object : ChangeListener() {
                override fun changed(event: ChangeEvent, actor: Actor) {
                    // Gestisci l'unione al gioco
                }
            })

            // Tabella inferiore per i pulsanti "Roles" e "Settings"
            val bottomTable = Table()
            val rolesButton = TextButton("Roles", skin)
            rolesButton.addListener(object : ChangeListener() {
                override fun changed(event: ChangeEvent, actor: Actor) {
                    // Naviga alla schermata dei ruoli
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

            // Aggiungi tutti gli elementi alla tabella principale
            mainTable.add(headerTable).fillX().padTop(10f).row()
            mainTable.add(placeholder).size(200f, 200f).padTop(20f).row()
            mainTable.add(createGameButton).width(250f).height(60f).padTop(30f).row()
            mainTable.add(joinGameButton).width(250f).height(60f).padTop(20f).row()
            mainTable.add(bottomTable).padTop(40f).padBottom(20f).row()

            // Configura gli stili per migliorare l'aspetto
            createGameButton.pad(10f)
            joinGameButton.pad(10f)
            rolesButton.pad(10f)
            settingsButtonBottom.pad(10f)
        }
    }

    override fun render(delta: Float) {
        // Pulisci lo schermo con un colore di sfondo
        Gdx.gl.glClearColor(0.9f, 0.9f, 0.9f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        // Aggiorna e disegna lo stage
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
