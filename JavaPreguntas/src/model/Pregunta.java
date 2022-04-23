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
public class Pregunta extends Perseverance{
    private int id;
    private int idCategory;
    private String statement;
    private int idRound;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the category
     */
    public int getIdCategory() {
        return idCategory;
    }

    /**
     // @param category the category to set
     */
    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    /**
     * @return the statement
     */
    public String getStatement() {
        return statement;
    }

    /**
     * @param statement the statement to set
     */
    public void setStatement(String statement) {
        this.statement = statement;
    }

    /**
     * @return the round
     */
    public int getIdRound() {
        return idRound;
    }

    /**
     // @param round the round to set
     */
    public void setIdRound(int idRound) {
        this.idRound = idRound;
    }

    public Pregunta() {
    }

    
    
    @Override
    public Object get(Integer id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ArrayList<Pregunta> getQuestionsByRonda(int idRound) throws Exception{
        ArrayList<Pregunta> questions = new ArrayList<>();
        try( Connection conn =  createConnection() ){
            String query = "SELECT id, idCategoria, enunciado, idRonda FROM apppregunta WHERE idRonda = "+idRound;
            
            PreparedStatement statement = conn.prepareStatement(query);
            statement = conn.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            
            int row_count = 0;
            while( result.next() ){
                Pregunta question = new Pregunta();
                row_count++;
                
                question.setId(result.getInt(1));;
                question.setIdCategory(result.getInt(2));
                question.setStatement(result.getString(3));
                question.setIdRound(result.getInt(4));
                
                questions.add(question);
            }
            
            if( row_count == 0)
                throw new Exception("No se encontro el registro.");
            
        }catch(Exception e){
            throw new Exception("No se puedo obtener la información del objeto id=" + " en la tabla apppregunta."+e);
        }
        return questions;
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
