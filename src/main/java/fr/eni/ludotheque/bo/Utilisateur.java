package fr.eni.ludotheque.bo;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;


//@EqualsAndHashCode(of="id")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = { "id" }) 
@ToString
@SuperBuilder
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_utilisateur")
public abstract class Utilisateur {
	@Id
	@GeneratedValue()
	protected Integer id;
	
	@Column(length = 50, nullable = false)
	protected String nom;
	
	@Column(length = 50, nullable = false)
	protected String prenom;
//	
//	@Column(length = 255, nullable = false)
//	private String mot_de_passe;
	
}
