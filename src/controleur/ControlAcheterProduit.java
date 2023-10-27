package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}
	public Gaulois[] rechercherVendeurs(String produit) {
		return village.rechercherVendeursProduit(produit);
	}
	
	public String[] donnerInfosMarche() {
		return village.donnerEtatMarche();
	}
	
	public String[] infoVendeur(Gaulois vendeur) {
		Etal etal=controlTrouverEtalVendeur.trouverEtalVendeur(vendeur.getNom());
		return etal.etatEtal();
	}
	public void acheterProduit(Gaulois vendeur,int quantite) {
		Etal etalVendeur=village.rechercherEtal(vendeur);
		etalVendeur.acheterProduit(quantite);
		
	}
	
}
