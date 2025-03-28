package com.challenge.Vehicles.services.car;

import java.util.List;

import com.challenge.Vehicles.dtos.car.CarResponseDTO;

public interface CarService {
    List<CarResponseDTO> getAllCars();
}
