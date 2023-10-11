package gustavosantospro.guber.guber.controller;

import gustavosantospro.guber.guber.domain.Passenger;
import gustavosantospro.guber.guber.domain.data.PassengerDto;
import gustavosantospro.guber.guber.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/passengers", produces = MediaType.APPLICATION_JSON_VALUE)
public class PassengerController {

    @Autowired
    private PassengerService service;

    @GetMapping("/")
    public List<Passenger> getPassengers() {
        return service.getPassenger();
    }

    @GetMapping("/{id}")
    public Passenger findPassenger(@PathVariable("id") Long id){
        return service.findPassengerById(id);
    }

    @PostMapping()
    public Passenger createPassenger(@RequestBody PassengerDto data) {

        return service.createPassenger(data);
    }

    @PutMapping("/{id}")
    public ResponseEntity updatePassenger(@RequestBody PassengerDto data, @PathVariable("id") Long id) {
        return service.updatePassenger(id, data);
    }

    @PatchMapping("/{id}")
    public Passenger incrementalUpdatePassenger(@RequestBody PassengerDto data,
                                                @PathVariable("id") Long id) {
        return service.incrementalUpdatePassenger(data, id);
    }

    @DeleteMapping("/{id}")
    public void deletePassenger(@PathVariable("id") Long id) {
        service.deletePassenger(id);
    }
}
