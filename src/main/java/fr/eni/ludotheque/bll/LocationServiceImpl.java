package fr.eni.ludotheque.bll;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.eni.ludotheque.bo.Client;
import fr.eni.ludotheque.bo.ExemplaireJeu;
import fr.eni.ludotheque.bo.Location;
import fr.eni.ludotheque.bo.Reservation;
import fr.eni.ludotheque.dal.ExemplaireJeuRepository;
import fr.eni.ludotheque.dal.ReservationRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

public class LocationServiceImpl implements LocationService {
	@Autowired
	ReservationRepository reservationRepository;
	@Autowired
	ExemplaireJeuRepository exemplaireJeuRepository;
	@Override
	@Transactional
	public Reservation reserverExemplaires(List<ExemplaireJeu> exemplaires, Client client) {
		//verif que l'exemplaire n'est pas dans la table reservation
		
		
		//verif que dans location_exemplaire il n'est pas actuellement loué
		
		//créer reservation
		Reservation reservation = Reservation.builder()
				.client(client)
				.date_reservation(new Date())
				.build();
		reservationRepository.save(reservation);

		//ajout de la reservation dans les exemplaires
		for (ExemplaireJeu exemplaireJeu : exemplaires) {
			exemplaireJeu.setReservation(reservation);
			exemplaireJeuRepository.save(exemplaireJeu);
		}
		
		return reservation;
	}

	@Override
	public Location louerExemplaires(List<ExemplaireJeu> exemplaires, Client client) {
		//verif que les exemplaires ne sont pas reservés par d'autres clients
		
		//verif que dans location_exemplaire il n'est pas actuellement loué
		
		//créer location && ajout des exemplaires dans la location
		Location location = Location.builder()
				.client(client)
				.exemplaires_jeux(exemplaires)
				.date_deb(new Date())
				.est_paye(false)
				.build();
						
		
		return location;

	}

	@Override
	public void rendreExemplaire(ExemplaireJeu exemplaire) {
		//verif que l'exemplaire est actuellement loué
		
		//mettre une date_fin et prix sur location_exemplaire
		
		//si tout les jeux de la location son rendu appeler cloturerLocation
		
	}

	@Override
	public void cloturerLocation(Location location) {
		//verif que la location n'est pas deja cloturée
		
		//mettre date_fin et prix dans location_exemplaire des jeux de la location
		
		//mettre est_paye à true
		
	}

}
