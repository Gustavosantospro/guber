package gustavosantospro.guber.guber.service;

import gustavosantospro.guber.guber.domain.Driver;
import gustavosantospro.guber.guber.domain.data.DriverDto;
import gustavosantospro.guber.guber.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class DriverService {

    @Autowired
    private DriverRepository driverRepository;

    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    public Driver findDriver(Long id) {
        return driverRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Driver create(DriverDto data) {
        Driver driver = new Driver(data.name(), data.birthDate());
        return driverRepository.save(driver);
    }

    public Driver updateDriver(Long id, DriverDto data) {
        Driver driver = driverRepository.findById(id).get();
        driver.setName(data.name());
        driver.setBirthDate(data.birthDate());
        driverRepository.save(driver);
        return driver;
    }

    public Driver incrementalUpdate(Long id, Driver data) {
        Driver driver = driverRepository.findById(id).get();
        driver.setName(Optional.ofNullable(data.getName()).orElse(driver.getName()));
        driver.setBirthDate(Optional.ofNullable(data.getBirthDate()).orElse(driver.getBirthDate()));
        driverRepository.save(driver);
        return driver;
    }

    public String deleteDriverById(Long id) {
        if (driverRepository.existsById(id)) {
            driverRepository.deleteById(id);
            return "Driver deleted successfully";
        }
        return "Ops, we dont understend you";
    }
}
