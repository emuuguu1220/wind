package edu.miu.cs.cs544.a202001.wind.service;

import edu.miu.cs.cs544.a202001.wind.domain.Location;

import java.util.List;

public interface ILocationService {
    //Create
    public abstract Location addLocation(Location location);
    //Read
    public abstract Location getLocationById(int locationId);
    public abstract List<Location> getAllLocation();
    //Update
    public abstract Location updateLocation(Location location);
    //Delete
    public abstract int deleteLocationById(int locationId);
}
