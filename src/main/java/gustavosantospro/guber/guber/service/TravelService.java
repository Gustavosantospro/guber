package gustavosantospro.guber.guber.service;

import gustavosantospro.guber.guber.domain.TravelRequest;
import gustavosantospro.guber.guber.domain.data.TravelRequestDto;
import gustavosantospro.guber.guber.domain.data.TravelRequestOutput;
import gustavosantospro.guber.guber.domain.data.mapper.TravelRequestMapper;
import gustavosantospro.guber.guber.repository.TravelRequestRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class TravelService {

    @Autowired
    private TravelRequestRepository requestRepository;

    @Autowired
    private TravelRequestMapper mapper;

    public TravelRequestOutput createRequest(TravelRequestDto data) {
        // primeiro transformo o Dto em travelRequest
        TravelRequest travelRequest = mapper.map(data);
        // salvo no repositório o travelRequest
        requestRepository.save(travelRequest);
        // aqui eu transformo o travelRequest em TravelRequestOutput e adiciono o link
        return mapper.mapToTravelRequestOutputWithLink(travelRequest);
    }

    public List<TravelRequest> getAllRequest() {
        return requestRepository.findAll();
    }
}
