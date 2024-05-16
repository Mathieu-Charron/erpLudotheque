package fr.eni.ludotheque.dal;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.eni.ludotheque.bo.ExemplaireJeu;

public interface ExemplaireJeuRepository extends JpaRepository<ExemplaireJeu, Integer> {

}
