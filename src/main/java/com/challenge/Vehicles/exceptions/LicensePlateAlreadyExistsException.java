package com.challenge.Vehicles.exceptions;

public class LicensePlateAlreadyExistsException extends RuntimeException {
    public LicensePlateAlreadyExistsException() {
        super("License plate is already in use.");
    }
}
