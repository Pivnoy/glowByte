package com.example.glow.configuration.mySql;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Makarev Evgenij, Lagus Maxim
 * This class of this custom configuration
 * for the MySQL and add this configuration
 * to make multiple resources access to Hikari pool
 * */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "mysqlEntityManagerFactory",
        transactionManagerRef = "mysqlTransactionManager",
        basePackages = {"com.example.glow.repository.mySqlRep"}
)
public class MySqlDataSourceConfiguration {

    /**
     * @author Makarev Evgenij, Lagus Maxim
     * @return example of MySQLDataSourceProperty
     * */
    @Primary
    @Bean( name = "mysqlDataSourceProperties")
    @ConfigurationProperties("spring.datasource-mysql")
    public DataSourceProperties mysqlDataSourceProperties() {
        return new DataSourceProperties();
    }

    /**
     * @author Makarev Evgenij, Lagus Maxim
     * @return example of MySQLDataSource
     * */
    @Primary
    @Bean(name = "mysqlDataSource")
    @ConfigurationProperties("spring.datasource-mysql.configuration")
    public DataSource mysqlDataSource(@Qualifier("mysqlDataSourceProperties") DataSourceProperties mysqlDataSourceProperties) {
        return mysqlDataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

    /**
     * @author Makarev Evgenij, Lagus Maxim
     * @return example of MySQLEntityManagerFactory
     * */
    @Primary
    @Bean(name = "mysqlEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean mysqlEntityManagerFactory(EntityManagerFactoryBuilder mysqlEntityManagerFactoryBuilder, @Qualifier("mysqlDataSource") DataSource mysqlDataSource) {
        Map<String, String> primaryJpaProperties = new HashMap<>();
        primaryJpaProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        primaryJpaProperties.put("hibernate.hbm2ddl.auto", "none");

        return mysqlEntityManagerFactoryBuilder
                .dataSource(mysqlDataSource)
                .packages("com.example.glow.entity.mySql")
                .persistenceUnit("mysqlDataSource")
                .properties(primaryJpaProperties)
                .build();
    }

    /**
     * @author Makarev Evgenij, Lagus Maxim
     * @return example of MySQLEntityManagerFactory
     * */
    @Primary
    @Bean(name = "mysqlTransactionManager")
    public PlatformTransactionManager primaryTransactionManager(
            @Qualifier("mysqlEntityManagerFactory") EntityManagerFactory mysqlTransactionManager) {

        return new JpaTransactionManager(mysqlTransactionManager);
    }
}
