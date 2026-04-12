package allumettes;

//classe qui représente le plateau du jeu
public class JeuReel implements Jeu {

	private int nbAllumettes;

	public JeuReel(int nb) {
		this.nbAllumettes = nb;
	}

	//constructeur par defaut, 13 allumettes
	public JeuReel() {
		this(13);
	}

	@Override
	public int getNombreAllumettes() {
		return this.nbAllumettes;
	}

	@Override
	public void retirer(int nbPrises) throws CoupInvalideException {
		if (nbPrises < 1) {
			throw new CoupInvalideException(nbPrises, "< 1");
		}
		if (nbPrises > PRISE_MAX) {
			throw new CoupInvalideException(nbPrises, "> " + PRISE_MAX);
		}
		//on peut pas prendre plus que ce qui reste
		if (nbPrises > this.nbAllumettes) {
			throw new CoupInvalideException(nbPrises, "> " + this.nbAllumettes);
		}
		this.nbAllumettes -= nbPrises;
	}

	@Override
	public String toString() {
		return "Allumettes restantes : " + this.nbAllumettes;
	}

}