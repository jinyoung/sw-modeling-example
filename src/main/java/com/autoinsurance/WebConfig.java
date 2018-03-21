package com.autoinsurance;

import org.metaworks.multitenancy.ClassManager;
import org.metaworks.multitenancy.MetadataService;
import org.metaworks.springboot.configuration.Metaworks4WebConfig;
import org.metaworks.multitenancy.persistence.MultitenantRepositoryImpl;
import org.metaworks.rest.MetaworksRestService;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.uengine.modeling.resource.LocalFileStorage;
import org.uengine.modeling.resource.Storage;


@EnableWebMvc
@Configuration
@ComponentScan(basePackageClasses = {MetaworksRestService.class, WebConfig.class, ClassManager.class, MetadataService.class, MultitenantRepositoryImpl.class})
@EnableJpaRepositories(repositoryBaseClass = MultitenantRepositoryImpl.class, basePackageClasses = {CustomerRepository.class})
@EntityScan(basePackageClasses = Customer.class)
public class WebConfig extends Metaworks4WebConfig {

//    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**")
                .allowedOrigins("http://localhost:8082", "http://localhost:8081", "*")
                .allowedMethods("POST", "GET", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("access_token", "Content-Type");

    }


    @Bean
    /**
     *
     * <bean class="CouchbaseStorage">
     *    <property name="basePath" value="/"/>
     <property name="bucketName" value="default"/>
     <property name="serverIp" value="localhost"/>
     </bean>
     */
    public Storage storage() {
        LocalFileStorage storage = new LocalFileStorage();
        storage.setBasePath("/oce/repository");

        return storage;
    }

//    @Bean
//    public TenantAwareFilter tenantAwareFilter(){
//        return new TenantAwareFilter();
//    }


//    @Bean
//    @Primary
//    public JpaProperties jpaProperties() {
//
//        JpaProperties propertiesMap = new JpaProperties();
//        propertiesMap.getProperties().put(PersistenceUnitProperties.DDL_GENERATION, PersistenceUnitProperties.CREATE_OR_EXTEND);
//
//        return propertiesMap;
//    }



}