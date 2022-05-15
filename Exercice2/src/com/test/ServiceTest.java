package com.test;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.ussd.Service;

public class ServiceTest {
	/*
	 * Cette methode nous permet de tester l'acces et la navigation dans
	 * l'application ,assurés par la methode navigate de la classe Service.
	 * L'exemple que j'implémente ici teste lorsque l'utilisateur tape la touche 8
	 * depuis l'ecran solde (id=2) s'i la méthode lui ramene vers le bon écran a
	 * savoir l'écran d'accueil(id=1)
	 * 
	 * Pour rappel , la méthode setPrevious de la classe Service change la valeur de
	 * l'id de l'ecran préccédent la méthode setCurrent celle de l'écran courrant
	 * 
	 * la variable input represente la valeur de l'entrée utilisateur, la variable
	 * exepted represente la réponse attendue par le test a savoir l'id du bon ecran
	 * .
	 *
	 */
	@Test
	public void testNavigate() {
		Service service = new Service();
		service.setPrevious(1);
		service.setCurrent(2);

		String input = "8";
		int exepted = 1;
		int result = service.navigate(input);
		assertEquals(exepted, result);

	}
}
