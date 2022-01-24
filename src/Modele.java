import java.sql.*;
import java.util.ArrayList;


/**
 * 
 * @author lucas_kaniewski | mickael_campos
 *
 */

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
	 * Methode de connexion � la bdd
	*/
	
	public static void connexionBdd() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//connexion = DriverManager.getConnection("jdbc:mysql://172.16.203.212/binder?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC", "sio", "slam");
			connexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1/binder?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC", "root", "");
			st = connexion.createStatement();
		} catch (ClassNotFoundException e) {
			System.out.println("Le driver n'as pu �tre charg�");
			//	erreur.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Erreur de la connexion � la bdd");
			//	e.printStackTrace();
		}
	}
		
	/**
	 * M�thode de la d�connexion de la bdd
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
	        while( rs.next()) { // .next il rentre dans le tableau � la premier ligne et le parcours l ar l
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
	 * la fonction retourne les ID des facture pr�sente dans la bdd
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
			System.out.println("Erreur lors de la recup�ration des numero de facture");
			erreur.printStackTrace();
		}
		Modele.deconnexion();
		return liste;
	}
			
	/**
	 * getNbFacture()
	 * la fonction retourne le nombre de facture pr�sente dans la bdd
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
			System.out.println("Erreur lors de la recup�ration du nombre de facture");
			erreur.printStackTrace();
		}
		Modele.deconnexion();
		return rep;
	}
			
	/**
	 * @param idFacture
	 * 
	 * recupListElementFacture(int idFacture)
	 * la fonction retourne les �l�ments li� � la facture 'idFacture'
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
			System.out.println("Erreur lors de la recup�ration des descriptions");
			erreur.printStackTrace();
		}
		Modele.deconnexion();
		return liste;
	}
		
	/**
	 * getNbElementFacture(int idFacture)
	 * la fonction retourne le nombre d'�l�ments li� � une facture
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
			System.out.println("Erreur lors de la recup�ration du nombre d'�l�ment de la facture");
			erreur.printStackTrace();
		}
		Modele.deconnexion();
		return rep;
	}
}