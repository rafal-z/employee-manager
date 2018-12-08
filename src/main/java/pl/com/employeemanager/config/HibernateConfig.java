package pl.com.employeemanager.config;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan("pl.com.employeemanager")
public class HibernateConfig {
    @Bean
    public DataSourceTransactionManager transactionManager() {
        final DataSourceTransactionManager txManager = new DataSourceTransactionManager();
        txManager.setDataSource(getDatasourceConfiguration());

        return txManager;
    }

    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory() throws IOException {
        Properties hibernateProperties = getHibernateProperties();
        DataSource dataSource = getDatasourceConfiguration();
        LocalSessionFactoryBean localSessionFactoryBean = generateSessionFactoryBean(new String[] { "pl.com.employeemanager" },
                dataSource, hibernateProperties);
        SessionFactory sessionFactory = localSessionFactoryBean.getObject();

        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory);

        return sessionFactory;
    }

    private DataSource getDatasourceConfiguration() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://127.0.0.1:5432/dev");
        dataSource.setUsername("root");
        dataSource.setPassword("example");

        return dataSource;
    }

    private static LocalSessionFactoryBean generateSessionFactoryBean(String[] basePackage, DataSource dataSource,
                                                                      Properties hibernateProperties) throws IOException {
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(dataSource);
        localSessionFactoryBean.setPackagesToScan(basePackage);
        localSessionFactoryBean.setHibernateProperties(hibernateProperties);
        localSessionFactoryBean.afterPropertiesSet();

        return localSessionFactoryBean;
    }

    private static Properties getHibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        hibernateProperties.put("hibernate.show_sql", false);
        hibernateProperties.put("hibernate.generate_statistics", false);
        hibernateProperties.put("hibernate.hbm2ddl.auto", "update");
        hibernateProperties.put("hibernate.use_sql_comments", false);

        return hibernateProperties;
    }
}
