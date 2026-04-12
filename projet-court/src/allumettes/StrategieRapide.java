package allumettes;

//prend le maximum d'allumettes possible à chaque coup
public class StrategieRapide implements Strategie {

	@Override
	public int getPrise(Jeu jeu) {
		//on prend le min entre PRISE_MAX et ce qui reste
		int nb = jeu.getNombreAllumettes();
		if (nb >= Jeu.PRISE_MAX) {
			return Jeu.PRISE_MAX;
		}
		return nb;
	}
}