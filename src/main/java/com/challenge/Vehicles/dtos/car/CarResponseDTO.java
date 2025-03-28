package com.challenge.Vehicles.dtos.car;

import com.challenge.Vehicles.dtos.vehicle.VehicleResponseDTO;
import com.challenge.Vehicles.enums.CarType;

public class CarResponseDTO extends VehicleResponseDTO {
    private CarType type;
    private Integer doors;
    private Integer passangers;
    private Integer trunkCapacity;

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
