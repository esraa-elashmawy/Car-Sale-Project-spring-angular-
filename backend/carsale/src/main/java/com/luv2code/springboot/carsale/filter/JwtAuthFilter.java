package com.luv2code.springboot.carsale.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.luv2code.springboot.carsale.service.JwtService;
import com.luv2code.springboot.carsale.service.UserInfoService;


@Component
public class JwtAuthFilter extends OncePerRequestFilter {
	 

	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private UserInfoService userDetailsService;
	
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException { 
        String authHeader = request.getHeader("Authorization"); 
        String token = null; 
        String username = null; 
        if (authHeader != null && authHeader.startsWith("Bearer ")) { 
            token = authHeader.substring(7); 
            username = jwtService.extractUsername(token); 
        } 
  
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) { 
            UserDetails userDetails = userDetailsService.loadUserByUsername(username); 
            if (jwtService.validateToken(token, userDetails)) { 
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities()); 
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request)); 
                SecurityContextHolder.getContext().setAuthentication(authToken); 
            } 
        } 
        filterChain.doFilter(request, response); 
    }
	
	
//	
//	@Override
//	protected void doFilterInternal(
//			HttpServletRequest request,
//			HttpServletResponse response, 
//			FilterChain filterChain)
//			throws ServletException, IOException {
//		// jwt auth token is sent within the header, so we extract it:
//		final String authHeader = request.getHeader("Autherization");
//		final String jwt;
//		final String email;
//		if(  authHeader == null || !authHeader.startsWith("Bearer")) {
//			filterChain.doFilter(request, response);
//			return;
//		}
//		
//		jwt = authHeader.substring(7);
//		email= jwtService.extractUsername(jwt);
//
//	   if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) { 
//            UserDetails userDetails = userDetailsService.loadUserByUsername(email); 
//            if (jwtService.validateToken(jwt, userDetails)) { 
//                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities()); 
//                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request)); 
//                SecurityContextHolder.getContext().setAuthentication(authToken); 
//            } 
//        } 
//	   
//		filterChain.doFilter(request, response);
//
//		
//	}

}
