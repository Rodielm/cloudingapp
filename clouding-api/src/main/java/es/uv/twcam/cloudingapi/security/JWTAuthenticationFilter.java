package es.uv.twcam.cloudingapi.security;

import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import es.uv.twcam.cloudingapi.repositories.UserRepo;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import static es.uv.twcam.cloudingapi.security.Constants.*;

/**
 * JWTAuthenticationFilter
 */
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    
    @Autowired
    UserRepo userRepo;
  
    private AuthenticationManager authenticationManager;
  
    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
      this.authenticationManager = authenticationManager;
    }
  
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
        throws AuthenticationException {
      try {
        User credenciales = new ObjectMapper().readValue(request.getInputStream(), User.class);
  
        return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
            credenciales.getUsername(), credenciales.getPassword(), new ArrayList<>()));
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
  
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
        Authentication auth) throws IOException, ServletException {
  
      String token = Jwts.builder().setIssuedAt(new Date()).setIssuer(ISSUER_INFO)
          .setSubject(((User)auth.getPrincipal()).getUsername())
          .setExpiration(new Date(System.currentTimeMillis() + TOKEN_EXPIRATION_TIME))
          .signWith(SignatureAlgorithm.HS512, SUPER_SECRET_KEY).compact();
      response.addHeader(HEADER_AUTHORIZACION_KEY, TOKEN_BEARER_PREFIX + " " + token);
    }
    
}