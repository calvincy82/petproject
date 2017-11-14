package com.calvin.login.example.config;

import java.util.HashMap;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("com.calvin.login.example.*")
@EnableJpaRepositories(basePackages = "com.calvin.login.example.dao")
@EnableTransactionManagement
@PropertySource(value = "classpath:datasource-cfg.properties")
public class ApplicationConfiguration {

	@Autowired
	private Environment env;

	@Bean
	public InternalResourceViewResolver getViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/jsp");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Bean
	public BasicDataSource dataSource() {
		final BasicDataSource config = new BasicDataSource();
		config.setDriverClassName(env.getRequiredProperty("ds.database.driver"));
		config.setUrl(env.getRequiredProperty("ds.url"));
		config.setUsername(env.getRequiredProperty("ds.username"));
		config.setPassword(env.getRequiredProperty("ds.password"));
		config.setInitialSize(50);
		return config;
	}

	private JpaVendorAdapter jpaVendorAdapter() {
		return new HibernateJpaVendorAdapter();
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(final DataSource dataSource) {
		final LocalContainerEntityManagerFactoryBean emfb = new LocalContainerEntityManagerFactoryBean();
		emfb.setDataSource(dataSource);
		emfb.setPackagesToScan("com.calvin.login.example.model");
		emfb.setJpaVendorAdapter(jpaVendorAdapter());
		emfb.setJpaPropertyMap(jpaProperties());
		return emfb;
	}

	@Bean
	public JpaTransactionManager transactionManager(final EntityManagerFactory emf, final DataSource dataSource) {
		return new JpaTransactionManager(emf);
	}

	@SuppressWarnings("serial")
	private HashMap<String, String> jpaProperties() {
		return new HashMap<String, String>() {
			{
				put("hibernate.id.new_generator_mappings", "false");
				put("hibernate.show_sql", "false");
				put("hibernate.format_sql", "false");
				put("hibernate.dialect", "org.hibernate.dialect.PostgreSQL94Dialect");
			}
		};
	}
	
	 @Bean
    	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() throws IOException {
        PropertySourcesPlaceholderConfigurer ppc = new PropertySourcesPlaceholderConfigurer();
        ppc.setLocalOverride(true);
        String externalPropertiesPath = System.getProperty("external.prop");
        L.debug("external.prop: {}", externalPropertiesPath);
        Path p = Paths.get(externalPropertiesPath);
        if (Files.exists(p) && Files.isDirectory(p) && Files.isReadable(p)) {
            ppc.setLocations(new PathMatchingResourcePatternResolver().getResources(p.toUri().toString() + "sc/**/*.properties"));
        }
        return ppc;
    }
}
