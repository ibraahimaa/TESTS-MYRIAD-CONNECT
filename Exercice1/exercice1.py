import re 

def is_french_number(cell_number):

	"""
	Nous nous assurons que la fonction prend en parametre une chaine
	de caractere conformément à l'énoncé. 
	"""
	if not isinstance(cell_number,str):
		return False

	"""
	La validation du numéro de téléphone mobile français au format international 
	 est faite à travers cette expression réguliere
	"""
	return re.match("^(00|"+re.escape('+')+")33(6|7)\d{8}$",cell_number)
	



