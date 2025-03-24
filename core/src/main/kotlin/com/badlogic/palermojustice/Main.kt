package com.badlogic.palermojustice

import com.badlogic.gdx.Game
import com.badlogic.palermojustice.view.GameScreen

class Main : Game() {
    override fun create() {
        setScreen(GameScreen()) // Imposta la schermata iniziale del gioco
    }
}
//
