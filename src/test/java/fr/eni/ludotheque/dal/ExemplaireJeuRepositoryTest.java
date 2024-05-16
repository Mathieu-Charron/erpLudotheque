package fr.eni.ludotheque.dal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import fr.eni.ludotheque.bo.ExemplaireJeu;
import fr.eni.ludotheque.bo.Genre;
import fr.eni.ludotheque.bo.ModeleJeu;

@DataJpaTest
//@SpringBootTest
class ExemplaireJeuRepositoryTest {
	
	@Autowired
	private ExemplaireJeuRepository ex_jeu_repo;
	
	@Autowired
	private TestEntityManager entityManager;

	@Test
	@DisplayName("Test ajout d'un Exemplaire de jeu")
	void testSave() {
		//Arrange = Préparation du test		
		Genre genre = Genre.builder()
				.libelle("reflexion")
				.build();
		genre = entityManager.persist(genre);
		entityManager.flush();
		
		List<Genre> liste_genre = new ArrayList<>();
		liste_genre.add(genre);
		
		ModeleJeu model_jeu = ModeleJeu.builder()
				.nom("jeuuu")
				.genre(liste_genre)
				.prix_location(10.5f)
				.build();
		entityManager.persist(model_jeu);
		entityManager.flush();

		ExemplaireJeu exemplaire_jeu = ExemplaireJeu.builder()
						.code_barre("564313454654")
						.modele_jeu(model_jeu)
						.est_louable(true)
						.build();
		
		//Act
		ExemplaireJeu exemplaire_jeu_cree = ex_jeu_repo.save(exemplaire_jeu);
		
		//Assert
		//assertNotNull(empCree.getId());
		assertThat(exemplaire_jeu_cree.getId()).isNotNull();
		
	}
	
	@Test
	@DisplayName("Test rechercher un exemplaire")
	void testFindById() {
		//Arrange = Préparation du test
		Genre genre = Genre.builder()
				.libelle("reflexion")
				.build();
		genre = entityManager.persist(genre);
		entityManager.flush();
		
		List<Genre> liste_genre = new ArrayList<>();
		liste_genre.add(genre);
		
		ModeleJeu model_jeu = ModeleJeu.builder()
				.nom("jeuuu")
				.genre(liste_genre)
				.prix_location(10.5f)
				.build();
		entityManager.persist(model_jeu);
		entityManager.flush();
		
		ExemplaireJeu exemplaire_jeu = ExemplaireJeu.builder()
				.code_barre("564313454654")
				.modele_jeu(model_jeu)
				.est_louable(true)
				.build();
		
		exemplaire_jeu = entityManager.persist(exemplaire_jeu);
		
		entityManager.flush();
		
		//Act
		Optional<ExemplaireJeu> exemplaire_jeuDBOpt = ex_jeu_repo.findById(exemplaire_jeu.getId());
		
			
		//Assert
		assertTrue(exemplaire_jeuDBOpt.isPresent());
		assertEquals(exemplaire_jeu, exemplaire_jeuDBOpt.get());
		
	}

}
