package com.example.profiles;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @author Petr Janik 485122
 * @since 02/08/2019
 */
@ProductionComponent
@Profile("production")
//@Primary
public class ProductionDatasourceConfig implements DatasourceConfig {
    @Override
    public void setup() {
        System.out.println("Setting up datasource for PRODUCTION environment. ");
    }
}
