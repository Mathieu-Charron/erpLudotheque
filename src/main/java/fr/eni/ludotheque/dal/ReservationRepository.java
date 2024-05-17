package fr.eni.ludotheque.dal;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.eni.ludotheque.bo.Adresse;
import fr.eni.ludotheque.bo.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

}
