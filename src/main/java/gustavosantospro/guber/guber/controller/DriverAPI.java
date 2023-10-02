package gustavosantospro.guber.guber.controller;

import gustavosantospro.guber.guber.domain.Driver;
import gustavosantospro.guber.guber.domain.data.DriverDto;
import gustavosantospro.guber.guber.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
@Service
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class DriverAPI {

    @Autowired
    private DriverService driverService;

    @GetMapping("/drivers")
    public List<Driver> listDriver() {
        return driverService.getAllDrivers();
    }

    @GetMapping("/drivers/{id}")
    public Driver getDriver(@PathVariable("id") Long id){
        return driverService.findDriver(id);
    }

    @PostMapping("/drivers")
    public Driver createDriver(@RequestBody DriverDto data) {
        return driverService.create(data);
    }

    @PutMapping("/drivers/{id}")
    public Driver fullUpdateDriver(@PathVariable("id") Long id,
                                   @RequestBody DriverDto data) {
        return driverService.updateDriver(id, data);
    }

    @PatchMapping("/drivers/{id}")
    public Driver incrementalUpdate(@PathVariable("id") Long id, @RequestBody Driver data) {

        return driverService.incrementalUpdate(id, data);
    }

    @DeleteMapping("/drivers/{id}")
    public String deleteDriver(@PathVariable("id") Long id) {
        return driverService.deleteDriverById(id);
    }
}
