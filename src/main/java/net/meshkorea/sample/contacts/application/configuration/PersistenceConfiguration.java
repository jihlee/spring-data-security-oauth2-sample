package net.meshkorea.sample.contacts.application.configuration;

import org.h2.tools.Server;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by jihunlee on 2016. 1. 12..
 */
@Configuration
@EntityScan("net.meshkorea.sample.contacts.domain.entity")
@EnableJpaRepositories("net.meshkorea.sample.contacts.domain.repository")
//        repositoryFactoryBeanClass = EnversRevisionRepositoryFactoryBean.class)
public class PersistenceConfiguration {

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .generateUniqueName(true)
                .setType(EmbeddedDatabaseType.H2)
                .setScriptEncoding("UTF-8")
                .ignoreFailedDrops(true)
                .build();
    }

//    @Bean
//    public DataSource mysqlDataSource() {
//        System.out.println("userDBDatasource :: init");
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://localhost:3306/test");
//        dataSource.setUsername("root");
//        dataSource.setPassword("root");
//        return dataSource;
//    }
//
//    @Bean
//    public AbstractEntityManagerFactoryBean entityManagerFactory() throws SQLException {
//        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
//        jpaVendorAdapter.setDatabase(Database.HSQL);
//        jpaVendorAdapter.setGenerateDdl(true);
//
//        LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
//        bean.setJpaVendorAdapter(jpaVendorAdapter);
//        bean.setPackagesToScan(DeserializerFactory.Config.class.getPackage().getName());
//        bean.setDataSource(dataSource());
//        bean.setJpaPropertyMap(jpaProperties());
//        return bean;
//    }
//
//    private Map<String, String> jpaProperties() {
//        Map<String, String> map = Maps.newHashMap();
//        map.put("hibernate.hbm2ddl.import_files_sql_extractor", MultipleLinesSqlCommandExtractor.class.getName());
//        map.put("org.hibernate.envers.audit_strategy", ValidityAuditStrategy.class.getName());
//
//        return map;
//    }

}
