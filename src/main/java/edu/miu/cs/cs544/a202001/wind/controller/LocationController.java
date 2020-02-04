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

    @GetMapping(value = "/{id}")
    public Location getLocation(@PathVariable Long id) {
        return locationService.getLocationById(id);
    }


    @PostMapping(value = "/add")
    public void addLocation(@RequestBody Location location) {
        locationService.addLocation(location);
    }

    @PutMapping(value = "/update")
    public void updateLocation(@RequestBody Location location) {
        locationService.updateLocation(location);
    }

    @DeleteMapping(value = "/delete")
    public void deleteLocation(@RequestBody Location location) {
        locationService.deleteLocation(location);
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
