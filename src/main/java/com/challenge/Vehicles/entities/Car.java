package com.challenge.Vehicles.entities;

import com.challenge.Vehicles.enums.CarType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "cars")
@PrimaryKeyJoinColumn(name = "vehicle_id")
public class Car extends Vehicle {

    @Column(name = "type", nullable = false)
    private CarType type;

    @Column(name = "doors", nullable = false)
    private Integer doors;

    @Column(name = "passangers", nullable = false)
    private Integer passangers;

    @Column(name = "trunk_capacity", nullable = false)
    private Integer trunkCapacity;

    public Car(CarType type, Integer doors, Integer passangers, Integer trunkCapacity) {
        this.type = type;
        this.doors = doors;
        this.passangers = passangers;
        this.trunkCapacity = trunkCapacity;
    }

    public Car(String brand, String model, String licensePlate, Integer year, Integer mileage,
            Double engineDisplacement, CarType type, Integer doors, Integer passangers,
            Integer trunkCapacity) {
        super(brand, model, licensePlate, year, mileage, engineDisplacement);
        this.type = type;
        this.doors = doors;
        this.passangers = passangers;
        this.trunkCapacity = trunkCapacity;
    }

    public CarType getType() {
        return type;
    }

    public void setType(CarType type) {
        this.type = type;
    }

    public Integer getDoors() {
        return doors;
    }

    public void setDoors(Integer doors) {
        this.doors = doors;
    }

    public Integer getPassangers() {
        return passangers;
    }

    public void setPassangers(Integer passangers) {
        this.passangers = passangers;
    }

    public Integer getTrunkCapacity() {
        return trunkCapacity;
    }

    public void setTrunkCapacity(Integer trunkCapacity) {
        this.trunkCapacity = trunkCapacity;
    }

}
