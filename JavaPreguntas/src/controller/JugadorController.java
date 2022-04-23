/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Jugador;

/**
 * @author anam1
 */
public class JugadorController {
    public void savePlayer(Jugador player) throws Exception {
        int id = player.save();
    }

}
