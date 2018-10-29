package org.changcheng.selenium1019.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//Ctrl+shift+o
@Retention(RetentionPolicy.RUNTIME) 
@Target({ElementType.METHOD})
public @interface Retry {
	int times();
}
