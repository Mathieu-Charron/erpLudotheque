package fr.eni.ludotheque.bll;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import fr.eni.ludotheque.bo.Adresse;
import fr.eni.ludotheque.bo.Client;
import fr.eni.ludotheque.bo.ExemplaireJeu;
import fr.eni.ludotheque.bo.Genre;
import fr.eni.ludotheque.bo.ModeleJeu;
import fr.eni.ludotheque.bo.Reservation;
import fr.eni.ludotheque.dal.ExemplaireJeuRepository;
import fr.eni.ludotheque.dal.ModeleJeuRepository;

@SpringBootTest
class LocationServiceTest {
	@MockBean
	ExemplaireJeuRepository exemplaireJeuRepository;
	
	@MockBean
	ModeleJeuRepository modeleJeuRepository;
	
	@Autowired
	LocationService locationService;
	
	@Test
	void testReserverExemplairesCasNominal() {
		ModeleJeu modeleJeuUno = ModeleJeu.builder()
				.nom("JEU DE FOU")
				.prix_location(100f)
				.genres(new ArrayList<Genre>(
						Arrays.asList(
								Genre.builder().libelle("Action").build(),
								Genre.builder().libelle("Verité").build()
							)
						))
				.build();
		
		ModeleJeu modeleJeuDos = ModeleJeu.builder()
				.nom("JEU DE DINGO")
				.prix_location(100f)
				.genres(new ArrayList<Genre>(
						Arrays.asList(
								Genre.builder().libelle("Action").build(),
								Genre.builder().libelle("Non binaire").build()
							)
						))
				.build();
		
		when(modeleJeuRepository.findById(1)).thenReturn(Optional.of(modeleJeuUno));
		when(modeleJeuRepository.findById(5)).thenReturn(Optional.of(modeleJeuDos));
		
		//Arrange
		Client client = Client.builder()
				.nom("RONALDO")
				.prenom("Cristiano")
				.tel("06 06 05 05 05")
				.adresse(Adresse.builder().codePostal("85280").rue("Rue du SUUUUUUU").ville("CR7 City").build())
				.build();
				
		ExemplaireJeu exemplaireJeuUno = ExemplaireJeu.builder()
				.code_barre("SUUUUUUU")
				.est_louable(true)
				.modele_jeu(modeleJeuRepository.findById(1).get())
				.build();
		
		ExemplaireJeu exemplaireJeuDos = ExemplaireJeu.builder()
				.code_barre("AIHiuahiya")
				.est_louable(true)
				.modele_jeu(modeleJeuRepository.findById(5).get())
				.build();
				
		List<ExemplaireJeu> exemplaires = new ArrayList<ExemplaireJeu>();
		exemplaires.add(exemplaireJeuUno);
		exemplaires.add(exemplaireJeuDos);
		
		//Act
		Reservation reservation = locationService.reserverExemplaires(exemplaires, client);
		
		//Assert
		assertThat(reservation.getExemplaires()).isEqualTo(exemplaires);
		assertThat(reservation.getClient()).isEqualTo(client);
		assertThat(reservation.getDate_reservation()).isEqualTo(new Date());
		assertNotNull(reservation.getId());

	}

}
