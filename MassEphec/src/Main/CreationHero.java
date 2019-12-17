package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
	            String query = "insert into " + TABLE + " values (?, ?, ?, ?, ?, ?, ?, ?)";
	            PreparedStatement ps = con.prepareStatement(query);
                try {
                	  ps.setString(1, hero.getNom());
                      ps.setString(2, hero.getPath());
                      ps.setInt(3, hero.getVie());
                      ps.setInt(4, 1);
                      ps.setInt(5, 0);
                      ps.setInt(6, 1);
                      ps.setString(7, classe);
                      ps.setInt(8, 0);
                    ps.executeUpdate();
                } catch (SQLException ex) {
                    
                }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}
	
	public Hero reloadHero(String name) {
		Connection con;
		try {
			con = getConnection();
			Statement statement = con.createStatement();
			String query = "SELECT * FROM "+ TABLE + " WHERE `nom` = '"+ name + "'";
			ResultSet result = statement.executeQuery(query);
			while(result.next()){
			String nom = result.getString("nom");
			switch (result.getString("classe")) {
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
			hero.setVie(result.getInt("vie"));
			hero.getArme().setNiveau(result.getInt("armeLevel"));
			hero.getArme().setExperience(result.getInt("armeExperience"));
			hero.setMapNum(result.getInt("mapLevel"));	
			hero.setCredit(result.getInt("credit"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hero;		
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
