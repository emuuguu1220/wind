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

import edu.miu.cs.cs544.a202001.wind.domain.User;

import java.util.HashSet;
import java.util.Set;
@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	String ROLE_PREFIX = "ROLE_";
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
//	    User user = userRepository.findByUsername(username);
	
	    Set grantedAuthorities = new HashSet<>();
	//    for (Role role : user.getRoles()){
	//        grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
	//    }
	    grantedAuthorities.add(new SimpleGrantedAuthority(ROLE_PREFIX + "FACULTY"));
	    String pass = bCryptPasswordEncoder.encode("pass");
	    System.out.println("granting acccesss:"+pass);
	    return new org.springframework.security.core.userdetails.User("munkh", pass, grantedAuthorities);
	}
}