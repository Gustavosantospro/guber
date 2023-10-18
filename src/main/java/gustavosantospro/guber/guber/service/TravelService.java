package gustavosantospro.guber.guber.service;

import gustavosantospro.guber.guber.domain.Passenger;
import gustavosantospro.guber.guber.domain.TravelRequest;
import gustavosantospro.guber.guber.domain.data.TravelRequestDto;
import gustavosantospro.guber.guber.domain.data.mapper.TravelRequestMapper;
import gustavosantospro.guber.guber.repository.TravelRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TravelService {

    @Autowired
    private TravelRequestRepository requestRepository;

    @Autowired
    private TravelRequestMapper mapper;

    public void createRequest(TravelRequestDto data) {

        TravelRequest travelRequest = mapper.map(data);
        requestRepository.save(travelRequest);
    }
}
