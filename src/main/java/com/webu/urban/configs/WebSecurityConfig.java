package com.webu.urban.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

// allows for further configuration of spring login and db source

@Configuration // <- lets it be picked up by application as config file
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired //using bean definition from urban.configs.Beans
    @Qualifier("dataSource1")
    private DataSource dataSource;

    @Override// custom authentication config
    protected void configure(HttpSecurity http) throws Exception {

        String[] whiteList = {"/img/**","/css/**","/fonts/**","/js/**","/about", "/gallery","/",
                            "/home", "/registry", "/inspire", "/validateCode", "/interiors", "/events"};
        http
            .authorizeRequests() //order important, match has access to any urls below it
                .antMatchers("/admin/**").hasRole("ADMIN")     //must have proper authority for anything past these urls
                .antMatchers(whiteList).permitAll()  //allows client to access resource files
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")  //custom login page
                .permitAll()
                .and()
            .logout()
                .permitAll();
        http.csrf().disable();
        http.headers().frameOptions().disable();

    }

    @Autowired //db config
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

            auth.jdbcAuthentication().dataSource(this.dataSource);
    }

}
