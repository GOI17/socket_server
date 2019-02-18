package Models;

import dataAccess.MySqlConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

public class Reading {
    private int id;
    private String date;
    private Station station;
    private double temperature;
    private double humidity;
    private String windQuality;
    
    //Socket Client Config
    
    Socket s;  
    PrintStream ps;
    InputStreamReader isr; 
    BufferedReader br;
    Random r = new Random();
      
    //Simulated message
    String message = "";
    String response = "";
//    double temperature = 20;
    String formattedTemperature = "";
    String formattedUnixDate = "";

    public int getId() {    return this.id; }
    public String getDate() { return this.date;   }
    public Station getStation() {   return this.station;    }
    public double getTemperature() {    return this.temperature;    }
    public void setTemperature(double temperature) {    this.temperature = temperature; }
    public double getHumidity() {   return this.humidity;   }
    public void setHumidity(double humidity) {  this.humidity = humidity;   }
    public String getWindQuality() {    return this.windQuality;    }
    public void setWindQuality(String windQuality) {    this.windQuality = windQuality; }
    
    public Reading() {
        this.id = 0;
        this.date = "";
        this.station = new Station();
        this.temperature = 0;
        this.humidity = 0;
        this.windQuality = "";
    }
    
    public Reading(int id, String date, double temperature, double humidity, String windQuality) {
        this.id = id;
        this.date = date;
        this.temperature = temperature;
        this.humidity = humidity;
        this.windQuality = windQuality;
    }
    
    public Reading(int id, String date, Station station, double temperature, double humidity, String windQuality) {
        this.id = id;
        this.date = date;
        this.station = station;
        this.temperature = temperature;
        this.humidity = humidity;
        this.windQuality = windQuality;
    }  
    
    public static boolean add(String date, int idStation, double temperature, double humidity, String windQuality,double powder) {
        //connection object
        PreparedStatement command;
        Connection connection = MySqlConnection.getConnection();
        //query
        String query = "insert into readings (date, idStation, temperature, humidity, windQuality, powder) values (?, ?, ?, ?, ?, ?)";
        try {
            //prepare statement
            command = connection.prepareStatement(query);
            command.setString(1,date);
            command.setInt(2, idStation);
            command.setDouble(3, temperature);
            command.setDouble(4, humidity);
            command.setString(5, windQuality);
            command.setDouble(6,powder);
//            command.setS\
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
    
    public static ArrayList<Reading> getAll() {
        //list 
        ArrayList<Reading> list = new ArrayList<Reading>();
        //connection object
        PreparedStatement command;
        ResultSet result;
        Connection connection = MySqlConnection.getConnection();
        //query
        String query = "select id, date, idStation, temperature, humidity, windQuality from readings";
        try {
            //prepare statement
            command = connection.prepareStatement(query);
            //execute query
            result = command.executeQuery();
            //read rows
            while(result.next()) {
                //read fields
                int id = result.getInt("id");
                String date = result.getString("date");
                int idStation = result.getInt("idStation");
                double temperature = result.getDouble("temperature");
                double humidity = result.getDouble("humidity");
                String windQuality = result.getString("windQuality");
                //add product to list
                Station station = new Station(idStation);
                list.add(new Reading(id, date, station, temperature, humidity, windQuality));
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
    
    public static ArrayList<Reading> getReadingsDate(String startDate, String endDate) {
        //list 
        ArrayList<Reading> list = new ArrayList<>();
        //connection object
        PreparedStatement command;
        ResultSet result;
        Connection connection = MySqlConnection.getConnection();
        //query
        String query = "select id, date, temperature, humidity, windQuality from readings where date = ? or date = ?";
        try {
            //prepare statement
            command = connection.prepareStatement(query);
            command.setString(1, startDate);
            command.setString(2, endDate);
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
    

