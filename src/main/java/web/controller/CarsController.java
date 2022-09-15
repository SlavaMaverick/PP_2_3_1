package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.ServiceImp;

@Controller
public class CarsController {

    private final ServiceImp serviceImp;

    @Autowired
    public CarsController(ServiceImp serviceImp) {
        this.serviceImp = serviceImp;
    }

    @GetMapping(value = "/cars")
    public String printCars(@RequestParam(value = "count", required = false) Integer numberOfCars, ModelMap model) {
        if (numberOfCars == null || numberOfCars < 1 || numberOfCars > 5) {
            numberOfCars = 5;
        }
        model.addAttribute("cars", serviceImp.getCarsList(numberOfCars));
        return "cars";
    }


}

