/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import db.DataBase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Surya Wono
 */
public class User {
    private int id_user;
    private String username;
    private String name;
    
    public User(){}
    
    public boolean login(String username,String password){
        if (!DataBase.DB.openConnection()){
            return false;
        }
        Connection conn=DataBase.DB.getConn();
        String sql=String.format("Select * from user left outer join profile on user.id_user=profile.id_user where username='%s' && password='%s'",username,password);
        try {
            Statement stmt=conn.createStatement();
            ResultSet result=stmt.executeQuery(sql);
            while (result.next()){
                this.id_user=result.getInt("id_user");
                this.username=result.getString("username");
                this.name=result.getString("name");
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public int getId_user() {
        return id_user;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }
}
