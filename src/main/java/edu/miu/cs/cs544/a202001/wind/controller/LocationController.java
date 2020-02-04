package edu.miu.cs.cs544.a202001.wind.controller;
import edu.miu.cs.cs544.a202001.wind.domain.Location;
import edu.miu.cs.cs544.a202001.wind.service.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LocationController {
    @Autowired
    private ILocationService locationService;

    @GetMapping(value = "/")
    public List<Location> getAllLocations() {
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        return   locationService.getAllLocations();
    }

    public LocationController() {
    }

    public ILocationService getLocationService() {
        return locationService;
    }

    public void setLocationService(ILocationService locationService) {
        this.locationService = locationService;
    }
}
