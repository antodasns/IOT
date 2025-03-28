package com.device.iot.security.filter;

import java.io.IOException;

import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ExceptionHandlerFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            filterChain.doFilter(request, response);
        } catch (EntityNotFoundException e) { //Feel free to create a separate function.
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
           
        } catch (java.io.IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    }
}
