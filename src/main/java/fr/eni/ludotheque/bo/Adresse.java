package fr.eni.ludotheque.bo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@EqualsAndHashCode(of="id")
@ToString
@Builder
@Entity
public class Adresse {
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(length = 50, nullable = false)
	private String rue;
	
	@Column(name="code_postal", length = 10, nullable = false)
	private String codePostal;
	
	@Column(length = 100, nullable = false)
	private String ville;
	
	
}
