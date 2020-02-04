package edu.miu.cs.cs544.a202001.wind.service;

import edu.miu.cs.cs544.a202001.wind.domain.Location;

import java.util.List;

public interface ILocationService {
    public abstract void addLocation(Location location);
    public abstract Location getLocationById(int locationId);
    public abstract List<Location> getAllLocations();
    public abstract Location updateLocation(Location location);
    public abstract int deleteLocationById(int locationId);
}
