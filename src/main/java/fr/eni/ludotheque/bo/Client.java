package fr.eni.ludotheque.bo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@EqualsAndHashCode(of="id")
@ToString(callSuper = true) 
@SuperBuilder
@DiscriminatorValue("C")
@Entity
public class Client extends Utilisateur {
	
	@Column(length = 20)
	private String tel;
	
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "adresse_id", referencedColumnName = "id")
	private Adresse adresse;
	
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, targetEntity=Reservation.class, mappedBy="client" )
	private List<Reservation> reservations = new ArrayList<>();
	
	@OneToMany(cascade = {CascadeType.PERSIST}, targetEntity=Reservation.class, mappedBy="client")
	private List<Location> locations = new ArrayList<>();
}
