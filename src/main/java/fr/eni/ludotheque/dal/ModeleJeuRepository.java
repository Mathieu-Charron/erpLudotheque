package fr.eni.ludotheque.dal;

import org.springframework.data.jpa.repository.JpaRepository;
import fr.eni.ludotheque.bo.ModeleJeu;

public interface ModeleJeuRepository extends JpaRepository<ModeleJeu, Integer> {
//	ModeleJeu updateById(ModeleJeu modeleJeu, Integer id);
//	ModeleJeu create(ModeleJeu modeleJeu);
}
