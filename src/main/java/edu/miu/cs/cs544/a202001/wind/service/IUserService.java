package edu.miu.cs.cs544.a202001.wind.service;

import edu.miu.cs.cs544.a202001.wind.domain.Location;
import edu.miu.cs.cs544.a202001.wind.domain.User;

import java.util.List;

public interface IUserService {
    public abstract void addUser(User user);
    public abstract User getUserById(Long id);
    public abstract List<User> getAllUsers();
    public abstract void updateUser(User user);
    public abstract void deleteUser(User user);
}
