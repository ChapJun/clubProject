package com.club.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.club.service.PersonService;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//	@Autowired
//	private DataSource dataSource;
	
	@Autowired
	private PersonService personService;

	@Override
	protected void configure(HttpSecurity security) throws Exception {

		security.authorizeRequests().antMatchers("/").permitAll();
		security.authorizeRequests().antMatchers("/main/**", "/clubIntro/**", "/insertBoard/**",
				"/getBoardList/**").authenticated();
		security.authorizeRequests().antMatchers("/manager/**").hasRole("MANAGER");

		security.csrf().disable();

//		security.formLogin();
		security.formLogin().loginPage("/").defaultSuccessUrl("/main", true);
		security.exceptionHandling().accessDeniedPage("/accessDenied");
		security.logout().invalidateHttpSession(true).logoutSuccessUrl("/");
		
		security.userDetailsService(personService);
		security.headers().frameOptions().disable();
		security.headers().frameOptions().sameOrigin();
	}

	/*
	 * @Autowired public void authenticate(AuthenticationManagerBuilder auth) throws
	 * Exception {
	 * 
	 * String query1 =
	 * "select id username, concat('{noop}', pw) password, from person " +
	 * "where id=?"; // String query2 = "select id from person where id=?";
	 * 
	 * auth.inMemoryAuthentication().withUser("manager")
	 * .password("{noop}123").roles("MANAGER");
	 * 
	 * //
	 * auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery(query1)
	 * ;
	 * 
	 * }
	 */
}
