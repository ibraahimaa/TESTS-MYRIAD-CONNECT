package com.ussd;

/* 
 * Cette classe est le maitre d'orchestre de l'application.
 */
public class Service {
	// d�claration et initialisation des id de l'�cran courant et de l'�cran
	// pr�cc�dent
	private int current = 0, previous = 0;

	public void setCurrent(int current) {
		this.current = current;
	}

	public void setPrevious(int previous) {
		this.previous = previous;
	}

	/*
	 * Conform�ment � l'enonc� cette fonction dont le param�tre est la cha�ne de
	 * caract�res tap�e par l'utilisateur(un code USSD ou un chiffre) et qui
	 * retourne l'identifiant de l'�cran suivant � lui afficher Pour cela sa logique
	 * s'appuie sur la base de l'entr�e utilisateur , la vue courrante et la vue
	 * pr�ccedente
	 */
	public int navigate(String input) {
		/*
		 * N'eut �t� le respect de l'�nonc� , je proposerais d'isoler ce bloc de code
		 * qui dirige l'utilisateur dans l'accueil si le code USSD #123# tap� ,car une
		 * fois qu'on est dans l'�cran d'accueil , on a plus besoin de verifier si le
		 * #123# est tap� a chaque appel de la methode navigate.
		 */
		if (previous == 0 && input.equals("#123#")) {
			/*
			 * R�ponse a la 1 ere question de l'exerice 3 : Pour sauvegarder dans une base
			 * de donn�es chaque acc�s d�un utilisateur au #123#. le code sera mis ici
			 * 
			 * Bon code USSD GOTO ACCUEIL
			 */
			previous = Ecran.ID_ACCUEIL;
			current = Ecran.ID_ACCUEIL;
		} else if (previous == 0 && !input.equals("#123#")) {
			// erreur USSD
			previous = 0;
			current = Ecran.ID_INVALIDE;
		}

		else if ((current == Ecran.ID_SOLDE || current == Ecran.ID_NUMERO) && input.equals(Ecran.TOUCHE_RETOUR)) {
			// retour a l'ecran d'accueil depuis l'ecran du solde ou du numero
			current = Ecran.ID_ACCUEIL;
			previous = Ecran.ID_ACCUEIL;
		} else if (current == Ecran.ID_ACCUEIL && input.equals(Ecran.GO_TO_SOLDE)) {
			// 'ecran du solde
			previous = Ecran.ID_ACCUEIL;
			current = Ecran.ID_SOLDE;
		} else if (current == Ecran.ID_ACCUEIL && input.equals(Ecran.Go_TO_NUMERO)) {
			// 'ecran du num�ro
			previous = Ecran.ID_ACCUEIL;
			current = Ecran.ID_NUMERO;
		}

		else if (current > 1 && input.equals(Ecran.TOUCHE_RETOUR)) {
			// retour en arriere dans la navigation
			current = previous;
		} else {
			// ecran d'erreur
			if (current != Ecran.ID_ERREUR)
				previous = current;
			current = Ecran.ID_ERREUR;
		}

		return current;

	}

}