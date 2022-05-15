package com.ussd;

/* 
 * Cette classe est le maitre d'orchestre de l'application.
 */
public class Service {
	// déclaration et initialisation des id de l'écran courant et de l'écran
	// préccédent
	private int current = 0, previous = 0;

	public void setCurrent(int current) {
		this.current = current;
	}

	public void setPrevious(int previous) {
		this.previous = previous;
	}

	/*
	 * Conformément à l'enoncé cette fonction dont le paramètre est la chaîne de
	 * caractères tapée par l'utilisateur(un code USSD ou un chiffre) et qui
	 * retourne l'identifiant de l'écran suivant à lui afficher Pour cela sa logique
	 * s'appuie sur la base de l'entrée utilisateur , la vue courrante et la vue
	 * préccedente
	 */
	public int navigate(String input) {
		/*
		 * N'eut été le respect de l'énoncé , je proposerais d'isoler ce bloc de code
		 * qui dirige l'utilisateur dans l'accueil si le code USSD #123# tapé ,car une
		 * fois qu'on est dans l'écran d'accueil , on a plus besoin de verifier si le
		 * #123# est tapé a chaque appel de la methode navigate.
		 */
		if (previous == 0 && input.equals("#123#")) {
			/*
			 * Réponse a la 1 ere question de l'exerice 3 : Pour sauvegarder dans une base
			 * de données chaque accès d’un utilisateur au #123#. le code sera mis ici
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
			// 'ecran du numéro
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