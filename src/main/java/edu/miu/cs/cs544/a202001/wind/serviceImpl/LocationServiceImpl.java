package edu.miu.cs.cs544.a202001.wind.serviceImpl;

import edu.miu.cs.cs544.a202001.wind.domain.Location;
import edu.miu.cs.cs544.a202001.wind.service.ILocationService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LocationServiceImpl implements ILocationService {
    @Override
    public Location addLocation(Location location) {
        return null;
    }

    @Override
    public Location getLocationById(int locationId) {
        return null;
    }

    @Override
    public List<Location> getAllLocation() {
        return null;
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
