package com.ussd;

import java.lang.reflect.Method;
import java.util.Scanner;

/*
 * Cette classe comme son nom l'indique est le point d'entr� de l'application.
 *  L'application tourne en boucle infinie a l'�coute de potentielles entr�es de 
 *  l'utilisateur
 */
public class Main {
	public static void main(String[] args) {
		Service service = new Service();
		Ecran ecran = new Ecran();
		while (true) {
			Scanner scanner = new Scanner(System.in);
			System.out.println(":");
			String input = scanner.nextLine();
			Method methode = null;
			try {
				/*
				 * appel de la navigation qui renverra l'id de l'ecran a afficher selon le
				 * chiffre ou le code USSD entr� par l'utilisateur a travers l'appel de methode
				 * dynamique possible grace a la reflexion en java
				 */
				methode = Class.forName("com.ussd.Service").getMethod("navigate", String.class);
				int idEcran = (int) methode.invoke(service, input);
				/*
				 * Une fois l'id de l'ecran recuper� on peut maintant l'afficher en appelant
				 * aussi dynamiquement la methode qui est contenue dans la liste des ecrans de
				 * la Classe Ecran dont la cl� est ce id
				 */
				methode = Class.forName("com.ussd.Ecran").getMethod(ecran.getEcrans().get(idEcran));
				methode.invoke(service);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
}
