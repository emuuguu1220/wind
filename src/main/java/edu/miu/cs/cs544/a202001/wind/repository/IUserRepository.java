package edu.miu.cs.cs544.a202001.wind.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.miu.cs.cs544.a202001.wind.domain.User;
 
 
@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
	@Query("SELECT t FROM User t where t.userName = :userName")
	User findByUsername(String userName);
}
