package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author USER
 */
public class Jdbc {

    static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DATABASE = "massephec";
    static final String URL = "jdbc:mysql://localhost?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
    static final String USERNAME = "root";
    static final String PASSWORD = "";
    static final String TABLE1 = "monsters";
    static final String TABLE2 = "heroes";

    
    public static void main(String[] args) throws Exception {
            createDb();
            createTable();
    }
    
    public static void createDb(){
        try{
            Connection con = getConnection();
            PreparedStatement create = con.prepareStatement("CREATE DATABASE IF NOT EXISTS "+DATABASE);
            create.executeUpdate();
        }catch(Exception e){System.out.println(e);}
        finally{
            System.out.println("BDD construite.");
        }   
    }
    
    public static void createTable(){
        try{
            Connection con = getConnection();
            PreparedStatement useTable = con.prepareStatement("USE "+DATABASE);
            useTable.executeUpdate();
            PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS "+TABLE1+"(`degats` INT, `path` VARCHAR(255), `nom` VARCHAR(255) NOT NULL, `vie` INT, `coordX` INT, `coordY` INT, `credit` INT, `speech` VARCHAR(255), `experience` INT, `heros` VARCHAR(255) NOT NULL, PRIMARY KEY (`nom`, `heros`) )ENGINE=InnoDB");
            create.executeUpdate();
        }catch(Exception e){System.out.println(e);}
        finally{
            System.out.println("Tables construites.");
        }   
    }
    
    public static Connection getConnection() throws Exception{
        try{
            Class.forName(DRIVER);
            Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            System.out.println("Connecté à la base de données");
            return conn;
        }catch(Exception e){System.out.println(e);}
        return null;
    }
}

 