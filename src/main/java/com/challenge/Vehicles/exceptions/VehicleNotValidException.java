package com.challenge.Vehicles.exceptions;

public class VehicleNotValidException extends RuntimeException {
    public VehicleNotValidException() {
        super("Vehicle not valid");
    }
}
