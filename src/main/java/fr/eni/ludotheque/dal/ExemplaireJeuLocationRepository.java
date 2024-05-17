package fr.eni.ludotheque.dal;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.eni.ludotheque.bo.Adresse;
import fr.eni.ludotheque.bo.ExemplaireJeuLocation;

public interface ExemplaireJeuLocationRepository extends JpaRepository<ExemplaireJeuLocation, Integer> {

}
