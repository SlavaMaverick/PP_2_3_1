package web.service;

import org.springframework.stereotype.Component;
import web.model.Car;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ServiceImp implements Service {

    @Override
    public List<Car> getCarsList(int count) {

        List<Car> cars = new ArrayList<>();

        cars.add(new Car("Lada", "Blue", 2022));
        cars.add(new Car("Ford", "White", 2018));
        cars.add(new Car("BMW", "Red", 2015));
        cars.add(new Car("Mersedes", "Green", 2019));
        cars.add(new Car("Lexus", "Black", 2016));

        return cars.stream().limit(count).collect(Collectors.toList());
    }
}


