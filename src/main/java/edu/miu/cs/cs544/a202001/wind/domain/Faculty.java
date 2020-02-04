package edu.miu.cs.cs544.a202001.wind.domain;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("FACULTY")
public class Faculty extends User{
	public Faculty() {}
	public Faculty(String userName,String password, String firstName, String lastName, String email) {
		super(userName,password,firstName,lastName,email);
	}
}
