/**
 * 
 * @author lucas_kaniewski | mickael_campos
 *
 */

import java.sql.*;
import java.util.ArrayList;

public class Modele {
	 
	/**
	 *  Attributs
	 * 
	 *  Connection connexion
	 *	Statement st
	 *	ResultSet rs
	 *	PreparedStatement pst
	 * 
	 */
	public static Connection connexion;
	public static Statement st;
	public static ResultSet rs;
	private static PreparedStatement pst;
	
	/* =========================== DEBUT Connexion Deconnexion =========================== */
	
	/**
	 * Methode de connexion à la bdd
	*/
	
	public static void connexionBdd() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//connexion = DriverManager.getConnection("jdbc:mysql://172.16.203.212/binder?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC", "sio", "slam");
			connexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1/binder?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC", "root", "");
			st = connexion.createStatement();
		} catch (ClassNotFoundException e) {
			System.out.println("Le driver n'as pu être chargé");
			//	erreur.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Erreur de la connexion à la bdd");
			//	e.printStackTrace();
		}
	}
		
	/**
	 * Méthode de la déconnexion de la bdd
	*/
			
	public static void deconnexion() {
		try {
			connexion.close(); // Fermeture de la connexion
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erreur de la deconnexion");
			e.printStackTrace();
		} 	
	}
			
	/**
	 * 
	 * @param unLogin
	 * @param unMdp
	 * @return 
	*/
	public static boolean connecter(String unLogin, String unMdp) {
		Modele.connexionBdd();
		boolean rep = false; 
		int j = 0 ;
		try {
			pst = connexion.prepareStatement("SELECT COUNT(*) AS nb FROM user WHERE login = ? AND mdp = sha1(?)");
	        pst.setString(1, unLogin);
	        pst.setString(2, unMdp);
	        rs = pst.executeQuery();
	        while( rs.next()) { // .next il rentre dans le tableau à la premier ligne et le parcours l ar l
				j = rs.getInt("nb");
			}
			if ( j == 1 ) {
				rep = true;
			}
		}catch (SQLException e) {
			System.out.println("Erreur connexion");
		}
		Modele.deconnexion();
		return rep;
	}
			
	/* =========================== FIN Connexion Deconnexion =========================== */
			
	/**
	 * recupListIdFacture()
	 * la fonction retourne les ID des facture présente dans la bdd
	*/
	public static ArrayList<Integer> recupListIdFacture() {
		Modele.connexionBdd();
		ArrayList<Integer> liste = new ArrayList<Integer>();
		try {
			rs = st.executeQuery("SELECT id FROM facture") ;
			int id;
			while(rs.next()) {
				id = rs.getInt("id");
				liste.add(id);
			}
			rs.close();
		} catch (SQLException erreur) {
			System.out.println("Erreur lors de la recupération des numero de facture");
			erreur.printStackTrace();
		}
		Modele.deconnexion();
		return liste;
	}
			
	/**
	 * getNbFacture()
	 * la fonction retourne le nombre de facture présente dans la bdd
	*/
	public static int getNbFacture() {
		Modele.connexionBdd();
		int rep = 0;
		try {
			rs = st.executeQuery("SELECT COUNT(id) AS nb FROM facture");
			while(rs.next()) {
				rep = rs.getInt("nb");
			}
			rs.close();
		} catch (SQLException erreur) {
			System.out.println("Erreur lors de la recupération du nombre de facture");
			erreur.printStackTrace();
		}
		Modele.deconnexion();
		return rep;
	}
			
	/**
	 * @param idFacture
	 * 
	 * recupListElementFacture(int idFacture)
	 * la fonction retourne les éléments lié à la facture 'idFacture'
	*/
	public static ArrayList<String> recupListElementFacture(int idFacture) {
		Modele.connexionBdd();
		ArrayList<String> liste = new ArrayList<String>();
		try {
			pst = connexion.prepareStatement("SELECT description FROM element_facture WHERE idFacture = ?");
	        pst.setInt(1, idFacture);
	        rs = pst.executeQuery();
			String description;
			while(rs.next()) {
				description = rs.getString("description");
				liste.add(description);
			}
			rs.close();
		} catch (SQLException erreur) {
			System.out.println("Erreur lors de la recupération des descriptions");
			erreur.printStackTrace();
		}
		Modele.deconnexion();
		return liste;
	}
		
	/**
	 * getNbElementFacture(int idFacture)
	 * la fonction retourne le nombre d'éléments lié à une facture
	*/
	public static int getNbElementFacture(int idFacture) {
		Modele.connexionBdd();
		int rep = 0;
		try {
			pst = connexion.prepareStatement("SELECT COUNT(description) AS nb FROM element_facture WHERE idFacture = ?");
	        pst.setInt(1, idFacture);
	        rs = pst.executeQuery();
			while(rs.next()) {
				rep = rs.getInt("nb");
			}
			rs.close();
		} catch (SQLException erreur) {
			System.out.println("Erreur lors de la recupération du nombre d'élément de la facture");
			erreur.printStackTrace();
		}
		Modele.deconnexion();
		return rep;
	}
	
	/**
	 * creerFacture(String lieu,String date,String client,String adresse,String ville,String cp)
	 * la fonction créer une facture dans la bdd
	 * retourne vrai si l'insertion est éffectué 
	*/
	public static boolean creerFacture(String lieu,String date,String client,String adresse,String ville,String cp){
		Modele.connexionBdd();
		boolean rep = false;
		int count;
		try {
			
			pst = connexion.prepareStatement("insert into facture(lieu, date, nomClient, adresse, ville, cp) values(?, ?, ?, ?, ?, ?);");
			pst.setString(1, lieu);
			pst.setString(2, date);
			pst.setString(3, client);
			pst.setString(4, adresse);
			pst.setString(5, ville);
			pst.setString(6, cp);
			count = pst.executeUpdate();
			if(count == 1) {
				rep = true;
			}
		} catch (SQLException erreur) {
			System.out.println("Erreur lors de la création de la facture");
			erreur.printStackTrace();
		}
		Modele.deconnexion();
		return rep;
	}
	
	/**
	 * numFacture(String lieu,String date,String client,String adresse,String ville,String cp)
	 * la fonction retourne l'ID de la facture qui vient d'etre créée 
	 * elle est utilisé seulement après la création d'une facture
	*/
	public static int numFactureCreee(String lieu,String date,String client,String adresse,String ville,String cp){
		Modele.connexionBdd();
		int rep = 0;
		try {
			pst = connexion.prepareStatement("SELECT id FROM facture WHERE lieu = ? AND date = ? AND nomClient = ? AND adresse = ? AND ville = ? AND  cp = ?");
			pst.setString(1, lieu);
			pst.setString(2, date);
			pst.setString(3, client);
			pst.setString(4, adresse);
			pst.setString(5, ville);
			pst.setString(6, cp);
	        rs = pst.executeQuery();
			while(rs.next()) {
				rep = rs.getInt("id");
			}
			rs.close();
		} catch (SQLException erreur) {
			System.out.println("Erreur lors de la recupération de l'ID de la facture");
			erreur.printStackTrace();
		}
		Modele.deconnexion();
		return rep;
	}
	/**
	 * ajouterTache(int intNumFacture,String description,Double tarif)
	 * la fonction ajoute la tache dans la bdd elle est lié à la facture 'intNumFacture'
	*/
	public static boolean ajouterTache(int intNumFacture,String description,Double tarif){
		Modele.connexionBdd();
		boolean rep = false;
		int count;
		try {
			
			pst = connexion.prepareStatement("insert into element_facture(idFacture, description, tarif) values(?, ?, ?);");
			pst.setInt(1, intNumFacture);
			pst.setString(2, description);
			pst.setDouble(3, tarif);
			count = pst.executeUpdate();
			if(count == 1) {
				rep = true;
			}
		} catch (SQLException erreur) {
			System.out.println("Erreur lors de la création de la facture");
			erreur.printStackTrace();
		}
		Modele.deconnexion();
		return rep;
	}
}