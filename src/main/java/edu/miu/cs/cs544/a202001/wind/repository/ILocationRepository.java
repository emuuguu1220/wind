package edu.miu.cs.cs544.a202001.wind.repository;

import edu.miu.cs.cs544.a202001.wind.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILocationRepository extends JpaRepository<Location, Integer> {
}
