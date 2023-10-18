package gustavosantospro.guber.guber.domain.data.mapper;

import gustavosantospro.guber.guber.domain.Passenger;
import gustavosantospro.guber.guber.domain.TravelRequest;
import gustavosantospro.guber.guber.domain.data.TravelRequestDto;
import gustavosantospro.guber.guber.domain.data.TravelRequestStatus;
import gustavosantospro.guber.guber.repository.PassengerRepository;
import gustavosantospro.guber.guber.repository.TravelRequestRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;

@Data
@Component
public class TravelRequestMapper {

    @Autowired
    private TravelRequestRepository requestRepository;
    @Autowired
    private PassengerRepository passengerRepository;

    public TravelRequest map(TravelRequestDto data) {
        Passenger passenger = passengerRepository.findById(data.passengerId()).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND));
        // a data e o status são criados no momento em que uma travelRequest é solicitada.
        TravelRequest travelRequest = new TravelRequest();
        travelRequest.setStatus(TravelRequestStatus.CREATED);
        travelRequest.setCreationalDate(new Date());
        travelRequest.setOrigin(data.origin());
        travelRequest.setDestination(data.destination());
        travelRequest.setPassenger(passenger);
        return travelRequest;
    }
}
