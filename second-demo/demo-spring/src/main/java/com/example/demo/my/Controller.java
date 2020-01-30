package com.example.demo.my;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @author Petr Janik 485122
 * @since 13/08/2019
 */
@RestController
public class Controller {
    private MyService service;

    @Autowired
    public Controller(MyService service) {
        this.service = service;
    }

    @Transactional(readOnly = true) // for optimization purposes
    @GetMapping(path = "/cars", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Iterable<Car> getAllCars() {
        return service.getAllCars();
    }

    @Transactional(readOnly = true) // for optimization purposes
    @GetMapping(path = "/persons", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Iterable<Person> getAllPersons() {
        return service.getAllPersons();
    }

    @PostMapping(path = "/car/{make}")
    public void addCar(@PathVariable("make") String make) {
        service.addCar(make);
    }

    @Transactional(readOnly = true)
    @GetMapping("car/{prefix}")
    public Iterable<Car> getCarsWithPrefix(@PathVariable("prefix") String prefix) {
        return service.getCarsStartingWith(prefix);
    }

    @Transactional(readOnly = true)
    @GetMapping("car/findbymake/{make}")
    public Car findCarByMake(@PathVariable("make") String make) {
        return service.findCarByMake(make);
    }

//    @ApiOperation("Listing all mco hosts")
    @RequestMapping(value = "/api/ht/mco", method = GET)
    public void getMcoHosts(@Value("#{'${mco.hosts}'.split(',')}") List<String> mcoHosts) {
        System.out.println("Get mco hosts.");
//        String[] hosts = mcoHosts.split(",");
        for (String host : mcoHosts) {
            System.out.println(host);
        }
    }
}
