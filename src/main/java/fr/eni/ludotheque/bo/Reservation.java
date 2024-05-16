package fr.eni.ludotheque.bo;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class Reservation {
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(nullable = false)
	private Date rue;
	
    @ManyToOne 
    @JoinColumn(name="client_id", nullable=false)
    private Client client;
}
