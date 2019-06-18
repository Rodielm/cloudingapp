package es.uv.twcam.cloudingapi.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.uv.twcam.cloudingapi.entities.User;
import es.uv.twcam.cloudingapi.repositories.UserRepo;

/**
 * UserDetailsServiceImpl
 */

@Service
@Primary
public class UserDetailsServiceImpl implements UserDetailsService {

    
	@Autowired
    @Lazy
      private BCryptPasswordEncoder encoder;
  
      @Autowired
      UserRepo userRepo;
  
      @Transactional
      public UserDetails loadUserByUsername(String username) {
  
          username = username.toLowerCase();
          User user;
  
          try {
              user = userRepo.findByUsername(username);
              user.setPassword(encoder.encode(user.getPassword()));
          } catch (ObjectRetrievalFailureException orfe) {
              throw new UsernameNotFoundException("User '" + username + "' could not be found.");
          }
  
          List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                              .commaSeparatedStringToAuthorityList("ROLE_" + user.getRol());
  
          return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
      }
}