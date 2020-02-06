package edu.miu.cs.cs544.a202001.wind.service.security;

public interface SecurityService {
	public String findLoggedInUsername();
	public void login(String username, String password);
}
