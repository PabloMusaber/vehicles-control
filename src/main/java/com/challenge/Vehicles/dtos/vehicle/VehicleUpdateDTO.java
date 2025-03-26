package com.challenge.Vehicles.dtos.vehicle;

public class VehicleUpdateDTO {

    private Long id;
    private String brand;
    private String model;
    private String licensePlate;
    private Integer year;
    private Double mileage;
    private Double engineDisplacement;

    public Long getId() {
        return id;
    }

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

    public Double getMileage() {
        return mileage;
    }

    public Double getEngineDisplacement() {
        return engineDisplacement;
    }

    public void setId(Long id) {
        this.id = id;
    }

}