package controleur;

import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlLibererEtal {
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;

	public ControlLibererEtal(
			ControlTrouverEtalVendeur controlTrouverEtalVendeur) {
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	//TODO a completer

	/**
	 * 
	 * @param produit
	 * @return donneesVente est un tableau de chaine contenant [0] : un boolean
	 *         indiquant si l'étal est occupé [1] : nom du vendeur [2] : produit
	 *         vendu [3] : quantité de produit à vendre au début du marché [4] :
	 *         quantité de produit vendu
	 */
	public String[] libererEtal(String nomVendeur) {
		String[] donneesEtal = null;
		Etal etal=controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		donneesEtal[0]=
		donneesEtal[1]=nomVendeur;
		donneesEtal[2]=etal.getProduit();
		donneesEtal[3]=etal.etatEtal()[3];
		donneesEtal[4]=etal.etatEtal()[4];
		return donneesEtal;
	}
	
	public boolean isVendeur(String nomVendeur) {;
		Etal etal=controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		return etal!=null;
	}

}
