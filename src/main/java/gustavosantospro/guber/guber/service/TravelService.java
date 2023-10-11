package gustavosantospro.guber.guber.service;

import gustavosantospro.guber.guber.domain.Passenger;
import gustavosantospro.guber.guber.domain.TravelRequest;
import gustavosantospro.guber.guber.domain.data.TravelRequestDto;
import gustavosantospro.guber.guber.repository.TravelRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TravelService {

    @Autowired
    private TravelRequestRepository requestRepository;

    public void createRequest(TravelRequestDto data) {
        TravelRequest travelRequest = new TravelRequest(data.passenger(), data.origin(), data.destination());
        requestRepository.save(travelRequest);
    }
}
