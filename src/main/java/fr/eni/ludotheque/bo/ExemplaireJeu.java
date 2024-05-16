package fr.eni.ludotheque.bo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
@ToString
@Builder
@Entity
@Table(name="exemplaire_jeu")
public class ExemplaireJeu {
	@Id
	@GeneratedValue()
	private Integer id;
	 
	@Column(length = 50, nullable = false)
	private String code_barre;
	
	@Column(nullable = false)
	private Boolean est_louable;
	
    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "exemplaire_jeu_location",
        joinColumns = @JoinColumn(name = "exemplaire_jeu_id"),
        inverseJoinColumns = @JoinColumn(name = "location_id"))
	private List<Location> locations = new ArrayList<>();
    
    @ManyToOne
    @JoinColumn(name="modele_jeu_id", nullable=false)
    private ModeleJeu modele_jeu;
    
    @ManyToOne 
    @JoinColumn(name="reservation_id", nullable=true)
    private Reservation reservation;
}
