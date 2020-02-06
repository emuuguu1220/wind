package edu.miu.cs.cs544.a202001.wind.service.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.miu.cs.cs544.a202001.wind.domain.Admin;
import edu.miu.cs.cs544.a202001.wind.domain.Faculty;
import edu.miu.cs.cs544.a202001.wind.domain.Student;
import edu.miu.cs.cs544.a202001.wind.domain.User;
import edu.miu.cs.cs544.a202001.wind.repository.IUserRepository;

import java.util.HashSet;
import java.util.Set;
@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	String ROLE_PREFIX = "ROLE_";
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	IUserRepository userRepository;
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
	    User user = userRepository.findByUsername(username);
	    System.out.println(user.getFirstName());
	    Set grantedAuthorities = new HashSet<>();
	    String roleString = "NONE";
	    if(user instanceof Student) {
	    	grantedAuthorities.add(new SimpleGrantedAuthority(ROLE_PREFIX + "STUDENT"));
	    	roleString = "STUDENT";
	    }else if(user instanceof Faculty){
	    	roleString = "FACULTY";
	    }else if(user instanceof Admin) {
	    	roleString = "ADMIN";
	    }
	    System.out.println("---------" + roleString +" LOGGED IN-------------");
	    grantedAuthorities.add(new SimpleGrantedAuthority(ROLE_PREFIX + roleString));
	    return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), grantedAuthorities);
	}
}