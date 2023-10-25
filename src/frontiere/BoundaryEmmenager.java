package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println("Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					System.out.println("Bienvenu villageois " + nomVisiteur + " !");
					System.out.println("Quelle est votre force ?");
					int choixforce = -1;
					choixforce = Clavier.entrerEntier(question.toString());
					controlEmmenager.ajouterGaulois(nomVisiteur, choixforce);

					break;

				default:
					System.out.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

		
	private void emmenagerDruide(String nomVisiteur) {
		StringBuilder question = new StringBuilder();
		System.out.println("Bienvenu druide " + nomVisiteur + " !");
		System.out.println("Quelle est votre force ?");
		int choixforce = -1;
		int choixpotionmin = -1;
		int choixpotionmax = -2;
		choixforce = Clavier.entrerEntier(question.toString());
		while (choixpotionmax < choixpotionmin) {
			System.out.println("Quelle est la force de potion la plus faible que vous produisez ?");
			choixpotionmin = Clavier.entrerEntier(question.toString());
			System.out.println("Quelle est la force de potion la plus forte que vous produisez ?");
			choixpotionmax = Clavier.entrerEntier(question.toString());
			if (choixpotionmax < choixpotionmin) {
				System.out.println("Attention Druide, vous vous �tes tromp� entre le minimum et le maximum");
			}
		}
		controlEmmenager.ajouterDruide(nomVisiteur, choixforce, choixpotionmin,choixpotionmax);
	}
	
}
