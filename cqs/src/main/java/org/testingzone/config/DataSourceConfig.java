package org.testingzone.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.testingzone.config.profiles.ProfileProd;

@Configuration
@PropertySource("config/datasource.properties")
@ProfileProd
public class DataSourceConfig extends AbstractDataSourceConfig {

    @Autowired
    private Environment env;

    @Override
    protected String jpaPropertiesPath() {
        return "config/hibernate.properties";
    }

    @Override
    protected Environment environment() {
        return env;
    }
}
