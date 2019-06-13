package sk.thermometer.microservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import sk.thermometer.microservice.model.Thermometer;
import sk.thermometer.microservice.repository.ThermometerRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sensor")
public class ThermometerService {

    @Autowired
    public ThermometerRepository sensorRepository;

    @GetMapping("/findAll")
    public List<Thermometer> findAll() {
        return sensorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Thermometer> findById(@PathVariable("id") Long id) {
        return sensorRepository.findById(id);
    }

    @GetMapping("/findByDateDesc")
    public List<Thermometer> findByDateDesc() {
        return sensorRepository.findAllByOrderByDateDesc();
    }

    @GetMapping("/findByDateAsc")
    public List<Thermometer> findByDateAsc() {
        return sensorRepository.findAllByOrderByDateAsc();
    }

    @GetMapping("{first}/{second}")
    public List<Thermometer> dateFilter(@PathVariable(value = "first") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date first,
                                        @PathVariable(value = "second") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date second) {
        return sensorRepository.findAllByDateBetween(first, second);
    }

    @PostMapping("/add")
    public Thermometer addNewSensor(@RequestBody Thermometer sensor) {

        sensor.setDate(sensor.getDate());
        sensor.setTemperature(sensor.getTemperature());
        return sensorRepository.save(sensor);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        sensorRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Thermometer updateSensor(@PathVariable Long id, @RequestBody Thermometer sensor) {
        Thermometer sensorUpdated = sensorRepository.getOne(id);

        sensorUpdated.setDate(sensor.getDate());
        sensorUpdated.setTemperature(sensor.getTemperature());
        return sensorRepository.save(sensorUpdated);
    }
}