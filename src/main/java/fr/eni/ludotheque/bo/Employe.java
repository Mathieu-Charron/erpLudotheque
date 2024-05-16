package fr.eni.ludotheque.bo;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;


@NoArgsConstructor
@ToString(callSuper = true) 
@SuperBuilder
@Entity
@DiscriminatorValue("E")
public class Employe extends Utilisateur {
	
	
}
