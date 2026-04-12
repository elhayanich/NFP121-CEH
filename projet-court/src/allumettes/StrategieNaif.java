package allumettes;

import java.util.Random;

//choisit un nombre aleatoire entre 1 et 3
public class StrategieNaif implements Strategie {

	private Random rand;
	public StrategieNaif() {
		this.rand = new Random();
	}

	@Override
	public int getPrise(Jeu jeu) {
		int max = Math.min(Jeu.PRISE_MAX, jeu.getNombreAllumettes());
		// entre 1 et max
		return rand.nextInt(max) + 1;
	}
}