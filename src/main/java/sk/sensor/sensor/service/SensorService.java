package sk.sensor.sensor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import sk.sensor.sensor.model.Sensor;
import sk.sensor.sensor.repository.SensorRepository;

import java.time.OffsetDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sensor")
public class SensorService {

    @Autowired
    public SensorRepository sensorRepository;

    @GetMapping("/findAll")
    public List<Sensor> findAll() {
        return sensorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Sensor> findById(@PathVariable("id") Long id) {
        return sensorRepository.findById(id);
    }

    @GetMapping("/findByDateDesc")
    public List<Sensor> findByDateDesc() {
        return sensorRepository.findAllByOrderByDateDesc();
    }

    @GetMapping("/findByDateAsc")
    public List<Sensor> findByDateAsc() {
        return sensorRepository.findAllByOrderByDateAsc();
    }

    @GetMapping("{first}/{second}")
    public List<Sensor> dateFilter(@PathVariable(value = "first") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date first,
                                   @PathVariable(value = "second") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date second) {
        return sensorRepository.findAllByDateBetween(first, second);
    }

    @PostMapping("/add")
    public Sensor addNewSensor(@RequestBody Sensor sensor) {
        sensor.setName(sensor.getName());
        sensor.setRoom(sensor.getRoom());
        sensor.setDate(sensor.getDate());
        sensor.setTemperature(sensor.getTemperature());
        return sensorRepository.save(sensor);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        sensorRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Sensor updateSensor(@PathVariable Long id, @RequestBody Sensor sensor) {
        Sensor sensorUpdated = sensorRepository.getOne(id);
        sensorUpdated.setName(sensor.getName());
        sensorUpdated.setRoom(sensor.getRoom());
        sensorUpdated.setDate(sensor.getDate());
        sensorUpdated.setTemperature(sensor.getTemperature());
        return sensorRepository.save(sensorUpdated);
    }

}
