package com.bilgeadam.springbootthymeleaf.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//2 farklı yolu var
@Configuration
public class SeConfig extends WebSecurityConfigurerAdapter {

//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().ignoringAntMatchers("/*/ekle");
		http.authorizeRequests().antMatchers("/ogretmen/ekle").hasRole("ADMIN");// rolüne göre yetkilendirme yapmayı
																				// sağlar.

		http.authorizeRequests().antMatchers("/*/ekle").authenticated();
		http.authorizeRequests().antMatchers("/*/sil").authenticated();
		http.authorizeRequests().antMatchers(HttpMethod.DELETE).hasRole("DELETE");// delete rolü olanlar delete
																					// işlemlerini yapabilir.
		http.authorizeRequests().and().formLogin().defaultSuccessUrl("/ogretmen");
		http.authorizeRequests().and().logout().logoutSuccessUrl("/ogretmen");

//		AuthenticationFailureHandler handler = new AuthenticationFailureHandler() {
//
//			@Override
//			public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
//					AuthenticationException exception) throws IOException, ServletException {
//					if(exception instanceof BadCredentialsException)
//					{
//						response.sendRedirect("/login?error=1");
//					}
//			}
//		};
//		http.authorizeRequests().and().formLogin().failureHandler(handler);
//		http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/login");
		http.authorizeRequests().anyRequest().permitAll();
	}
}
