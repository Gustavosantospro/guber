package gustavosantospro.guber.guber.service;

import gustavosantospro.guber.guber.domain.Passenger;
import gustavosantospro.guber.guber.domain.data.PassengerDto;
import gustavosantospro.guber.guber.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PassengerService {

    @Autowired
    private PassengerRepository repository;
    public List<Passenger> getPassenger() {
        return repository.findAll();
    }
    public Passenger findPassengerById(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Passenger createPassenger(PassengerDto data) {
        Passenger passenger = new Passenger(data.name());
        repository.save(passenger);
        return passenger;
    }

    public ResponseEntity updatePassenger(Long id, PassengerDto data) {
        if (repository.existsById(id)) {
            Passenger passenger = repository.findById(id).get();
            passenger.setName(data.name());
            return ResponseEntity.ok(passenger);
        }
        return ResponseEntity.badRequest().body("not Found!");
    }

    public Passenger incrementalUpdatePassenger(PassengerDto data, Long id) {

        Passenger passenger = repository.findById(id).get();
        passenger.setName(Optional.ofNullable(data.name()).orElse(passenger.getName()));
        repository.save(passenger);
        return passenger;
    }

    public void deletePassenger(Long id) {
        repository.deleteById(id);
    }
}
