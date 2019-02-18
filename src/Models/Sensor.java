package Models;

import Exceptions.RecordNotFoundException;
import dataAccess.MySqlConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Sensor {
    private int id;
    private String description;
    private int idStation;

    public int getId() {    return this.id; }
    public String getDescription() {    return this.description;    }
    public void setDescription(String description) {    this.description = description; }
    public int getIdStation() {   return this.idStation; }

    public Sensor() {
        this.id = 0;
        this.description = "";
        this.idStation = 0;
    }
    
    public Sensor(int id) {
        //get info from database
        //connection object
        PreparedStatement command;
        ResultSet result;
        Connection connection = MySqlConnection.getConnection();
        //query
        String query = "select description, idStation from sensors where sensors.id = ?";
        try {
            //prepare statement
            command = connection.prepareStatement(query);
            command.setInt(1, id);
            //execute query
            result = command.executeQuery();
            if(result.next()) {
                //read fields && add to product
                this.id = result.getInt("id");
                this.description = result.getString("description");
                this.idStation = result.getInt("unitOfMeasurement");
            } else {
                throw new RecordNotFoundException(id);
            }
            //close connection
            connection.close();
        } catch(SQLException ex) {
            System.out.println(ex.getClass().toString() + " : " + ex.getMessage());
        } catch(Exception ex) {
            System.out.println(ex.getClass().toString() + " : " + ex.getMessage());
        }
    }
    
    public Sensor(int id, String description, int idStation) {
        this.id = id;
        this.description = description;
        this.idStation = idStation;
    }
    
    public static boolean add(String description, int idStation) {
        //connection object
        PreparedStatement command;
        Connection connection = MySqlConnection.getConnection();
        //query
        String query = "insert into sensors (description, idStation) values (?, (select id from station where id = ?))";
        try {
            //prepare statement
            command = connection.prepareStatement(query);
            command.setString(1,description);
            command.setInt(2, idStation);
            //execute query
            command.execute();
            //close connection
            connection.close();
        } catch(SQLException ex) {
            System.out.println(ex.getClass().toString() + " : " + ex.getMessage());
        } catch(Exception ex) {
            System.out.println(ex.getClass().toString() + " : " + ex.getMessage());
        }
        return false;
    }
    
    public static boolean edit(int id, String description, int idStation) {
        //connection object
        PreparedStatement command;
        Connection connection = MySqlConnection.getConnection();
        //query
        String query = "update sensors set description = ?, set idStation = ? id = ?";
        try {
            //prepare statement
            command = connection.prepareStatement(query);
            command.setString(1,description);
            command.setInt(2, idStation);
            command.setInt(3, id);
            //execute query
            command.execute();
            //close connection
            connection.close();
        } catch(SQLException ex) {
            System.out.println(ex.getClass().toString() + " : " + ex.getMessage());
        } catch(Exception ex) {
            System.out.println(ex.getClass().toString() + " : " + ex.getMessage());
        }
        return false;
    }
    
    public boolean delete(int id) {
        //connection object
        PreparedStatement command;
        Connection connection = MySqlConnection.getConnection();
        //query
        String query = "delete from sensors where id = ?";
        try {
            //prepare statement
            command = connection.prepareStatement(query);
            command.setInt(1, id);
            //execute query
            command.execute();
            //close connection
            connection.close();
        } catch(SQLException ex) {
            System.out.println(ex.getClass().toString() + " : " + ex.getMessage());
        } catch(Exception ex) {
            System.out.println(ex.getClass().toString() + " : " + ex.getMessage());
        }
            return false;
    }
    
     public static ArrayList<Sensor> getSensors() {
        //list 
        ArrayList<Sensor> list = new ArrayList<>();
        //connection object
        PreparedStatement command;
        ResultSet result;
        Connection connection = MySqlConnection.getConnection();
        //query
        String query = "select id, description, idStation from sensors";
        try {
            //prepare statement
            command = connection.prepareStatement(query);
            //execute query
            result = command.executeQuery();
            //read rows
            while(result.next()) {
                //read fields
                int id = result.getInt("id");
                String description = result.getString("description");
                int idStation = result.getInt("idStation");
                //add product to list
                list.add(new Sensor(id, description, idStation));
            }
            connection.close();
        } catch(SQLException ex) {
            System.out.println(ex.getClass().toString() + " : " + ex.getMessage());
        } catch(Exception ex) {
            System.out.println(ex.getClass().toString() + " : " + ex.getMessage());
        }
        //return list
        return list;
    } 
}
