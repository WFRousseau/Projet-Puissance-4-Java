/*
 * Menu.java
 * Ce programme permet d'acceder à differents jeux, il constitue un hub central.
 */

import java.util.Scanner;
public class Menu {

	public static void main(String[] args) {
		
		Scanner saisie = new Scanner(System.in);
		int instruction, reponse;
		String pseudo1, pseudo2;

		System.out.println("Bienvenue, utilisateur !");
		do {
			System.out.println();
			System.out.println("1. Puissance 4\n2. Prochainement...\n3. Prochainement...\n4. Prochainement...\n5. Quitter");
			System.out.println();
			System.out.println("Que souhaitez-vous faire ?");
			instruction = Integer.parseInt(saisie.nextLine());

			switch (instruction) {

			case 1: System.out.println("Veuillez saisir un premier pseudo :");
					pseudo1 = saisie.nextLine();
					System.out.println("Veuillez saisir le deuxième pseudo :");
					pseudo2 = saisie.nextLine();
					do {
						JeuPuissance4.puissance4(pseudo1, pseudo2);
						System.out.println("Souhaitez vous rejouer ?");
						System.out.println();
						System.out.println("1. Oui\n2. Non");
						System.out.println();
						System.out.println("Réponse: ");
						reponse = Integer.parseInt(saisie.nextLine());
						while (reponse<1||reponse>2) {
							System.out.println("Erreur: veuillez choisir une réponse parmi celles proposées :");
							System.out.println("Réponse: ");
							reponse = Integer.parseInt(saisie.nextLine());
						}
					}
					while (reponse!=2);
			break;
			case 2: System.out.println("Erreur: vous ne possedez pas les droits nécessaires d'acces.");
			break;
			case 3: System.out.println("Erreur: vous ne possedez pas les droits nécessaires d'acces.");
			break;
			case 4: System.out.println("Erreur: vous ne possedez pas les droits nécessaires d'acces.");
			break;

			}
		}
		
		while (instruction!=5);
		
		System.out.println("Vous avez quitte le menu.");

		saisie.close();


	}
}
