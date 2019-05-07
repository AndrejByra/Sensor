package sk.sensor.sensor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.sensor.sensor.model.Sensor;

import java.util.Date;
import java.util.List;

public interface SensorRepository extends JpaRepository<Sensor, Long> {
    List<Sensor> findAllByOrderByDateDesc();

    List<Sensor> findAllByOrderByDateAsc();

    List<Sensor> findAllByDateBetween(Date first, Date second);


}
