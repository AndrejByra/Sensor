package sk.sensor.sensor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.sensor.sensor.model.Sensor;
import sk.sensor.sensor.repository.SensorRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sensor")
public class SensorService {

    @Autowired
    public SensorRepository sensorRepository;
    
    @GetMapping
    public List<Sensor> findAll(){
        return sensorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Sensor> findById(@PathVariable("id") Long id){
    return sensorRepository.findById(id);
    }

    @PostMapping("/add")
    public Sensor addNewSensor(@RequestBody Sensor sensor){
        sensor.setName(sensor.getName());
        sensor.setRoom(sensor.getRoom());
        sensor.setDate(sensor.getDate());
        sensor.setTemperature(sensor.getTemperature());
        return sensorRepository.save(sensor);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        sensorRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Sensor updateSensor(@PathVariable Long id,@RequestBody Sensor sensor){
        Sensor sensorUpdated = sensorRepository.getOne(id);
        sensorUpdated.setName(sensor.getName());
        sensorUpdated.setRoom(sensor.getRoom());
        sensorUpdated.setDate(sensor.getDate());
        sensorUpdated.setTemperature(sensor.getTemperature());
        return sensorRepository.save(sensorUpdated);
    }

}
