package service;

import java.util.List;
import java.util.Scanner;

public class EtudiantWS {

public static void main(String[] args) {
		
		GestionEtudiant stub = new GestionEtudiantService().getGestionEtudiantPort();
		
		String nom;
		String prenom;
		String login;
		String password;
		
		
		System.out.println("Bienvenue !!!!!!!");
        System.out.println("Voici le menu");

        Scanner sc = new Scanner(System.in);
        System.out.println("1 : Ajouter un étudiant");
        System.out.println("2 : Afficher la liste des étudiants");
        System.out.println("3 : Modifier un étudiant");
        System.out.println("4 : Supprimer un étudiant");
        System.out.println("Votre choix : ");
        int choix = sc.nextInt();
        sc.nextLine();

        
        switch(choix){
            case 1 : 
                System.out.println("Veuillez entrer le nom de l'étudiant");
                nom = sc.nextLine();
                System.out.println("Veuillez entrer le prenom de l'étudiant");
                prenom = sc.nextLine();
                System.out.println("Veuillez entrer le login de l'étudiant");
                login = sc.nextLine();
                System.out.println("Veuillez entrer le mot de passe de l'étudiant");
                password = sc.nextLine();

                // Ajouter étudiant
                
                stub.ajouter(nom, prenom, login, password);
                
                break;
            case 2 :

                //Afficher la liste des étudiants
            	List <Etudiant> et1= stub.lister();
            	
    			for(Etudiant et : et1) {
    				System.out.println(et.getPrenom() + " " + et.getNom());
            	stub.lister();
    			}
                 
                break;
            case 3 :
                    // Modifier étudiant
                    
                    System.out.println("Veuillez entrer l'ID de l'étudiant");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Entrer le nouveau nom de l'étudiant");
                    nom = sc.nextLine();
                    System.out.println("Entrer le nouveau prenom de l'étudiant");
                    prenom = sc.nextLine();
                    
                    System.out.println("Entrer le nouveau login de l'étudiant");
                    login = sc.nextLine(); 
                    System.out.println("Entrer le nouveau mot de passe de l'étudiant");
                    password = sc.nextLine();
                    
                    stub.modifier(id, nom, prenom, login, password);
                     
                break;
            case 4 : 
                    // Supprimer étudiant
            	System.out.println("Veuillez entrer l'ID de l'étudiant");
            	id = sc.nextInt();
            	stub.supprimer(id);
                  
                   
                break;
            default: 
                break;
        }
		
         
	}

}
