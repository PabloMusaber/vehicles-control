package com.challenge.Vehicles.dtos.car;

import com.challenge.Vehicles.dtos.vehicle.VehicleUpdateDTO;
import com.challenge.Vehicles.enums.CarType;

public class CarUpdateDTO extends VehicleUpdateDTO {

    private Long id;
    private CarType type;
    private Integer doors;
    private Integer passangers;
    private Integer trunkCapacity;

    public CarType getType() {
        return type;
    }

    public Integer getDoors() {
        return doors;
    }

    public Integer getPassangers() {
        return passangers;
    }

    public Integer getTrunkCapacity() {
        return trunkCapacity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
