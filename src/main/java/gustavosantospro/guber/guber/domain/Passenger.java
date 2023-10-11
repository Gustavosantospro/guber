package gustavosantospro.guber.guber.domain;

import gustavosantospro.guber.guber.domain.data.PassengerDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data
public class Passenger {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Passenger(String name) {
        this.name = name;
    }

}
