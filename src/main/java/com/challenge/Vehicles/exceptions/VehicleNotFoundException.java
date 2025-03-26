package com.challenge.Vehicles.exceptions;

public class VehicleNotFoundException extends RuntimeException {
    public VehicleNotFoundException() {
        super("Vehicle not found");
    }
}
