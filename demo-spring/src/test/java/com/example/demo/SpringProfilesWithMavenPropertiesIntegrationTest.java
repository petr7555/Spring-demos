package com.example.demo;

import com.example.profiles.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

/**
 * @author Petr Janik 485122
 * @since 02/08/2019
 */
@ActiveProfiles({"dev", "production"})
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MyConf.class})
public class SpringProfilesWithMavenPropertiesIntegrationTest {
    @Autowired
    ApplicationContext applicationContext;
    @Autowired
    @ProductionComponent
//  @Qualifier(value = "prodComp")
//  List<DatasourceConfig> datasourceConfig;
    DatasourceConfig datasourceConfig;

    @Test
    public void setupDatasource() {
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        System.out.println("_______________");
        System.out.println(Arrays.toString(beanDefinitionNames));
        System.out.println("_______________");

//        datasourceConfig.get(0);
    }
}