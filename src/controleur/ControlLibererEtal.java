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
		Etal etal=controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		String[] donneesEtal =etal.etatEtal();
		if (Boolean.valueOf(donneesEtal[0])) {
		etal.libererEtal();}
		return donneesEtal;
	}
	
	public boolean isVendeur(String nomVendeur) {;
		Etal etal=controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		return etal!=null;
	}

}
