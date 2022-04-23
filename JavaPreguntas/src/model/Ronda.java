/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import utils.Perseverance;

/**
 *
 * @author anam1
 */
public class Ronda extends Perseverance{
    
    private int id;
    private String name;
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     //* @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     //* @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Object get(Integer id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ArrayList<Ronda> getRounds() throws Exception{
        ArrayList<Ronda> rounds = new ArrayList<>();
        try( Connection conn =  createConnection() ){
            String query = "SELECT id, name FROM appronda ";
            
            PreparedStatement statement = conn.prepareStatement(query);
            statement = conn.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            
            int row_count = 0;
            while( result.next() ){
                Ronda round = new Ronda();
                row_count++;
                
                round.setId(result.getInt(1));;
                round.setName(result.getString(2));
                
                rounds.add(round);
            }
            
            if( row_count == 0)
                throw new Exception("No se encontro el registro.");
            
        }catch(Exception e){
            throw new Exception("No se puedo obtener la información del objeto id=" + " en la tabla appronda "+e);
        }
        return rounds;
    }

    @Override
    public Integer save() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer delete() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
