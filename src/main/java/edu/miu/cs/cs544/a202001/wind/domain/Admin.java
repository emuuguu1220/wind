package edu.miu.cs.cs544.a202001.wind.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("admin")
public class Admin extends User{
	public Admin() {}
	public Admin(String userName,String password, String firstName, String lastName, String email) {
		super(userName,password,firstName,lastName,email);
	}
}
