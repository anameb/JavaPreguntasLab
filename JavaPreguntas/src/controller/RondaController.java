/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;

import model.Ronda;

/**
 * @author anam1
 */
public class RondaController {

    public ArrayList<Ronda> getRounds() throws Exception {
        Ronda round = new Ronda();
        return round.getRounds();
    }

}
