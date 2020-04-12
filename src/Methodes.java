/*
 * Methodes.java
 * Ce programme conditionne tous les sous-prog necessaires au bon déroulement du jeu.
 */
import java.util.Scanner;
public class Methodes {
	
	public static char[][] creationTableau() {
		char[][] tableauDeJeu = new char[6][7];
		//On remplit chaque indice d'un espace car cela sera utile pour verifier si la colonne est pleine
		for (int ligne = 0 ; ligne < tableauDeJeu.length ; ligne++) {
			for (int colonne = 0 ; colonne < tableauDeJeu[ligne].length ; colonne++) {
				 tableauDeJeu[ligne][colonne]=' ';
			}
		}
		return tableauDeJeu;
	}
	
	public static void afficherTab(char[][] tab) {
		System.out.println("  - Colonne -");
		System.out.println(" 1 2 3 4 5 6 7");
		//On parcourt les deux tableaux pour les mettre en forme rectangulaire pour representer le tableau de jeu
		for (int ligne = 0 ; ligne < tab.length ; ligne++) {
			System.out.print("|");
			for (int colonne = 0 ; colonne < tab[ligne].length ; colonne++) {
				 System.out.print(tab[ligne][colonne] + "|");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static String starter(String pseudo1, String pseudo2) {
		//On choisit au hasard qui sera le premier a jouer 
		if ((int)(Math.random()*2)+1 == 1) {
			return pseudo1;
		}
		else {
			return pseudo2;
		}
		
	}
	
	public static boolean verifierSiCestPlein(char[][] tab) {
		for (int colonne = 0 ; colonne < tab[0].length ; colonne++) {
			if (tab[0][colonne]==' ') {
				return false;
			}
			
		}
		return true;
	}
	
	public static boolean jouerSonTour(char[][] tab, int colonne, char jeton) {
		
		//On verifie que la colonne n'est pas pleine en regardant le plus haut trou de la colonne
		if (tab[0][colonne]!=' ') {
			return false;
		}
		//Puisque la colonne n'est pas pleine, on remonte de bas en haut jusqu'a trouver le premier emplacement libre
		else {
			int ligne = tab.length-1;
			while(tab[ligne][colonne]!=' ') {
				ligne--;
			}
			tab[ligne][colonne]=jeton;
			return true;
		}
			
	}
	
	public static int choisirColonne() {
		Scanner saisie = new Scanner (System.in);
		int colonne;
		colonne = Integer.parseInt(saisie.nextLine());
		colonne= colonne-1;
		//Si la colonne choisie n'existe pas, on force l'utilisateur a en choisir une valide
		if (colonne<0||colonne>6) {
			do {
				System.out.println("Erreur: Veuillez choisir une colonne comprise entre 1 et 7.");
				System.out.println("Dans quelle colonne souhaitez-vous placer votre pion ?");
				colonne = Integer.parseInt(saisie.nextLine());
				colonne= colonne-1;
			}
			while(colonne<0||colonne>6);
		}
		return colonne;
	}
	
	public static boolean verifierSiGagnant(char[][] tab, char jeton) {
		for (int ligne = 0 ; ligne < tab.length ; ligne++) {
			for (int colonne = 0 ; colonne < tab[ligne].length ; colonne++) {
				int lettreJeton=tab[ligne][colonne];
				
				if (lettreJeton == jeton) {
					if ((compterLesJetons(tab, ligne, colonne, 0, 1, jeton) >= 4)||(compterLesJetons(tab, ligne, colonne, 1, 0, jeton) >= 4)||(compterLesJetons(tab, ligne, colonne, -1, 1, jeton) >= 4)||(compterLesJetons(tab, ligne, colonne, 1, 1, jeton) >= 4)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public static int compterLesJetons(char[][]tab, int ligne, int colonne, int sensLigne, int sensColonne, char jeton) {
		int compteur=0;
		
		while (tab[ligne][colonne] == jeton && (ligne >= 0 && ligne < 6) && (colonne >= 0 && colonne < 7)) {
			compteur++;
			ligne = ligne + sensLigne;
			colonne = colonne + sensColonne;
			//On verifie que les variables ne sortent pas du tableau
			//Si c'est le cas, ça ne sert a rien de continuer.
			if (ligne>=6||ligne<0||colonne>=7||colonne<0) {
				return compteur;
			}
		}
		return compteur;	
	}

}

	