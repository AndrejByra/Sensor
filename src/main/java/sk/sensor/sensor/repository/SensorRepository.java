package sk.sensor.sensor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.sensor.sensor.model.Sensor;

public interface SensorRepository extends JpaRepository<Sensor,Long> {

}
