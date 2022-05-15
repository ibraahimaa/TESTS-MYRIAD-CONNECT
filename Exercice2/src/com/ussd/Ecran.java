package com.ussd;

import java.util.HashMap;
import java.util.Map;

/*
 * Cette classe contient les différentes  vues de l'application
 */
public class Ecran {

	static final int ID_ACCUEIL = 1, ID_SOLDE = 2, ID_NUMERO = 3, ID_ERREUR = 4, ID_INVALIDE = 5;
	static final String TOUCHE_RETOUR = "8", GO_TO_SOLDE = "1", Go_TO_NUMERO = "2";

	/*
	 * Les diffrérents écrans sont rencensés dans ce tableau pour pouvoir les
	 * invoquer au besoin dans les services
	 */
	private Map<Integer, String> ecrans;

	public Map<Integer, String> getEcrans() {
		return ecrans;
	}

	public Ecran() {
		ecrans = new HashMap<Integer, String>();
		ecrans.put(ID_ACCUEIL, "accueil");
		ecrans.put(ID_SOLDE, "solde");
		ecrans.put(ID_NUMERO, "numero");
		ecrans.put(ID_ERREUR, "erreur");
		ecrans.put(ID_INVALIDE, "invalide");
	}

	public static void accueil() {
		System.out.println("|--------------------------------------------|");
		System.out.println(String.format("|%-44s|", ""));
		System.out.println(String.format("|%-44s|", "  Bienvenue sur #123#"));
		System.out.println(String.format("|%-44s|", "  1:Mon solde"));
		System.out.println(String.format("|%-44s|", "  2:Mon numéro"));
		System.out.println(String.format("|%-44s|", ""));
		System.out.println("|--------------------------------------------|\n");

	}

	public static void solde() {
		System.out.println("|--------------------------------------------|");
		System.out.println(String.format("|%-44s|", ""));
		System.out.println(String.format("|%-44s|", "  Solde"));
		System.out.println(String.format("|%-44s|", "  Il vous reste 56 min d'appels et 440 Mo."));
		System.out.println(String.format("|%-44s|", "  8: Retour"));
		System.out.println(String.format("|%-44s|", ""));
		System.out.println("|--------------------------------------------|\n");

	}

	public static void numero() {
		System.out.println("|--------------------------------------------|");
		System.out.println(String.format("|%-44s|", ""));
		System.out.println(String.format("|%-44s|", "  Mon numéro de téléphone est 0699999999."));
		System.out.println(String.format("|%-44s|", "  8: Retour"));
		System.out.println(String.format("|%-44s|", ""));
		System.out.println(String.format("|%-44s|", ""));
		System.out.println("|--------------------------------------------|\n");
	}

	public static void erreur() {
		System.out.println("|--------------------------------------------|");
		System.out.println(String.format("|%-44s|", ""));
		System.out.println(String.format("|%-44s|", "  Erreur : entrée invalide"));
		System.out.println(String.format("|%-44s|", "  8 : Retours"));
		System.out.println(String.format("|%-44s|", ""));
		System.out.println(String.format("|%-44s|", ""));
		System.out.println("|--------------------------------------------|\n");
	}

	public static void invalide() {
		System.out.println("|--------------------------------------------|");
		System.out.println(String.format("|%-44s|", ""));
		System.out.println(String.format("|%-44s|", ""));
		System.out.println(String.format("|%-44s|", "  Erreur : code USSD invalide."));
		System.out.println(String.format("|%-44s|", ""));
		System.out.println(String.format("|%-44s|", ""));
		System.out.println("|--------------------------------------------|\n");
	}

}