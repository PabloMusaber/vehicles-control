package com.challenge.Vehicles.dtos.vehicle;

import com.challenge.Vehicles.enums.TruckType;

public class TruckCreateDTO extends VehicleBaseDTO {

    private TruckType type;
    private Integer loadCapacity;
    private Integer axes;

    public TruckType getType() {
        return type;
    }

    public Integer getLoadCapacity() {
        return loadCapacity;
    }

    public Integer getAxes() {
        return axes;
    }

}
