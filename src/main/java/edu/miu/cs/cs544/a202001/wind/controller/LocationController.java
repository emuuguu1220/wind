package edu.miu.cs.cs544.a202001.wind.controller;
import edu.miu.cs.cs544.a202001.wind.domain.Location;
import edu.miu.cs.cs544.a202001.wind.service.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocationController {

    private ILocationService locationService;

    @GetMapping(value = "/")
    public List<Location> getAllLocations() {
        return locationService.getAllLocations();
    }

    @PostMapping(value = "/add")
    public void addLocation(@RequestBody Location location) {
        locationService.addLocation(location);
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
