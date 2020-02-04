package edu.miu.cs.cs544.a202001.wind.controller;
import edu.miu.cs.cs544.a202001.wind.domain.Location;
import edu.miu.cs.cs544.a202001.wind.service.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LocationController {

    private ILocationService locationService;

    @GetMapping(value = "/locationss")
    public List<Location> getAllLocations() {
        return locationService.getAllLocations();
    }

    public LocationController() {
    }

    public ILocationService getLocationService() {
        return locationService;
    }
    @Autowired
    public void setLocationService(ILocationService locationService) {
        this.locationService = locationService;
    }
}
