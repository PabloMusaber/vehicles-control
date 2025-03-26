package com.challenge.Vehicles.dtos.vehicle;

public abstract class VehicleBaseDTO {
    private String brand;
    private String model;
    private String licensePlate;
    private Integer year;
    private Integer mileage;
    private Double engineDisplacement;

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public Integer getYear() {
        return year;
    }

    public Integer getMileage() {
        return mileage;
    }

    public Double getEngineDisplacement() {
        return engineDisplacement;
    }

}