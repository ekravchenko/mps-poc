package org.testingzone.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public abstract class AbstractDataSourceConfig {

    protected abstract String jpaPropertiesPath();

    protected abstract Environment environment();

    @Bean(name="jpaProperties")
    public Properties jpaProperties() {
        try {
            Properties properties = new Properties();
            String jpaPropertiesPath = jpaPropertiesPath();
            InputStream is = getClass().getClassLoader().getResourceAsStream(jpaPropertiesPath);
            properties.load(is);
            return properties;
        } catch (IOException e) {
            throw new IllegalArgumentException("Can't find 'hibernate.properties' in classpath", e);
        }
    }

    @Bean(name="dataSource")
    protected DataSource dataSource() {
        Environment env = environment();
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName(env.getProperty("datasource.driver"));
        basicDataSource.setUrl(env.getProperty("datasource.url"));
        basicDataSource.setUsername(env.getProperty("datasource.username"));
        basicDataSource.setPassword(env.getProperty("datasource.password"));
        return basicDataSource;
    }
}
