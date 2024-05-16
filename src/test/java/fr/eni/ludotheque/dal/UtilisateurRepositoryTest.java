package fr.eni.ludotheque.dal;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import fr.eni.ludotheque.bo.Adresse;
import fr.eni.ludotheque.bo.Client;
import fr.eni.ludotheque.bo.Employe;
import fr.eni.ludotheque.bo.Utilisateur;

@DataJpaTest
class UtilisateurRepositoryTest {

	@Autowired
	private UtilisateurRepository repo;
	
	@Autowired
	private TestEntityManager manager;
	
	@Test
	@DisplayName("Test ajout d'un client")
	void testClientSave() {
		//Arrange
		Adresse address = Adresse.builder()
				.codePostal("85280")
				.ville("LA FERRIERE")
				.rue("rue du SUUUUU")
				.build();
		
		Client cli = Client.builder()
				.nom("Hmmm")
				.prenom("SUUUU")
				.tel("06 29 78 24 24")
				.adresse(address)
				.build();
		//Act
		cli = repo.save(cli);
		//Assert
		assertThat(cli.getId()).isNotNull();
	}
	
	@Test
	@DisplayName("Test ajout d'un client")
	void testEmployeSave() {
		//Arrange
		Employe emp = Employe.builder()
				.nom("Ronaldo")
				.prenom("Cristiano")
				.build();
		//Act
		emp = repo.save(emp);
		//Assert
		assertThat(emp.getId()).isNotNull();
	}


	@Test
	void testEmployeFindById() {
		//Arrange
		Employe emp = Employe.builder()
				.nom("Ronaldo")
				.prenom("Cristiano")
				.build();
		emp = manager.persist(emp);
		manager.flush();
		
		//Act
		Optional<Utilisateur> empFind = repo.findById(emp.getId());
		
		//Assert
		assertTrue(empFind.isPresent());
		assertEquals(empFind.get(), emp);
	}

}