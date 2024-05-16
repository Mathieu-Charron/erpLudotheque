package fr.eni.ludotheque.bo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
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
	
	@OneToMany(cascade = {CascadeType.REMOVE}, targetEntity=Reservation.class, mappedBy="client" )
	@Builder.Default
	private List<Reservation> reservations = new ArrayList<>();
	
	@OneToMany(targetEntity=Reservation.class, mappedBy="client")
	@Builder.Default
	private List<Location> locations = new ArrayList<>();
}
