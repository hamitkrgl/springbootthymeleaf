package com.bilgeadam.springbootthymeleaf.configuration;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value = 100)
public class MyCustomFilter implements Filter {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// System.err.println("-------> " + request.getClass().getName());
		// SecurityContextHolderAwareRequestWrapper req =
		// (SecurityContextHolderAwareRequestWrapper) request;
//		if (req.getMethod().equals("GET"))
//		{
//			// response.getWriter().write("Post yapamazsınız");
//			throw new ServletException("Get yapamazsınız");
//		}
//		else
//		{
		chain.doFilter(request, response);
//		}
	}
}
