package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		boolean idVerif=controlPrendreEtal.verifierIdentite(nomVendeur);
		if (!idVerif) {
			System.out.println("Je suis désolée "+nomVendeur+" mais il faut être un habitant de notre village pour commercer ici");
			
		}
		else {
			System.out.println("Bonjour "+nomVendeur+" ,je vais regarder si je peux vous trouver un étal");
			boolean etalDisponible=controlPrendreEtal.resteEtals();
			if (etalDisponible) {
				System.out.println("Désolée "+nomVendeur+" je n'ai plus d'étal qui ne soit pas déjà occupé");
			}
			else {
				System.out.println("C'est parfait, il me reste un étal pour vous !\n");
				System.out.println("Il me faudrait quelques renseignements :\n");
				System.out.println("Quel produit souaitez-vous vendre ?\n");
				String produit =scan.next();
				System.out.println("Combien souhaitez vous en vendre\n");
				StringBuilder question = new StringBuilder();
				int nbrproduit = Clavier.entrerEntier(question.toString());
				int numeroEtal=controlPrendreEtal.prendreEtal(nomVendeur,produit,nbrproduit);
				if (numeroEtal!=-1) {
					System.out.println("Le vendeur "+nomVendeur+ " s'est installé à l'étal numero "+numeroEtal);
				}
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		//TODO a completer
	}
}
