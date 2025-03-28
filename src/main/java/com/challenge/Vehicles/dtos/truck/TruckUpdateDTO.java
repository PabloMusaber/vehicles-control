package com.challenge.Vehicles.dtos.truck;

import com.challenge.Vehicles.dtos.vehicle.VehicleUpdateDTO;
import com.challenge.Vehicles.enums.TruckType;

public class TruckUpdateDTO extends VehicleUpdateDTO {

    private Long id;
    private TruckType type;
    private Integer loadCapacity;
    private Integer axes;

    public Long getId() {
        return id;
    }

    public TruckType getType() {
        return type;
    }

    public Integer getLoadCapacity() {
        return loadCapacity;
    }

    public Integer getAxes() {
        return axes;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
