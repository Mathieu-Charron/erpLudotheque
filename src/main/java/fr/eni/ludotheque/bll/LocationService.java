package fr.eni.ludotheque.bll;

import java.util.List;

import fr.eni.ludotheque.bo.Client;
import fr.eni.ludotheque.bo.ExemplaireJeu;
import fr.eni.ludotheque.bo.Location;
import fr.eni.ludotheque.bo.Reservation;

public interface LocationService {
	
	Reservation reserverExemplaires(List<ExemplaireJeu> exemplaires, Client client);
	
	Location louerExemplaires(List<ExemplaireJeu> exemplaires, Client client);
	
	void rendreExemplaire(ExemplaireJeu exemplaire);
	
	void cloturerLocation(Location location);
}
