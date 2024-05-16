package fr.eni.ludotheque.bo;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
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
	private Date date_reservation;
	
    @ManyToOne 
    @JoinColumn(name="client_id", nullable=false)
    private Client client;
}
