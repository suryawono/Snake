/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Surya Wono
 */
public class DataBase {
    
    public static DataBase DB=new DataBase();
    private Connection conn;
    private final String URL="localhost:3306";
    private final String DBNAME="snake";
    private final String USER="root";
    private final String PASS="";
    
    public DataBase(){
        
    }
    
    public boolean openConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            this.conn=DriverManager.getConnection(String.format("jdbc:mysql://%s/%s?user=%s&pass=%s",this.URL,this.DBNAME,this.USER,this.PASS));
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
            System.out.println(ex);
            return false;
        }
        return true;
    }

    public Connection getConn() {
        return conn;
    }
}
