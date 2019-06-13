package sk.thermometer.microservice.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Thermometer implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private Long thermometerId;
    private Date date;
    private Double temperature;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getThermometerId() {
        return thermometerId;
    }

    public void setThermometerId(Long thermometerId) {
        this.thermometerId = thermometerId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }


}
