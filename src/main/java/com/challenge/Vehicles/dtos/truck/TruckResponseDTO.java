package com.challenge.Vehicles.dtos.truck;

import com.challenge.Vehicles.dtos.vehicle.VehicleResponseDTO;
import com.challenge.Vehicles.enums.TruckType;

public class TruckResponseDTO extends VehicleResponseDTO {

    private TruckType type;
    private Integer loadCapacity;
    private Integer axes;

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

    public Integer getAxes() {
        return axes;
    }

    public void setAxes(Integer axes) {
        this.axes = axes;
    }

}
