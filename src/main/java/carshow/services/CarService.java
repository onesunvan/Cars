package carshow.services;

import carshow.entities.Car;
import carshow.exceptions.CarNotFoundException;
import carshow.repositories.CarRepository;

import java.util.List;
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

    public List<Car> getCarsOnPageIfExists(Integer number) {
        return carRepository.readLimitOffsetIfExists(9, number * 9);
    }

    public List<Car> getCarsOnPage(Integer number) {
        return carRepository.readLimitOffset(9, number * 9);
    }

    public List<Car> getCarsOnPageLikeIfExists(Integer number, String filter) {
        return carRepository.readLimitOffsetLikeIfExists(9, number * 9, filter);
    }

    public List<Car> getCarsOnPageLike(Integer number, String filter) {
        return carRepository.readLimitOffsetLike(9, number * 9, filter);
    }

    public Car getCarById(Long id) {
        Car car = carRepository.read(id);
        if (car == null) {
            throw new CarNotFoundException();
        } else {
            return car;
        }
    }

    public void disableCar(Long id) {
        Car car = carRepository.read(id);
        if (car == null) {
            throw new CarNotFoundException();
        } else {
            car.setIfExists(Boolean.FALSE);
            carRepository.update(car);
        }
    }

    public void restoreCar(Long id) {
        Car car = carRepository.read(id);
        if (car == null) {
            throw new CarNotFoundException();
        } else {
            car.setIfExists(Boolean.TRUE);
            carRepository.update(car);
        }
    }

}
