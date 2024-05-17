package fr.eni.ludotheque.bll;

import java.util.List;
import java.util.Optional;

import fr.eni.ludotheque.bo.ModeleJeu;

public interface ModeleJeuService {
	public ModeleJeu ajouterModeleJeu(ModeleJeu modeleJeu);
	
	public Optional<ModeleJeu> lireModeleJeu(Integer id);
	
	public List<ModeleJeu> lireModelesJeux();
	
	public ModeleJeu modifierModeleJeu(ModeleJeu modeleJeu, Integer id);
	
	public void supprimerJeu(Integer id);
}
