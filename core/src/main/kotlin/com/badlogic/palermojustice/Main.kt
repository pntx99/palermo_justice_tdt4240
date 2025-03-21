package com.badlogic.palermojustice
//import com.badlogic.palermojustice.Player

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20

class Main : ApplicationAdapter() {
    //private lateinit var player: Player

    /*override fun create() {
        player = Player("Detective", 100) // Sostituisci con il costruttore della tua classe Player
        println("Gioco avviato! Il giocatore è ${player.name} con ${player.health} HP.")
    }*/

    override fun render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT) // Pulisce lo schermo
    }

    override fun dispose() {
        println("Game Over!")
    }
}
