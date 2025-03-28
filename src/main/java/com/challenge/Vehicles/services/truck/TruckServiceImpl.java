package com.challenge.Vehicles.services.truck;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.challenge.Vehicles.dtos.truck.TruckResponseDTO;
import com.challenge.Vehicles.entities.Truck;
import com.challenge.Vehicles.repositories.VehicleRepository;

@Service
public class TruckServiceImpl implements TruckService {
    private final VehicleRepository vehicleRepository;
    private final ModelMapper modelMapper;

    public TruckServiceImpl(VehicleRepository vehicleRepository, ModelMapper modelMapper) {
        this.vehicleRepository = vehicleRepository;
        this.modelMapper = modelMapper;
    }

    public List<TruckResponseDTO> getAllTrucks() {
        return vehicleRepository.findAll().stream()
                .filter(vehicle -> vehicle instanceof Truck)
                .map(vehicle -> modelMapper.map(vehicle, TruckResponseDTO.class))
                .collect(Collectors.toList());
    }

}
