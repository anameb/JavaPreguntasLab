/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import utils.Perseverance;

/**
 *
 * @author anam1
 */
public class Premio extends Perseverance{
    private int id;
    private int value;
    private int idRound;

    /**
     * @return the idid
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
     * @return the value
     */
    public int getValor() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValor(int value) {
        this.value = value;
    }

    /**
     * @return the ronda
     */
    public int getIdRound() {
        return idRound;
    }

    /**
    // * @param ronda the ronda to set
     */
    public void setRound(int idRound) {
        this.idRound = idRound;
    }

    @Override
    public Object get(Integer id) throws Exception {
        Premio award = null;
        
        try( Connection conn =  createConnection() ){
            String query = "SELECT id, valor, idRonda FROM apppremio WHERE idRonda = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            
            int row_count = 0;
            while( result.next() ){
                row_count++;
                
                if( row_count > 1)
                    throw new Exception("Se encontro más de un resultado.");
                
                this.id = result.getInt(1);
                this.value = result.getInt(2);
                this.idRound = result.getInt(3);
                award = this;
            }
            
            if( row_count == 0)
                throw new Exception("No se encontro el registro.");
            
        }catch(Exception e){
            throw new Exception("No se puedo obtener la información del objeto id=" + id + " en la tabla apppremio.");
        }
        
        return award;
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
