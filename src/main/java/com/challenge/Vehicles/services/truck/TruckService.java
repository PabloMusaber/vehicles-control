package com.challenge.Vehicles.services.truck;

import java.util.List;

import com.challenge.Vehicles.dtos.truck.TruckResponseDTO;

public interface TruckService {
    List<TruckResponseDTO> getAllTrucks();
}
