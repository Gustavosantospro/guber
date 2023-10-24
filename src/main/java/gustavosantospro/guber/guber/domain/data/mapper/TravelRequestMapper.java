package gustavosantospro.guber.guber.domain.data.mapper;

import gustavosantospro.guber.guber.controller.PassengerController;
import gustavosantospro.guber.guber.domain.Passenger;
import gustavosantospro.guber.guber.domain.TravelRequest;
import gustavosantospro.guber.guber.domain.data.TravelRequestDto;
import gustavosantospro.guber.guber.domain.data.TravelRequestOutput;
import gustavosantospro.guber.guber.domain.data.TravelRequestStatus;
import gustavosantospro.guber.guber.repository.PassengerRepository;
import gustavosantospro.guber.guber.repository.TravelRequestRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class TravelRequestMapper  {

    @Autowired
    private TravelRequestRepository requestRepository;
    @Autowired
    private PassengerRepository passengerRepository;

    // aqui é um cliente, no caso um passenger, que vai estar fazendo a requisição
    // o objetivo é transformar um TravelRequestDto em TravelRequest
    public TravelRequest map(TravelRequestDto data) {
        // 1° verificar se tal pasenger realmente existe; caso não retornar um NotFound Exception
        Passenger passenger = passengerRepository.findById(data.passengerId()).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND));

        TravelRequest travelRequest = new TravelRequest();
        // a data e o status são criados no momento em que uma travelRequest é solicitada.
        travelRequest.setStatus(TravelRequestStatus.CREATED);
        travelRequest.setCreationalDate(new Date());
        //--//
        travelRequest.setOrigin(data.origin());
        travelRequest.setDestination(data.destination());
        travelRequest.setPassenger(passenger);
        return travelRequest;
    }

    public TravelRequestOutput mapToTravelRequestOutputWithLink(TravelRequest travelRequest) {
        TravelRequestOutput travelRequestOutput = new TravelRequestOutput();
        travelRequestOutput.setDestination(travelRequest.getDestination());
        travelRequestOutput.setStatus(travelRequest.getStatus());
        travelRequestOutput.setOrigin(travelRequest.getOrigin());
        travelRequestOutput.setCreationalDate(travelRequest.getCreationalDate());
        travelRequestOutput.setId(travelRequest.getId());

        return buildOutputModel(travelRequestOutput, travelRequest);
    }


    private TravelRequestOutput buildOutputModel(TravelRequestOutput travelRequestOutput,
                                                             TravelRequest travelRequest) {

        Link passagerLink = WebMvcLinkBuilder.linkTo(PassengerController.class)
                .withRel("passenger")
                .withTitle(travelRequest.getPassenger().getName());
        travelRequestOutput.add(passagerLink);
        return travelRequestOutput;
    }
}
