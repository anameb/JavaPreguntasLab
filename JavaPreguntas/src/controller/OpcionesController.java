/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;

import model.Opciones;

/**
 * @author anam1
 */
public class OpcionesController {
    public ArrayList<Opciones> getOptionsByQuestion(int idQuestion) throws Exception {
        Opciones option = new Opciones();
        return option.getOptionsByQuestion(idQuestion);
    }
}
