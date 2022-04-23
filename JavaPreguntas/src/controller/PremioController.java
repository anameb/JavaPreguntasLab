/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;

import model.Premio;

/**
 * @author anam1
 */
public class PremioController {
    public Premio getAwardByIdRound(int idRound) throws Exception {
        Premio award = new Premio();
        return (Premio) award.get(idRound);
    }
}
