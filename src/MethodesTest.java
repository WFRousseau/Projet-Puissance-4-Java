import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MethodesTest {

	@Test
	public final void testJouerSonTour() {
		
		char[][] tabSansJeton = {{' ', ' ', ' ', ' ', ' ', ' ', ' '},
								 {' ', ' ', ' ', ' ', ' ', ' ', ' '},
								 {' ', ' ', ' ', ' ', ' ', ' ', ' '},
								 {' ', ' ', ' ', ' ', ' ', ' ', ' '},
								 {' ', ' ', ' ', ' ', ' ', ' ', ' '}, 
								 {' ', ' ', ' ', ' ', ' ', ' ', ' '}};
		
		assertTrue (Methodes.jouerSonTour(tabSansJeton, 3, 'R'), "cas tableau vide");
		
		char[][] tabPlein= {{'R', 'R', 'R', 'R', 'R', 'R', 'R'},
							{'R', 'R', 'R', 'R', 'R', 'R', 'R'},
							{'R', 'R', 'R', 'R', 'R', 'R', 'R'},
							{'R', 'R', 'R', 'R', 'R', 'R', 'R'},
							{'R', 'R', 'R', 'R', 'R', 'R', 'R'}, 
							{'R', 'R', 'R', 'R', 'R', 'R', 'R'}};
		
		assertFalse (Methodes.jouerSonTour(tabPlein, 3, 'R'), "case tableau plein");
		
		char[][] tabPrequePlein= {{'R', 'R', 'R', ' ', 'R', 'R', 'R'},
								  {'R', 'R', 'R', 'R', 'R', 'R', 'R'},
								  {'R', 'R', 'R', 'R', 'R', 'R', 'R'},
								  {'R', 'R', 'R', 'R', 'R', 'R', 'R'},
								  {'R', 'R', 'R', 'R', 'R', 'R', 'R'}, 
								  {'R', 'R', 'R', 'R', 'R', 'R', 'R'}};
		
		assertTrue (Methodes.jouerSonTour(tabSansJeton, 3, 'R'), "cas: la seule colonne non pleine");
		
		//Montre que la methode n'analyse que la première ligne de chaque colonne
		//Donc si le haut de la colonne indiqué en paramètre est rempli, peu importe le contenu, le programme considère que c'est plein
		//La me thode Methodes.verifierSiCestPlein fonctionne sur le même principe sauf qu'elle le fait sur toute les colonnes.
		char[][] tabPleinBis = {{'R', 'R', 'R', 'R', 'R', 'R', 'R'},
								{' ', ' ', ' ', ' ', ' ', ' ', ' '},
								{' ', ' ', ' ', ' ', ' ', ' ', ' '},
								{' ', ' ', ' ', ' ', ' ', ' ', ' '},
								{' ', ' ', ' ', ' ', ' ', ' ', ' '}, 
								{' ', ' ', ' ', ' ', ' ', ' ', ' '}};
		
		assertFalse (Methodes.jouerSonTour(tabPleinBis, 3, 'R'), "case tableau plein bis");
	}
	
	@Test
	public final void testCompterLesJetons() {
		
		char[][] tabSansJeton = {{' ', ' ', ' ', ' ', ' ', ' ', ' '},
				   				 {' ', ' ', ' ', ' ', ' ', ' ', ' '},
				   				 {' ', ' ', ' ', ' ', ' ', ' ', ' '},
				   				 {' ', ' ', ' ', ' ', ' ', ' ', ' '},
				   				 {' ', ' ', ' ', ' ', ' ', ' ', ' '}, 
				   				 {' ', ' ', ' ', ' ', ' ', ' ', ' '}};

		//Toutes les méthodes seront mauvaises puisque lorsque le tableau est vide, cette méthode n'est pas appelée
		assertEquals (0, Methodes.compterLesJetons(tabSansJeton, 0, 0, -1, 1, 'R'), "cas sans jeton: 1ere méthode");
		assertEquals (0, Methodes.compterLesJetons(tabSansJeton, 0, 0, 0, 1, 'R'), "cas sans jeton: 2eme méthode");
		assertEquals (0, Methodes.compterLesJetons(tabSansJeton, 0, 0, 1, 1, 'R'), "cas sans jeton: 3eme méthode");
		assertEquals (0, Methodes.compterLesJetons(tabSansJeton, 0, 0, 1, 0, 'R'), "cas sans jeton: 4eme méthode");
		
		char[][] tabSansP4= {{' ', ' ', ' ', ' ', ' ', ' ', ' '},
							 {' ', ' ', ' ', ' ', ' ', ' ', ' '},
							 {' ', ' ', ' ', ' ', ' ', ' ', ' '},
							 {'R', ' ', ' ', ' ', ' ', ' ', ' '},
							 {'R', ' ', ' ', ' ', ' ', ' ', ' '}, 
							 {'R', ' ', ' ', ' ', ' ', ' ', ' '}};
		
		//Il manque un jeton pour faire un P4 verticale donc on considerera la méthode qui trouve les P4 verticaux comme étant la "bonne méthode"
		assertEquals (3, Methodes.compterLesJetons(tabSansP4, 3, 0, 1, 0, 'R'), "cas sans puissance 4 : bonne méthode et bon jeton");
		assertEquals (1, Methodes.compterLesJetons(tabSansP4, 5, 0, 1, 0, 'R'), "cas puissance 4 verticale: bonne méthode et mauvais jeton");
		assertEquals (1, Methodes.compterLesJetons(tabSansP4, 3, 0, 1, 1, 'R'), "cas puissance 4 verticale: 1ere mauvaise méthode et bon jeton");
		assertEquals (1, Methodes.compterLesJetons(tabSansP4, 3, 0, 0, 1, 'R'), "cas puissance 4 verticale: 2eme mauvaise méthode et bon jeton");
		assertEquals (1, Methodes.compterLesJetons(tabSansP4, 3, 0, -1, 1, 'R'), "cas puissance 4 verticale: 3eme mauvaise méthode et bon jeton");
		
		char[][] tabP4Diagonale = {{' ', ' ', ' ', ' ', ' ', ' ', ' '},
								   {' ', ' ', ' ', ' ', ' ', ' ', ' '},
								   {' ', ' ', ' ', 'R', ' ', ' ', ' '},
								   {' ', ' ', 'R', ' ', ' ', ' ', ' '},
								   {' ', 'R', ' ', ' ', ' ', ' ', ' '}, 
								   {'R', ' ', ' ', ' ', ' ', ' ', ' '}};
		
		assertEquals (4, Methodes.compterLesJetons(tabP4Diagonale, 5, 0, -1, 1, 'R'), "cas puissance 4 diagonale: bonne méthode et bon jeton");
		assertEquals (3, Methodes.compterLesJetons(tabP4Diagonale, 4, 1, -1, 1, 'R'), "cas puissance 4 diagonale: bonne méthode et mauvais jeton");
		assertEquals (1, Methodes.compterLesJetons(tabP4Diagonale, 5, 0, 1, 1, 'R'), "cas puissance 4 diagonale: 1er mauvaise méthode et bon jeton");
		assertEquals (1, Methodes.compterLesJetons(tabP4Diagonale, 5, 0, 1, 0, 'R'), "cas puissance 4 diagonale: 2eme mauvaise méthode et bon jeton");
		assertEquals (1, Methodes.compterLesJetons(tabP4Diagonale, 5, 0, 0, 1, 'R'), "cas puissance 4 diagonale: 3eme mauvaise méthode et bon jeton");
		
		char[][] tabP4Horizontale = {{' ', ' ', ' ', ' ', ' ', ' ', ' '},
				   				     {' ', ' ', ' ', ' ', ' ', ' ', ' '},
				   				     {' ', ' ', ' ', ' ', ' ', ' ', ' '},
				   				     {' ', ' ', ' ', ' ', ' ', ' ', ' '},
				   				     {' ', ' ', ' ', ' ', ' ', ' ', ' '}, 
				   				     {' ', ' ', ' ', 'R', 'R', 'R', 'R'}};
		
		assertEquals (4, Methodes.compterLesJetons(tabP4Horizontale, 5, 3, 0, 1, 'R'), "cas puissance 4 horizontale: bonne méthode et bon jeton");
		assertEquals (1, Methodes.compterLesJetons(tabP4Horizontale, 5, 6, 0, 1, 'R'), "cas puissance 4 horizontale: bonne méthode et mauvais jeton");
		assertEquals (1, Methodes.compterLesJetons(tabP4Horizontale, 5, 3, 1, 1, 'R'), "cas puissance 4 horizontale: 1ere mauvaise méthode et bon jeton");
		assertEquals (1, Methodes.compterLesJetons(tabP4Horizontale, 5, 3, 1, 0, 'R'), "cas puissance 4 horizontale: 2eme mauvaise méthode et bon jeton");
		assertEquals (1, Methodes.compterLesJetons(tabP4Horizontale, 5, 3, -1, 1, 'R'), "cas puissance 4 horizontale: 3eme mauvaise méthode et bon jeton");
		
		char[][] tabP4Verticale = {{' ', ' ', ' ', 'R', ' ', ' ', ' '},
				     			   {' ', ' ', ' ', 'R', ' ', ' ', ' '},
				     			   {' ', ' ', ' ', 'R', ' ', ' ', ' '},
				     			   {' ', ' ', ' ', 'R', ' ', ' ', ' '},
				     			   {' ', ' ', ' ', ' ', ' ', ' ', ' '}, 
				     			   {' ', ' ', ' ', ' ', ' ', ' ', ' '}};
		
		assertEquals (4, Methodes.compterLesJetons(tabP4Verticale, 0, 3, 1, 0, 'R'), "cas puissance 4 verticale: bonne méthode et bon jeton");
		assertEquals (1, Methodes.compterLesJetons(tabP4Verticale, 3, 3, 1, 0, 'R'), "cas puissance 4 verticale: bonne méthode et mauvais jeton");
		assertEquals (1, Methodes.compterLesJetons(tabP4Verticale, 0, 3, 1, 1, 'R'), "cas puissance 4 verticale: 1ere mauvaise méthode et bon jeton");
		assertEquals (1, Methodes.compterLesJetons(tabP4Verticale, 0, 3, 0, 1, 'R'), "cas puissance 4 verticale: 2eme mauvaise méthode et bon jeton");
		assertEquals (1, Methodes.compterLesJetons(tabP4Verticale, 0, 3, -1, 1, 'R'), "cas puissance 4 verticale: 3eme mauvaise méthode et bon jeton");
		
	}
	
	@Test
	public final void testVerifierSiGagnant() {
		
		char[][] tabSansJeton = {{' ', ' ', ' ', ' ', ' ', ' ', ' '},
								 {' ', ' ', ' ', ' ', ' ', ' ', ' '},
								 {' ', ' ', ' ', ' ', ' ', ' ', ' '},
								 {' ', ' ', ' ', ' ', ' ', ' ', ' '},
								 {' ', ' ', ' ', ' ', ' ', ' ', ' '}, 
								 {' ', ' ', ' ', ' ', ' ', ' ', ' '}};
		
	 	assertFalse (Methodes.verifierSiGagnant(tabSansJeton, 'R'), "cas tableau vide");
	 	
	 	char[][] tabSansP4= {{' ', ' ', ' ', ' ', ' ', ' ', ' '},
				 			 {' ', ' ', ' ', ' ', ' ', ' ', ' '},
				 			 {' ', ' ', ' ', ' ', ' ', ' ', ' '},
				 			 {'R', ' ', ' ', ' ', ' ', ' ', ' '},
				 			 {'R', ' ', ' ', ' ', ' ', ' ', ' '}, 
				 			 {'R', ' ', ' ', ' ', ' ', ' ', ' '}};
	 	
	 	assertFalse (Methodes.verifierSiGagnant(tabSansP4, 'R'), "cas sans puissance 4");
	 	
	 	char[][] tabP4Diagonale = {{' ', ' ', ' ', ' ', ' ', ' ', ' '},
	 							   {' ', ' ', ' ', ' ', ' ', ' ', ' '},
	 							   {' ', ' ', ' ', 'R', ' ', ' ', ' '},
	 							   {' ', ' ', 'R', ' ', ' ', ' ', ' '},
	 							   {' ', 'R', ' ', ' ', ' ', ' ', ' '}, 
	 							   {'R', ' ', ' ', ' ', ' ', ' ', ' '}};
	 	
	 	assertTrue (Methodes.verifierSiGagnant(tabP4Diagonale, 'R'), "cas puissance 4 en diagonale");
	 	
	 	char[][] tabP4Horizontale = {{' ', ' ', ' ', ' ', ' ', ' ', ' '},
				     				 {' ', ' ', ' ', ' ', ' ', ' ', ' '},
				     				 {' ', ' ', ' ', ' ', ' ', ' ', ' '},
				     				 {' ', ' ', ' ', ' ', ' ', ' ', ' '},
				     				 {' ', ' ', ' ', ' ', ' ', ' ', ' '}, 
				     				 {' ', ' ', ' ', 'R', 'R', 'R', 'R'}};
	 	
	 	assertTrue (Methodes.verifierSiGagnant(tabP4Horizontale, 'R'), "cas puissance 4 a l'horizontale");
	 	
	 	char[][] tabP4Verticale = {{' ', ' ', ' ', 'R', ' ', ' ', ' '},
	 							   {' ', ' ', ' ', 'R', ' ', ' ', ' '},
	 							   {' ', ' ', ' ', 'R', ' ', ' ', ' '},
	 							   {' ', ' ', ' ', 'R', ' ', ' ', ' '},
	 							   {' ', ' ', ' ', ' ', ' ', ' ', ' '}, 
	 							   {' ', ' ', ' ', ' ', ' ', ' ', ' '}};
	 	
	 	assertTrue (Methodes.verifierSiGagnant(tabP4Verticale, 'R'), "cas puissance 4 a la verticale");
		
	}


}
