package com.challenge.Vehicles.entities;

import com.challenge.Vehicles.enums.TruckType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "trucks")
@PrimaryKeyJoinColumn(name = "vehicle_id")
public class Truck extends Vehicle {

    @Column(name = "type", nullable = false)
    private TruckType type;

    @Column(name = "load_capacity", nullable = false)
    private Integer loadCapacity;

    @Column(name = "passangers", nullable = false)
    private Integer passangers;

    @Column(name = "axes", nullable = false)
    private Integer axes;

    public Truck(TruckType type, Integer loadCapacity, Integer passangers, Integer axes) {
        this.type = type;
        this.loadCapacity = loadCapacity;
        this.passangers = passangers;
        this.axes = axes;
    }

    public Truck(String brand, String model, String licensePlate, Integer year, Integer mileage,
            Double engineDisplacement, TruckType type, Integer loadCapacity, Integer passangers, Integer axes) {
        super(brand, model, licensePlate, year, mileage, engineDisplacement);
        this.type = type;
        this.loadCapacity = loadCapacity;
        this.passangers = passangers;
        this.axes = axes;
    }

    public TruckType getType() {
        return type;
    }

    public void setType(TruckType type) {
        this.type = type;
    }

    public Integer getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(Integer loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    public Integer getPassangers() {
        return passangers;
    }

    public void setPassangers(Integer passangers) {
        this.passangers = passangers;
    }

    public Integer getAxes() {
        return axes;
    }

    public void setAxes(Integer axes) {
        this.axes = axes;
    }

}
