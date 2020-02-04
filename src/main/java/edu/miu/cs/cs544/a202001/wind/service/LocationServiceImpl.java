package edu.miu.cs.cs544.a202001.wind.service;

import edu.miu.cs.cs544.a202001.wind.domain.Location;
import edu.miu.cs.cs544.a202001.wind.repository.ILocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements ILocationService {


    private ILocationRepository locationRepository;

    public LocationServiceImpl(ILocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public LocationServiceImpl() {
    }

    public ILocationRepository getLocationRepository() {
        return locationRepository;
    }
    @Autowired
    public void setLocationRepository(ILocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public Location addLocation(Location location) {
        return null;
    }

    @Override
    public Location getLocationById(int locationId) {
        return null;
    }

    @Override
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    @Override
    public Location updateLocation(Location location) {
        return null;
    }

    @Override
    public int deleteLocationById(int locationId) {
        return 0;
    }
}
