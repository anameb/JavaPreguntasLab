/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import utils.Perseverance;

/**
 *
 * @author anam1
 */
public class Jugador extends Perseverance{
    private int id;
    private String name;
    private int reward;

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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the reward
     */
    public int getReward() {
        return reward;
    }

    /**
     * @param reward the reward to set
     */
    public void setReward(int reward) {
        this.reward = reward;
    }
    
    public Jugador(String name, int reward) {
        this.name = name;
        this.reward = reward;
    }

    public Jugador() {
    }
    
    

    @Override
    public Object get(Integer id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer save() throws Exception {
        String query;
         
        try(Connection conn = createConnection()){
            
            query = "INSERT INTO appjugador (name, PremioTotal) VALUES (?, ?)";
           
            PreparedStatement statement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, this.name);
            statement.setInt(2, this.reward);
            
            int rows = statement.executeUpdate();
            
            if( rows > 0 ){
                ResultSet generateKeys = statement.getGeneratedKeys();
                if( generateKeys.next() )
                    this.id = generateKeys.getInt(1);
            }
                    
        } catch(Exception e){
            e.printStackTrace();
            throw new Exception("Error al crear el registro en la tabla appjugadores");
        }
        
        return this.id;
    }

    @Override
    public Integer delete() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
