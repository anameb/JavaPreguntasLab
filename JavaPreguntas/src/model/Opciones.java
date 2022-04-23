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
public class Opciones extends Perseverance{
    private int id;
    private int idQuestion;
    private String statement;
    private boolean optionCorrect;

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
     * @return the question
     */
    public int getIdQuestion() {
        return idQuestion;
    }

    /**
     * @param question the question to set
     */
    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
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
     * @return the optionCorrect
     */
    public boolean isOptionCorrect() {
        return optionCorrect;
    }

    /**
     * @param optionCorrect the optionCorrect to set
     */
    public void setOptionCorrect(boolean optionCorrect) {
        this.optionCorrect = optionCorrect;
    }

    @Override
    public Object get(Integer id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ArrayList<Opciones> getOptionsByQuestion(int idQuestion) throws Exception{
        ArrayList<Opciones> options = new ArrayList<>();
        try( Connection conn =  createConnection() ){
            String query = "SELECT id, idPregunta, enunciado, opcionCorrecta FROM appopciones WHERE idPregunta = "+idQuestion;
            
            PreparedStatement statement = conn.prepareStatement(query);
            statement = conn.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            
            int row_count = 0;
            while( result.next() ){
                Opciones option = new Opciones();
                row_count++;
                
                option.setId(result.getInt(1));;
                option.setIdQuestion(result.getInt(2));
                option.setStatement(result.getString(3));
                option.setOptionCorrect(result.getBoolean(4));
                options.add(option);
            }
            
            if( row_count == 0)
                throw new Exception("No se encontro el registro.");
            
        }catch(Exception e){
            throw new Exception("No se puedo obtener la información del objeto id=" + " en la tabla appopciones "+e);
        }
        return options;
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
