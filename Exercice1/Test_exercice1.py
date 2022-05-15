import exercice1
import unittest

"""
	Dans cette classe nous testons la méthode de validation d'un numéro de téléphone mobile français au format international grace à la bibliotheque unittest.

	Le fichier data.txt contient sur chaque ligne un numéro de téléphone. Le test unitaire passera
	sur chaque enregistrement et vérifiera si c'est un numéro francais au format internationnal grace a 
	la méthode is_french_number dans le module exercice1.

	A la fin du test on imprime a l'écran la liste des lignes défiallantes et en levant une exeption pour accentuer les erreurs s'il yen a sinon on affichera un OK pour le succes complet du test.

"""
class TestExercice1(unittest.TestCase):

	def testNumero(self):
		count = 0
		error = False
		print("\n")
		with open('data.txt', 'r') as file:
			while True:
				line = file.readline()
				count += 1
				if not line:
					break				
				try:
					result = exercice1.is_french_number(line)
					self.assertTrue(result)  
				except(AssertionError):
					error = True
					message = "Erreur ,le numéro à ligne "+str(count)+" n'est pas un numéro de téléphone mobile français au format international !"
					print(message)
			if error :
				print("\n")
				raise AssertionError

		
if __name__ == '__main__':
    unittest.main()