package service;

import java.util.ArrayList;

import javax.jws.WebParam;
import javax.jws.WebService;

import java.sql.*;
import java.util.*;

import domaine.Etudiant;

@WebService
public class GestionEtudiant 
{
	 String dbURL = "jdbc:mysql://localhost:3306/GestionEtudiant";
     String username = "root";
     String motDePasse = "";
     
     String sql;

	private static ArrayList<Etudiant> etudiants = new ArrayList<Etudiant>();
	
	// methode qui permet d'ajouter un étudiant
	public Boolean ajouter(@WebParam(name="nom")String nom,
			@WebParam(name="prenom") String prenom, 
			@WebParam(name="login") String login,
			@WebParam(name="password") String password)
	{
		
		 try { 
		Connection conn = DriverManager.getConnection(dbURL, username, motDePasse);
		PreparedStatement statement;
		
		// Ajouter étudiant
        sql = "INSERT INTO Etudiants (nom, prenom, login, password) VALUES (?, ?, ?, ?)";

        statement = conn.prepareStatement(sql);
        statement.setString(1, nom);
        statement.setString(2, prenom);
        statement.setString(3, login);
        statement.setString(4, password);
        
        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("Ajout reussi!");
        }

        conn.close();
        return true;
		 } 
	        catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
		 
	}
	
	// methode qui permet de modifier un étudiant
	public Boolean modifier(@WebParam(name="id")int id, @WebParam(name="nom") String nom,
			@WebParam(name="prenom") String prenom, 
			@WebParam(name="login") String login,
			@WebParam(name="password") String password)
	{
		try { 
			Connection conn = DriverManager.getConnection(dbURL, username, motDePasse);
			PreparedStatement statement;
		 sql = "UPDATE Etudiants SET nom=?, prenom=?, login=?, password=?  WHERE id=?";
         
         statement = conn.prepareStatement(sql);
         statement.setString(1, nom);
         statement.setString(2, prenom);
         statement.setString(3, login);
         statement.setString(4, password);
         statement.setInt(5, id);
         
         int rowsUpdated = statement.executeUpdate();
         if (rowsUpdated > 0) {
             System.out.println("Modification reussie");
         }
         conn.close();
         return true;
		 } 
	        catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	}
	
	// methode qui permet de supprimer un étudiant
	
	public Boolean supprimer(@WebParam(name="id")int id)
	{
		try { 
			Connection conn = DriverManager.getConnection(dbURL, username, motDePasse);
			PreparedStatement statement;
			
		sql = "DELETE FROM Etudiants WHERE id=?";
        
        statement = conn.prepareStatement(sql);
        													
        statement.setInt(1, 1);

        int rowsDeleted = statement.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("Suppression reussie");
        }
        conn.close();
        return true;
		 } 
	        catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	}
	
	// methode qui permet de lister des étudiants
	public List<Etudiant> lister()
	{
		List<Etudiant> liste= new ArrayList<>();
		try { 
			Connection conn = DriverManager.getConnection(dbURL, username, motDePasse);
			PreparedStatement statement;
		//Afficher la liste des étudiants
        sql = "SELECT * FROM Etudiants";

        Statement creation = conn.createStatement();
        ResultSet result = creation.executeQuery(sql);
        
        int count = 0;
        
        while (result.next()){
            
            liste.add(new Etudiant(result.getString("nom"),result.getString("prenom"), result.getString("login"), result.getString("password")));
            
        }
        conn.close();
	 } 
       catch (SQLException e) {
           e.printStackTrace();
       }
	 return liste;
		
	}
	
	
}
