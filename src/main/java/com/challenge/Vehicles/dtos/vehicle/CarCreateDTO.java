package com.challenge.Vehicles.dtos.vehicle;

import com.challenge.Vehicles.enums.CarType;

public class CarCreateDTO extends VehicleBaseDTO {

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

}