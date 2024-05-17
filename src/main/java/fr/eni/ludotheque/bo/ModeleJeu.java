package fr.eni.ludotheque.bo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
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
@Table(name="modele_jeu")
public class ModeleJeu {
	@Id
	@GeneratedValue()
	private Integer id;
	 
	@Column(length = 50, nullable = false)
	private String nom;
	
	@Column(nullable = false)
	private Float prix_location;
	
    @ManyToMany()
    @JoinTable(name = "modele_jeu_genre",
        joinColumns = @JoinColumn(name = "model_jeu_id"),
        inverseJoinColumns = @JoinColumn(name = "genre_id"))
	private List<Genre> genres = new ArrayList<>();
    
    @OneToMany(mappedBy="modele_jeu")
    @Builder.Default
    private List<ExemplaireJeu> exemplaires_jeux = new ArrayList<>(); 
}
