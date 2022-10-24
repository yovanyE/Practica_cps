package com.gps.configuration;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
@Configuration
@EnableTransactionManagement
public class ConfigurationDB {
	@Bean
	public DataSource getDataSource() {
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSource.setUrl("jdbc:sqlserver://localhost:1433;databaseName=practica_gps;integratedSecurity=false;encrypt=false;trustServerCertificate=true;");
        dataSource.setUsername("root");
        dataSource.setPassword("12345678");
		return dataSource;
	}
    public Properties getHibernaProperties(){
        Properties properties=new Properties();
        properties.put("hibernate.dialect","org.hibernate.dialect.SQLServerDialect");
        properties.put("show_sql","true");
        return properties;
    }
    @Bean
    public LocalSessionFactoryBean getSessionFactory(){
        LocalSessionFactoryBean sessionFactoryBean =new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(getDataSource());
        sessionFactoryBean.setPackagesToScan("com.gps.model");
        sessionFactoryBean.setHibernateProperties(getHibernaProperties());
        return sessionFactoryBean;
    }
    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(){
        HibernateTransactionManager hibernateTransactionManager=new HibernateTransactionManager();
        hibernateTransactionManager.setSessionFactory(getSessionFactory().getObject());
        return hibernateTransactionManager;
    }
}
