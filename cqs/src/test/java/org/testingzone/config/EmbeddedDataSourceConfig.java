package org.testingzone.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.testingzone.config.profiles.ProfileTest;

@Configuration
@PropertySource("config/datasource.test.properties")
@ProfileTest
public class EmbeddedDataSourceConfig extends AbstractDataSourceConfig {

    @Autowired
    private Environment env;

    @Override
    protected String jpaPropertiesPath() {
        return "config/datasource.test.properties";
    }

    @Override
    protected Environment environment() {
        return env;
    }
}
