package fr.eni.ludotheque.dal;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.eni.ludotheque.bo.ModeleJeu;

public interface ExemplaireJeuRepository extends JpaRepository<ModeleJeu, Integer> {

}
