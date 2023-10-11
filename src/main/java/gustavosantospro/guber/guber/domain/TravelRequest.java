package gustavosantospro.guber.guber.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class TravelRequest {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String origin;
    private String destination;

    @ManyToOne
    private Passenger passenger;

    public TravelRequest(Passenger passenger, String origin, String destination) {
        this.passenger = passenger;
        this.origin = origin;
        this.destination = destination;
    }
}
