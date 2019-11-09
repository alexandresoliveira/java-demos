package br.com.aleoliv.demospringsecurity.configuration.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import br.com.aleoliv.demospringsecurity.filters.JWTAuthenticationFilter;
import br.com.aleoliv.demospringsecurity.filters.JWTLoginFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
      .csrf().disable()
      .authorizeRequests()
        .antMatchers("/home").permitAll()
        .antMatchers(HttpMethod.POST, "/auth").permitAll()
      .anyRequest().authenticated()
      .and()
      .addFilterBefore(new JWTLoginFilter("/auth", authenticationManager()), UsernamePasswordAuthenticationFilter.class)
      .addFilterBefore(new JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication()
      .withUser("admin")
      .password("{noop}admin")
      .roles("Root");
  }
  
}
