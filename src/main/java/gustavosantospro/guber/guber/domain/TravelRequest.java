package gustavosantospro.guber.guber.domain;

import gustavosantospro.guber.guber.domain.data.TravelRequestStatus;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class TravelRequest {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String origin;
    private String destination;

    @ManyToOne
    private Passenger passenger;
    @Enumerated(EnumType.STRING)
    private TravelRequestStatus status;
    private Date creationalDate;
}
