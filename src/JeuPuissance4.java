/*
 * JeuPuissance4.java
 * Ce programme constitue le corps du jeu et permet son déroulement. 
 */
import java.util.Scanner;
public class JeuPuissance4 {
	
	public static void puissance4(String pseudoA, String pseudoB) {
		
		Scanner saisie = new Scanner (System.in);
		String pseudo1, pseudo2, joueur1, joueur2;
		int colonne, nombreDeTour=0;
		boolean gagnant=false;
		char R='R', J='J';

		char[][] tableauDeJeu = Methodes.creationTableau();

		pseudo1 = pseudoA;
		pseudo2 = pseudoB;
		joueur1 = Methodes.starter(pseudo1, pseudo2);
		if (joueur1==pseudo1)
			joueur2=pseudo2;
		else
			joueur2=pseudo1;
		
		System.out.println();
		System.out.println("Le joueur qui commence est " + joueur1 + " ! Vos jetons seront les R !");
		System.out.println(joueur2 + ", vos jetons seront les J !");
		System.out.println();
		Methodes.afficherTab(tableauDeJeu);
		
		while (gagnant!=true && !Methodes.verifierSiCestPlein(tableauDeJeu)) {
			System.out.println(joueur1+", c'est votre tour.");
			System.out.println("Dans quelle colonne souhaitez-vous placer votre pion ?");
			colonne=Methodes.choisirColonne();
			while (!Methodes.jouerSonTour(tableauDeJeu, colonne, R)) {
				System.out.println("Erreur : vous avez choisi une colonne pleine, veuillez en choisir une autre :");
				colonne=Methodes.choisirColonne();
			}
			Methodes.afficherTab(tableauDeJeu);
			
			nombreDeTour++;

			if (nombreDeTour>=4) {
				if (Methodes.verifierSiGagnant(tableauDeJeu, R)) {
					System.out.println(joueur1+" est le vainqueur ! Felicitation !");
					gagnant=true;;
				}
				else {
					Methodes.afficherTab(tableauDeJeu);
					System.out.println(joueur2+", c'est votre tour.");
					System.out.println("Dans quelle colonne souhaitez-vous placer votre pion ?");
					colonne=Methodes.choisirColonne();
					while (!Methodes.jouerSonTour(tableauDeJeu, colonne, J)) {
						System.out.println("Erreur : vous avez choisi une colonne pleine, veuillez en choisir une autre :");
						colonne=Methodes.choisirColonne();
					}
					Methodes.afficherTab(tableauDeJeu);

					if (Methodes.verifierSiGagnant(tableauDeJeu, J)) {
							System.out.println(joueur2+" est le vainqueur ! Felicitation !");
							gagnant=true;
					}
					else {
						if(Methodes.verifierSiCestPlein(tableauDeJeu)) {
							System.out.println("Egalite !");
							System.out.println();
						}
					}
				}
			}
			
			else {
				System.out.println(joueur2+", c'est votre tour.");
				System.out.println("Dans quelle colonne souhaitez-vous placer votre pion ?");
				colonne=Methodes.choisirColonne();
				while (!Methodes.jouerSonTour(tableauDeJeu, colonne, J)) {
					System.out.println("Erreur : vous avez choisi une colonne pleine, veuillez en choisir une autre :");
					colonne=Methodes.choisirColonne();
				}
				Methodes.afficherTab(tableauDeJeu);
			}
		}
		//penser à mettre la méthode pour checker un tableau plein
	}
}

