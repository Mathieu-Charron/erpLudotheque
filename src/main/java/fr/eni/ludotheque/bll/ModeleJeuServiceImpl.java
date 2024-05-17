package fr.eni.ludotheque.bll;

import java.util.List;
import java.util.Optional;

import fr.eni.ludotheque.bo.ModeleJeu;
import fr.eni.ludotheque.dal.ModeleJeuRepository;

public class ModeleJeuServiceImpl implements ModeleJeuService {
	
	private ModeleJeuRepository modeleJeuRepository;
	
	
	private ModeleJeuServiceImpl(ModeleJeuRepository modeleJeuRepository) {
		this.modeleJeuRepository = modeleJeuRepository;
	}

	public ModeleJeu ajouterModeleJeu(ModeleJeu modeleJeu) {
		return this.modeleJeuRepository.create(modeleJeu);
	}

	public Optional<ModeleJeu> lireModeleJeu(Integer id) {
		return this.modeleJeuRepository.findById(id);
	}

	public List<ModeleJeu> lireModelesJeux() {
		return this.modeleJeuRepository.findAll();
	}

	public ModeleJeu modifierModeleJeu(ModeleJeu modeleJeu, Integer id) {
		return this.modeleJeuRepository.updateById(modeleJeu, id);
	}

	public void supprimerJeu(Integer id) {
		this.modeleJeuRepository.deleteById(id);
	}

}
