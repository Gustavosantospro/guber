package gustavosantospro.guber.guber.domain.data;

import gustavosantospro.guber.guber.domain.Passenger;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.RepresentationModel;

import java.util.Date;

@Data
public class TravelRequestOutput extends RepresentationModel<EntityModel<TravelRequestOutput>> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String origin;
    private String destination;

    @Enumerated(EnumType.STRING)
    private TravelRequestStatus status;
    private Date creationalDate;
}
