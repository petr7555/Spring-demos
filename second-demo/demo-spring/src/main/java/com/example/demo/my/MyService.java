package com.example.demo.my;

import com.example.demo.entitites.PingLogEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Petr Janik 485122
 * @since 13/08/2019
 */
@Component
@Transactional
public class MyService {

    CarRepository carRepository;
    PersonRepository personRepository;

    public MyService(CarRepository carRepository, PersonRepository personRepository) {
        this.carRepository = carRepository;
        this.personRepository = personRepository;
    }

    public Iterable<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Iterable<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public void addCar(String make) {
        for (int i = 1; i < 5; i++) {
            Car car = new Car(make+i);
            Person person = personRepository.findByName("Petr");
            car.setOwnedBy(person);
            person.addCar(car);
            carRepository.save(car);
            if (make.equals("error") && i == 3) {
                throw new RuntimeException("error");
            }
        }
    }

    public Iterable<Car> getCarsStartingWith(String prefix) {
        return carRepository.getStartingWith(prefix);
    }

    public Car findCarByMake(String make) {
        return carRepository.findByMake(make);
    }
}
