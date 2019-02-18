package Models;

import Exceptions.RecordNotFoundException;
import dataAccess.MySqlConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Station {
    private int id;
    private String description;
    private String ipAddress;

    public int getId() {    return this.id; }
    public String getDescription() {    return this.description;    }
    public void setDescription(String description) {    this.description = description; }
    public String getIpAddress() {  return this.ipAddress;  }
    public void setIpAddress(String ipAddress) {    this.ipAddress = ipAddress; }

    public Station() {
        this.id = 0;
        this.description = "";
        this.ipAddress = "";
    }
    
    public Station(int id) {
        //get info from database
        //connection object
        PreparedStatement command;
        ResultSet result;
        Connection connection = MySqlConnection.getConnection();
        //query
        String query = "select id, description, ipAddress from station where station.id = ?";
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
                this.ipAddress = result.getString("ipAddress");
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
    
    public Station(int id, String description, String ipAddress) {
        this.id = id;
        this.description = description;
        this.ipAddress = ipAddress;
    }
    
    public static boolean add(String description, String ipAddress) {
        //connection object
        PreparedStatement command;
        Connection connection = MySqlConnection.getConnection();
        //query
        String query = "insert into station (description, ipAddress) values (?, ?)";
        try {
            //prepare statement
            command = connection.prepareStatement(query);
            command.setString(1,description);
            command.setString(2, ipAddress);
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
    
    public static boolean edit(int id, String description, String ipAddress) {
        //connection object
        PreparedStatement command;
        Connection connection = MySqlConnection.getConnection();
        //query
        String query = "update station set description = ?, set ipAddress = ? where id = ?";
        try {
            //prepare statement
            command = connection.prepareStatement(query);
            command.setString(1,description);
            command.setString(2, ipAddress);
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

    public static boolean delete(int id) {
        //connection object
        PreparedStatement command;
        Connection connection = MySqlConnection.getConnection();
        //query
        String query = "delete from station where id = ?";
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
    
    public static ArrayList<Station> getAll() {
        //list 
        ArrayList<Station> list = new ArrayList<>();
        //connection object
        PreparedStatement command;
        ResultSet result;
        Connection connection = MySqlConnection.getConnection();
        //query
        String query = "select id, description, ipAddress from station";
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
                String ipAddress = result.getString("ipAddress");
                //add product to list
                list.add(new Station(id, description,ipAddress));
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
    
    public static ArrayList<Reading> getReadings(int id) {
        //list 
        ArrayList<Reading> list = new ArrayList<>();
        //connection object
        PreparedStatement command;
        ResultSet result;
        Connection connection = MySqlConnection.getConnection();
        //query
        String query = "select id, date, temperature, humidity, windQuality from readings where idStation = ?";
        try {
            //prepare statement
            command = connection.prepareStatement(query);
            command.setInt(1, id);
            //execute query
            result = command.executeQuery();
            //read rows
            while(result.next()) {
                //read fields
                int idReadings = result.getInt("id");
                System.out.println(idReadings);
                String dateReadings = result.getString("date");
                System.out.println(dateReadings);
                double temperature = result.getDouble("temperature");
                System.out.println(temperature);
                double humidity = result.getDouble("humidity");
                System.out.println(humidity);
                String windQuality = result.getString("windQuality");
                //add product to list
                list.add(new Reading(idReadings, dateReadings,temperature, humidity, windQuality));
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
    
    public static ArrayList<Reading> getReadingsDate(int id, String startDate, String endDate) {
        //list 
        ArrayList<Reading> list = new ArrayList<>();
        //connection object
        PreparedStatement command;
        ResultSet result;
        Connection connection = MySqlConnection.getConnection();
        //query
        String query = "select id, date, temperature, humidity, windQuality from readings where date = ? or date = ? and idStation = ?";
        try {
            //prepare statement
            command = connection.prepareStatement(query);
            command.setString(1, startDate);
            command.setString(2, endDate);
            command.setInt(3, id);
            //execute query
            result = command.executeQuery();
            //read rows
            while(result.next()) {
                //read fields
                int idReadings = result.getInt("id");
                String dateReadings = result.getString("date");
                double temperature = result.getDouble("temperature");
                double humidity = result.getDouble("humidity");
                String windQuality = result.getString("windQuality");
                //add product to list
                list.add(new Reading(idReadings, dateReadings, temperature, humidity, windQuality));
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
