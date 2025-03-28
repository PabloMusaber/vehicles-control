package com.challenge.Vehicles.services.car;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.challenge.Vehicles.dtos.car.CarResponseDTO;
import com.challenge.Vehicles.entities.Car;
import com.challenge.Vehicles.repositories.VehicleRepository;

@Service
public class CarServiceImpl implements CarService {
    private final VehicleRepository vehicleRepository;
    private final ModelMapper modelMapper;

    public CarServiceImpl(VehicleRepository vehicleRepository, ModelMapper modelMapper) {
        this.vehicleRepository = vehicleRepository;
        this.modelMapper = modelMapper;
    }

    public List<CarResponseDTO> getAllCars() {
        return vehicleRepository.findAll().stream()
                .filter(vehicle -> vehicle instanceof Car)
                .map(vehicle -> modelMapper.map(vehicle, CarResponseDTO.class))
                .collect(Collectors.toList());
    }

}
