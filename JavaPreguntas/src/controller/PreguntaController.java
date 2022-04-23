/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;

import model.Pregunta;

/**
 * @author anam1
 */
public class PreguntaController {

    public ArrayList<Pregunta> getQuestionsByRonda(int idRound) throws Exception {
        Pregunta question = new Pregunta();
        return question.getQuestionsByRonda(idRound);
    }
}
