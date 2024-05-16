package fr.eni.ludotheque;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import fr.eni.ludotheque.bo.Adresse;
import fr.eni.ludotheque.bo.Client;
import fr.eni.ludotheque.bo.Employe;
import fr.eni.ludotheque.dal.UtilisateurRepository;

@Component
public class Demo implements CommandLineRunner {

	@Autowired
	UtilisateurRepository utilisateurRepo;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("ça passe mon gars");
		Employe emp = Employe.builder()
				.nom("Dupont")
				.prenom("bob")
				.build();
		
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
		
		utilisateurRepo.save(emp);
		utilisateurRepo.save(cli);
		
	}

}
