package com.example.rapid;

import java.io.File;
import java.util.Properties;

import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableJpaRepositories("com.example.rapid")
@EnableTransactionManagement
class ApplicationConfig extends WebMvcConfigurerAdapter{
	/*	
	private static final String PROPERTY_NAME_DATABASE_DRIVER = "spring.datasource.driverClassName";
	private static final String PROPERTY_NAME_DATABASE_PASSWORD = "spring.datasource.password";
	private static final String PROPERTY_NAME_DATABASE_URL = "spring.datasource.url";
	private static final String PROPERTY_NAME_DATABASE_USERNAME = "spring.datasource.username";
	public static final File CRM_STORAGE_UPLOADS_DIRECTORY = new File("/tmp");
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		EntityManagerFactory factory = entityManagerFactory().getObject();
		return new JpaTransactionManager(factory);
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		
		vendorAdapter.setGenerateDdl(Boolean.TRUE);
		vendorAdapter.setShowSql(Boolean.TRUE);
		
		factory.setDataSource(dataSource());
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setPackagesToScan("demo.user");
		
		Properties jpaProperties = new Properties();
		jpaProperties.put("hibernate.hbm2ddl.auto",environment.getProperty("hibernate.hbm2ddl.auto"));
		factory.setJpaProperties(jpaProperties);
		factory.afterPropertiesSet();
		
		factory.setLoadTimeWeaver(new InstrumentationLoadTimeWeaver());
		return factory;
	}

	@Bean
	public HibernateExceptionTranslator hibernateExceptionTranslator() {
		return new HibernateExceptionTranslator();
	}

	@Resource
	private Environment environment;

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName(environment
				.getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER));
		dataSource.setUrl(environment
				.getRequiredProperty(PROPERTY_NAME_DATABASE_URL));
		dataSource.setUsername(environment
				.getRequiredProperty(PROPERTY_NAME_DATABASE_USERNAME));
		dataSource.setPassword(environment
				.getRequiredProperty(PROPERTY_NAME_DATABASE_PASSWORD));

		return dataSource;
	}
	
//	@Bean
//	public ServletRegistrationBean servletRegistrationBean(){
//	    VaadinServlet vaadinServlet = new VaadinServlet();
//	    ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(vaadinServlet,"/");
//	    servletRegistrationBean.addUrlMappings("/VAADIN/*");
//	    servletRegistrationBean.addInitParameter(VaadinServlet.DEFAULT_WIDGETSET, "com.star.AppWidgetSet");
//	    servletRegistrationBean.addInitParameter("UI", "demo.ui.HelloWorldUI");
//	    servletRegistrationBean.addInitParameter("UIPROVIDER", "demo.config.SpringUIProvider");
//		return servletRegistrationBean;
//	}
	
//	@Override
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		if (!this.resourceProperties.isAddMappings()) {
//			return;
//		}
//
//		Integer cachePeriod = this.resourceProperties.getCachePeriod();
//		if (!registry.hasMappingForPattern("/webjars/**")) {
//			registry.addResourceHandler("/webjars/**")
//					.addResourceLocations("classpath:/META-INF/resources/webjars/")
//					.setCachePeriod(cachePeriod);
//		}
//		if (!registry.hasMappingForPattern("/**")) {
//			registry.addResourceHandler("/**")
//					.addResourceLocations(RESOURCE_LOCATIONS)
//					.setCachePeriod(cachePeriod);
//		}
//	}
	
	@Bean
	public EntityManagerFactory entityManagerFactory() {

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(true);

		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setPackagesToScan("ims.star");
		factory.setDataSource(dataSource());
		factory.afterPropertiesSet();

		return factory.getObject();
	}

	@Bean
	public PlatformTransactionManager transactionManager() {

		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory());
		return txManager;
	}	
	*/
}
