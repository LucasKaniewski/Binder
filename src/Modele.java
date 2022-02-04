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
	 * @return
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
	 * @return
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
	 * Connexion via un login ainsi que d'un mot de passe
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
	 * @return
	*/
	public static ArrayList<Integer> recupListIdFacture() {
		Modele.connexionBdd();
		ArrayList<Integer> liste = new ArrayList<Integer>();
		try {
			rs = st.executeQuery("SELECT id FROM facture ORDER BY id DESC");
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
	 * @return
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
	 * @return
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
	 * @return
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
	 * @return 
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
	 * @return
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
	 * @return
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
	
	/**
	 * supprimerTache(int idFacture,String description)
	 * la fonction supprime la tache dans la bdd qui est lié à la facture 'idFacture'
	 * @return
	*/
	public static boolean supprimerTache(int idFacture,String description) {
		Modele.connexionBdd();
		boolean rep = false;
		int count = 0;
		try{
			pst = connexion.prepareStatement("DELETE FROM element_facture WHERE idFacture = ? AND description = ?");
			pst.setInt(1, idFacture);
			pst.setString(2, description);
			count = pst.executeUpdate();
			if(count == 1) {
				rep = true;
			}
		}
		catch(SQLException erreur) {
			System.out.println("une erreur lors de la suppresion de la tache");
		}
		Modele.deconnexion();
		return rep;
	}
	
	/**
	 * supprimerFacture(int idFacture)
	 * la fonction supprime la facture 'idFacture' dans la bdd ainsi que les tache lié à celle ci dans element_facture 
	 * @return
	*/
	public static boolean supprimerFacture(int idFacture) {
		Modele.connexionBdd();
		boolean rep = false;
		int count = 0;
		try{
			pst = connexion.prepareStatement("DELETE FROM element_facture WHERE idFacture = ?");
			pst.setInt(1, idFacture);
			count = pst.executeUpdate();
			pst = connexion.prepareStatement("DELETE FROM facture WHERE id = ?");
			pst.setInt(1, idFacture);
			count = pst.executeUpdate();
			if(count != 0) {
				rep = true;
			}
		}
		catch(SQLException erreur) {
			System.out.println("une erreur lors de la suppresion de la facture");
		}
		Modele.deconnexion();
		return rep;
	}
	
	/**
	 * getcpEntreprise()
	 * La fonction rertourne le cp de l'entreprise
	 * @return
	*/
	public static String getcpEntreprise() {
		Modele.connexionBdd();
		String rep = "";
		try {
			pst = connexion.prepareStatement("SELECT cp AS info FROM informations");
	        rs = pst.executeQuery(); 
			while(rs.next()) {
				rep = rs.getString("info");
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
	 * getNomEntreprise()
	 * La fonction rertourne le nom de l'entreprise
	 * @return
	*/
	public static String getNomEntreprise() {
		Modele.connexionBdd();
		String rep = "";
		try {
			pst = connexion.prepareStatement("SELECT nom AS info FROM informations");
	        rs = pst.executeQuery();  
			while(rs.next()) {
				rep = rs.getString("info");
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
	 * getAdresseEntreprise()
	 * La fonction rertourne l'adresse de l'entreprise
	 * @return
	*/
	public static String getAdresseEntreprise() {
		Modele.connexionBdd();
		String rep = "";
		try {
			pst = connexion.prepareStatement("SELECT adresse AS info FROM informations");
	        rs = pst.executeQuery();  
			while(rs.next()) {
				rep = rs.getString("info");
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
	 * getVilleEntreprise()
	 * La fonction rertourne la ville de l'entreprise
	 * @return
	*/
	public static String getVilleEntreprise() {
		Modele.connexionBdd();
		String rep = "";
		try {
			pst = connexion.prepareStatement("SELECT ville AS info FROM informations");
	        rs = pst.executeQuery();  
			while(rs.next()) {
				rep = rs.getString("info");
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
	 * gettvaEntreprise()
	 * La fonction rertourne la tva entreprise
	 * @return
	*/
	public static String gettvaEntreprise() {
		Modele.connexionBdd();
		String rep = "";
		try {
			pst = connexion.prepareStatement("SELECT tvaEntreprise AS info FROM informations");
	        rs = pst.executeQuery();  
			while(rs.next()) {
				rep = rs.getString("info");
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
	 * gettvaParticulier()
	 * La fonction rertourne la tva particulier
	 * @return
	*/
	public static String getTvaParticulier() {
		Modele.connexionBdd();
		String rep = "";
		try {
			pst = connexion.prepareStatement("SELECT tvaParticulier AS info FROM informations");
	        rs = pst.executeQuery();  
			while(rs.next()) {
				rep = rs.getString("info");
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
	 * gettelephoneEntreprise()
	 * La fonction rertourne le telehone de l'entreprise
	 * @return
	*/
	public static String getTelephoneEntreprise() {
		Modele.connexionBdd();
		String rep = "";
		try {
			pst = connexion.prepareStatement("SELECT telephone AS info FROM informations");
	        rs = pst.executeQuery();  
			while(rs.next()) {
				rep = rs.getString("info");
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
	 * getfaxEntreprise()
	 * La fonction rertourne le fax de l'entreprise
	 * @return
	*/
	public static String getFaxEntreprise() {
		Modele.connexionBdd();
		String rep = "";
		try {
			pst = connexion.prepareStatement("SELECT fax AS info FROM informations");
	        rs = pst.executeQuery();  
			while(rs.next()) {
				rep = rs.getString("info");
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
	 * getmailEntreprise()
	 * La fonction rertourne le mail de l'entreprise
	 * @return
	*/
	public static String getMailEntreprise() {
		Modele.connexionBdd();
		String rep = "";
		try {
			pst = connexion.prepareStatement("SELECT mail AS info FROM informations");
	        rs = pst.executeQuery();  
			while(rs.next()) {
				rep = rs.getString("info");
			}
			rs.close();
		} catch (SQLException erreur) {
			System.out.println("");
			erreur.printStackTrace();
		}	
		Modele.deconnexion();
		return rep;	
	}
	
	public static boolean modfierUneInformation(String infoModif , String modifVal) {
		Modele.connexionBdd();
		boolean rep = false;
		try {
			pst = connexion.prepareStatement("UPDATE ? FROM informations WHERE ");
			pst.setString(1, infoModif);
	        rs = pst.executeQuery();
			rs.close();
		} catch (SQLException erreur) {
			System.out.println("");
			erreur.printStackTrace();
		}	
		Modele.deconnexion();
		return rep;	
	}	
}