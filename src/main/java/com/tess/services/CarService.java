package com.tess.services;

import com.tess.entities.Car;
import com.tess.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ivan
 */
@Service
public class CarService {
    
    @Autowired
    private CarRepository carRepository;
    
    public void saveCar(Car car) {
        carRepository.save(car);
    }

    public byte[] getCarImageById(Long id) {
        Car car = carRepository.read(id);
        return car.getImage();
    }
    
}
