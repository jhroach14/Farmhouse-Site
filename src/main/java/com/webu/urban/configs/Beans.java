package com.webu.urban.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

//spring bean definitions = factories for a class
@Configuration
public class Beans {

    @Autowired
    private Environment env;

    @Bean(name="dataSource1")  //db connection object used by spring
    public DataSource dataSource() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("myapp.dataSource.driver"));
        dataSource.setUrl(env.getProperty("myapp.dataSource.url"));                    //db info from application.properties
        dataSource.setUsername(env.getProperty("myapp.dataSource.username"));
        dataSource.setPassword(env.getProperty("myapp.dataSource.password"));

        return dataSource;
    }

}
