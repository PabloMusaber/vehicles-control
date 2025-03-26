package com.challenge.Vehicles.dtos.maintenance;

import java.time.LocalDate;

public class MaintenanceCreateDTO {
    private Long vehicleId;
    private String description;
    private LocalDate date;
    private Double cost;
    private Integer mileage;

    public Long getVehicleId() {
        return vehicleId;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDate() {
        return date;
    }

    public Double getCost() {
        return cost;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

}
