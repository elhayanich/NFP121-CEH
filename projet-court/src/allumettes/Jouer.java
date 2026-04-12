package allumettes;

import java.util.Scanner;

/** Lance une partie des 13 allumettes en fonction des arguments fournis
 * sur la ligne de commande.
 * @author	Xavier Crégut
 * @version	$Revision: 1.5 $
 */
public class Jouer {

	// le scanner unique pour toute l'appli (contrainte C8)
	static Scanner scanner = new Scanner(System.in);

	/** Lancer une partie. En argument sont donnés les deux joueurs sous
	 * la forme nom@stratégie.
	 * @param args la description des deux joueurs
	 */
	public static void main(String[] args) {
		try {
			verifierNombreArguments(args);

			System.out.println("\n\tà faire !\n");

		} catch (ConfigurationException e) {
			System.out.println();
			System.out.println("Erreur : " + e.getMessage());
			afficherUsage();
			System.exit(1);
		}
	}

	//crée un joueur à partir de la chaine "nom@strategie"
	static Joueur creerJoueur(String description) {
		String[] parts = description.split("@");
		if (parts.length != 2) {
			throw new ConfigurationException("Format invalide : " + description);
		}
		String nom = parts[0];
		String strat = parts[1];
		Strategie s = creerStrategie(strat, nom);
		return new Joueur(nom, s);
	}

	static Strategie creerStrategie(String strat, String nom) {
		if (strat.equals("rapide")) {
			return new StrategieRapide();
		} else if (strat.equals("naif")) {
			return new StrategieNaif();
		} else {
			throw new ConfigurationException("Stratégie inconnue : " + strat);
		}
	}

	private static void verifierNombreArguments(String[] args) {
		final int nbJoueurs = 2;
		if (args.length < nbJoueurs) {
			throw new ConfigurationException("Trop peu d'arguments : "
					+ args.length);
		}
		if (args.length > nbJoueurs + 1) {
			throw new ConfigurationException("Trop d'arguments : "
					+ args.length);
		}
	}

	/** Afficher des indications sur la manière d'exécuter cette classe. */
	public static void afficherUsage() {
		System.out.println("\n" + "Usage :"
				+ "\n\t" + "java allumettes.Jouer joueur1 joueur2"
				+ "\n\t\t" + "joueur est de la forme nom@stratégie"
				+ "\n\t\t" + "strategie = naif | rapide | expert | humain | tricheur"
				+ "\n"
				+ "\n\t" + "Exemple :"
				+ "\n\t" + "	java allumettes.Jouer Xavier@humain "
					   + "Ordinateur@naif"
				+ "\n"
				);
	}

}