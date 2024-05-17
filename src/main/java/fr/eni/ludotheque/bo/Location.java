package fr.eni.ludotheque.bo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
@EqualsAndHashCode(of = "id")
@ToString
@Builder
@Entity
@Table(name = "location")
public class Location {
	@Id
	@GeneratedValue()
	private Integer id;

	@Column(nullable = false)
	private Date date_deb;

	@Column(nullable = false)
	private Boolean est_paye;

	@ManyToMany()
	@Builder.Default
	private List<ExemplaireJeu> exemplaires_jeux = new ArrayList<>();
	
    @ManyToOne 
    @JoinColumn(name="client_id", nullable=false)
    private Client client;
}
