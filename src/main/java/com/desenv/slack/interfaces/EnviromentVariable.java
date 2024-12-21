package com.desenv.slack.interfaces;

import java.lang.annotation.*;

/**
 *
 * @author matheus-de-souza-badia
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface EnviromentVariable {
    
    String value();
    String defaultValue() default "";
    boolean mandatory() default true;
    
}
