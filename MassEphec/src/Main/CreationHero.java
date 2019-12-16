package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import model.Comptabilite;
import model.Hero;
import model.IT;
import model.Marketing;

public class CreationHero {
	
	private Hero hero;
	
	public CreationHero (){
		
	}
	
	public Hero creationHero(String nom, String classe) {
		switch (classe) {
		case "IT" :
			hero = new IT(nom);
			hero.getArme().setHero(hero);
			break;
		case "Marketing":
			hero = new Marketing(nom);
			hero.getArme().setHero(hero);
			break;
		case "Comptabilite":
			hero = new Comptabilite(nom);
			hero.getArme().setHero(hero);
			break;
		}
		//linkDb(classe);
		return hero;
	}
	public Hero getHero() {
		return hero;
		
	}
	
    static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DATABASE = "massephec";
    static final String URL = "jdbc:mysql://localhost/"+DATABASE+"?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
    static final String USERNAME = "root";
    static final String PASSWORD = "";
    static final String TABLE = "heroes";
	
	public void linkDb(String classe) {
		 try {
	            // connection et préparation de la query
	            Connection con = getConnection();
	            String query = "insert into " + TABLE + " values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	            PreparedStatement ps = con.prepareStatement(query);
                try {
                    ps.setString(1, hero.getNom());
                    ps.setString(2, hero.getPath());
                    ps.setInt(3, hero.getVie());
                    ps.setInt(4, hero.getCoordX());
                    ps.setInt(5, hero.getCoordY());
                    ps.setInt(6, 1);
                    ps.setInt(7, 0);
                    ps.setInt(8, 1);
                    ps.setString(9, classe);
                    ps.executeUpdate();
                } catch (SQLException ex) {
                    
                }
	        } catch (Exception e) {
	            e.printStackTrace();
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
