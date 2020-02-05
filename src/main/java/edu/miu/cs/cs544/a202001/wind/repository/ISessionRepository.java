package edu.miu.cs.cs544.a202001.wind.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.miu.cs.cs544.a202001.wind.domain.Session;


@Repository
public interface ISessionRepository extends JpaRepository<Session, Long> {
	
}
