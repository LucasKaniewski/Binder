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

}