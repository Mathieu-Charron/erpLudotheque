package fr.eni.ludotheque.bo;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
@Table(name="exemplaire_jeu_location")
public class ExemplaireJeuLocation {

	@Id
	@GeneratedValue()	
	private Integer id;
	
	@Column(nullable = false)
	private Date date_fin;
	
	@Column(nullable = false)
	private Float prix_final;
	
    @ManyToOne
    @JoinColumn(name = "exemplaire_jeu_id")
    private ExemplaireJeu exemplaire_jeu;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;
}
