package com.challenge.Vehicles.dtos.vehicle;

public class VehicleResponseDTO {
    private Long id;
    private String brand;
    private String model;
    private String licensePlate;
    private Integer year;
    private Integer mileage;
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

    public Integer getMileage() {
        return mileage;
    }

    public Double getEngineDisplacement() {
        return engineDisplacement;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public void setEngineDisplacement(Double engineDisplacement) {
        this.engineDisplacement = engineDisplacement;
    }

}