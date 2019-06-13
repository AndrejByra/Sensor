package sk.thermometer.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.thermometer.microservice.model.Thermometer;

import java.util.Date;
import java.util.List;

public interface ThermometerRepository extends JpaRepository<Thermometer, Long> {
    List<Thermometer> findAllByOrderByDateDesc();

    List<Thermometer> findAllByOrderByDateAsc();

    List<Thermometer> findAllByDateBetween(Date first, Date second);

}
