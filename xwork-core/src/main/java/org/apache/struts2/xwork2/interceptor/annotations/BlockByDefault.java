package org.apache.struts2.xwork2.interceptor.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Declares that by default fields on the {@link org.apache.struts2.xwork2.Action} class
 * are NOT permitted to be set from HttpRequest parameters.
 * To allow access to a field it must be annotated with {@link Allowed}
 *
 * @author martin.gilday
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface BlockByDefault {

}