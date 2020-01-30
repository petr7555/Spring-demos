package com.example.profiles;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @author Petr Janik 485122
 * @since 02/08/2019
 */
@Component
@Qualifier
@Target({ ElementType.TYPE, ElementType.PARAMETER, ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ProductionComponent {
}
