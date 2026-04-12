package allumettes;

public class Procuration implements Jeu {

	private Jeu jeuReel;

	public Procuration(Jeu jeu) {
		this.jeuReel = jeu;
	}

	@Override
	public int getNombreAllumettes() {
		return this.jeuReel.getNombreAllumettes();
	}

	//interdit d'enlever des allumettes via la procuration
	@Override
	public void retirer(int nbPrises) throws CoupInvalideException {
		throw new OperationInterditeException("retirer est interdit via la procuration");
	}

	@Override
	public String toString() {
		return this.jeuReel.toString();
	}
}