package br.com.detec.sysjob.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = findUserbyUername(username);

		if (user == null) {
			throw new UsernameNotFoundException("User not found.");
		}

		return user;
	}

	private User findUserbyUername(String username) {
		Set<GrantedAuthority> grantedAuthorities = new HashSet();
		grantedAuthorities.add(new SimpleGrantedAuthority("ROLE"));
		return new User("admin", "admin", grantedAuthorities);
	}

}
