package edu.miu.cs.cs544.a202001.wind.domain;

public class Location {
    private int id;
    private String locationId;
    private String building;
    private int capacity;
    private String name;
    private String room;
    private String description;

    public Location() {
    }

    public Location(String locationId, String building, int capacity, String name, String room, String description) {
        this.locationId = locationId;
        this.building = building;
        this.capacity = capacity;
        this.name = name;
        this.room = room;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
