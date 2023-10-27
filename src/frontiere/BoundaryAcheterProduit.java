package frontiere;

import java.util.Scanner;
import java.util.stream.Node.OfInt;

import controleur.ControlAcheterProduit;
import personnages.Gaulois;
import villagegaulois.Etal;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		System.out.println("Quel produit voulez-vous achetez ?");
		String produit =scan.next();
		System.out.println("Chez quel commerçant voulez-vous acheter des fleurs ?");
		Gaulois[] listevendeurs=controlAcheterProduit.rechercherVendeurs(produit);
		if (listevendeurs==null) {
			System.out.println("Désolé, personne ne vend ce produit au marché");
			
		}
		else {
		for (int i=0;i<listevendeurs.length;i++) {
			System.out.println("- "+i+" "+listevendeurs[i].getNom());
		}
		String numvendeurString =null;
		int numvendeur=Clavier.entrerEntier(numvendeurString);
		Gaulois vendeurchoisi=listevendeurs[numvendeur];
		System.out.println(nomAcheteur+" se déplace jusqu'a l'etal du vendeur "+vendeurchoisi.getNom());
		String[] listeinfovendeur=controlAcheterProduit.infoVendeur(vendeurchoisi);
		System.out.println("Bonjour "+nomAcheteur);
		System.out.println("Combien de "+produit+" voulez-vous acheter ?");
		String nbrproduitS =null;
		int nbrproduit=Clavier.entrerEntier(nbrproduitS);
		
		
		if (nbrproduit>Integer.parseInt(listeinfovendeur[4])) {
			System.out.println(nomAcheteur+" veut acheter "+nbrproduit+", malheureusement "+vendeurchoisi.getNom()+" n'en a plus que "+listeinfovendeur[4]+". "+nomAcheteur+" achète tout le stock de "+vendeurchoisi.getNom());
			controlAcheterProduit.acheterProduit(vendeurchoisi,Integer.parseInt(listeinfovendeur[4]) );
			
		}
		else {
			if (Integer.parseInt(listeinfovendeur[4])==0) {
				System.out.println(nomAcheteur+" veut acheter "+nbrproduit+", malheureusement il n'y en a plus !");
				
			}
			else {
				System.out.println(nomAcheteur+" achète "+nbrproduit+" "+produit+" à "+vendeurchoisi.getNom());
				controlAcheterProduit.acheterProduit(vendeurchoisi,Integer.parseInt(listeinfovendeur[4]) );
				
			}
		}
		}
		}
	}
}
