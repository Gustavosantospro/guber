package gustavosantospro.guber.guber.controller;

import gustavosantospro.guber.guber.domain.TravelRequest;
import gustavosantospro.guber.guber.domain.data.TravelRequestDto;
import gustavosantospro.guber.guber.domain.data.TravelRequestOutput;
import gustavosantospro.guber.guber.service.TravelService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/travelRequest", produces = MediaType.APPLICATION_JSON_VALUE)
@Data
public class TravelRequestController {

    @Autowired
    private TravelService travelService;

    @GetMapping
    public List<TravelRequest> getAllTravelRequest() {
        return travelService.getAllRequest();
    }

    @PostMapping
    public TravelRequestOutput generateRequest(@RequestBody TravelRequestDto data) {
        return travelService.createRequest(data);
    }
}
