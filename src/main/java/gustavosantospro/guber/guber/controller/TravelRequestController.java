package gustavosantospro.guber.guber.controller;

import gustavosantospro.guber.guber.domain.data.TravelRequestDto;
import gustavosantospro.guber.guber.service.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

@RestController
@RequestMapping(path = "/travelRequest", produces = MediaType.APPLICATION_JSON_VALUE)
public class TravelRequestController {

    @Autowired
    private TravelService travelService;

    @PostMapping
    public void generateRequest(@RequestBody TravelRequestDto data) {
        travelService.createRequest(data);
    }
}
